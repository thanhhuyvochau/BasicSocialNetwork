/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import service.ArticleService;

/**
 *
 * @author ADMIN
 */
public class DeletePostServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
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
        String article = request.getParameter("txtArticleId");
        if (article != null) {
            int articleIdInt = 0;
            try {
                articleIdInt = Integer.parseInt(article);
            } catch (Exception e) {
                articleIdInt = -1;
            }
            if (articleIdInt < 0) {
                response.sendRedirect("/view/error.jsp");
            } else {
                ArticleService arService = new ArticleService();
                boolean deleteResult = arService.deleteArticle(articleIdInt);
                if (deleteResult) {
                    response.sendRedirect("MainController?action=mypostRedirect&message=Delete%20Success");
                } else {
                    response.sendRedirect("MainController?action=mypostRedirect&message=Delete%20Fail");
                }
            }

        } else {
            response.sendRedirect("/view/error.jsp");
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
