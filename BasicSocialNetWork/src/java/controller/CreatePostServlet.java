/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import error.ArticleState;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Article;
import model.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.ArticleService;

/**
 *
 * @author ADMIN
 */
public class CreatePostServlet extends HttpServlet {

    final static String ERROR = "/view/post.jsp";
    final static String SUCCESS = "HomePageServlet";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //check User
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("identify");
        String userEmail = "";
        if (user == null) {
            response.sendRedirect("/view/login.jsp");

        } else if (user.getStatus().trim().equalsIgnoreCase("new")) {
            response.sendRedirect("/view/verify.jsp");
        } else if (user.getStatus().trim().equalsIgnoreCase("active")) {
            userEmail = user.getEmail().trim();
        }
        String url = ERROR;
        ArticleService service = new ArticleService();

        String email = userEmail;
        String title = "";
        String imgPath = "";
        String description = "";
        String content = "";

        File file = null;
        FileItem imgToSave = null;
        DiskFileItemFactory factory = new DiskFileItemFactory();

// Configure a repository (to ensure a secure temp location is used)
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);

// Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

// Parse the request
        List<FileItem> items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException ex) {
            ex.printStackTrace();
        }
        Iterator<FileItem> iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = iter.next();

            if (item.isFormField()) {
                if (item.getFieldName().equalsIgnoreCase("txtTitle")) {
                    title = item.getString();
                    request.setAttribute("title", title);
                } else if (item.getFieldName().equalsIgnoreCase("txtDescription")) {
                    description = item.getString();
                    request.setAttribute("description", description);
                } else if (item.getFieldName().equalsIgnoreCase("txtContent")) {
                    content = item.getString();
                    request.setAttribute("content", content);
                }
            } else {
                String filename = item.getName();
                if (filename == null || filename.equals("")) {
                    break;

                } else {
                    imgToSave = item;
                    if (imgToSave.getContentType().equals("image/png") || imgToSave.getContentType().equals("image/jpg") || imgToSave.getContentType().equals("image/jpeg")) {
                        Path path = Paths.get(filename);
                        String storePathForFile = servletContext.getRealPath("/image");
                        imgPath = "./image/" + path.getFileName();
                        String imgPathFolder = storePathForFile + "\\" + path.getFileName();
                        file = new File(imgPathFolder);

                    } else {
                        request.setAttribute("message", "Image format not support, it must be png/jpg!");
                        request.getRequestDispatcher(url).forward(request, response);
                    }
                }

            }
        }

        Article article = new Article(title, imgPath, new Date(), content, email, "active", description);
        ArticleState state = service.postArticle(article);
        if (state.getMessage().equals(ArticleState.SUCCESS)) {
            url = SUCCESS;
            if (file != null) {
                try {
                    imgToSave.write(file);
                } catch (Exception e) {
                    //log

                }

            }

        } else {
            request.setAttribute("title", title);
            request.setAttribute("description", description);
            request.setAttribute("content", content);
            request.setAttribute("message", state.getMessage());
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        if (url.equals(ERROR)) {
            request.setAttribute("message", state.getMessage());
            request.getRequestDispatcher(url).forward(request, response);
        } else if (url.equals(SUCCESS)) {
            response.sendRedirect("HomePageServlet");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
