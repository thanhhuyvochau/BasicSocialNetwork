/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Article;
import model.Comment;
import model.Emotion;
import model.Page;
import model.User;
import service.ArticleService;
import service.CommentService;
import service.EmotionService;

/**
 *
 * @author ADMIN
 */
public class DetailArticleServlet extends HttpServlet {

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

        EmotionService emotionService = new EmotionService();
        ArticleService arService = new ArticleService();
        CommentService commentService = new CommentService();

        String idString = request.getParameter("txtArticleId");
        String url = "/view/detail.jsp";

        try {
            int id = Integer.parseInt(idString);
            Article ar = arService.loadArticleById(id);
            Vector<Comment> comments = commentService.getCommentByArticle(id);
            Emotion likeEmotion = new Emotion();
            //get Num Of Like
            likeEmotion.setArticleId(id);
            likeEmotion.setEmail(user.getEmail().trim());
            likeEmotion.setEmotionName("like");
            Vector<Emotion> likeList = emotionService.getEmotionOfArticle(likeEmotion);
            int numOfLike = likeList.size();

            Emotion dislikeEmotion = new Emotion();
            //get Num Of Dislike
            dislikeEmotion.setArticleId(id);
            dislikeEmotion.setEmail(user.getEmail().trim());
            dislikeEmotion.setEmotionName("dislike");
            Vector<Emotion> dislikeList = emotionService.getEmotionOfArticle(dislikeEmotion);
            int numOfDislike = dislikeList.size();
            //get UserAction
            Emotion emotionUser = emotionService.getEmotionOfUser(id, user.getEmail().trim());
            request.setAttribute("article", ar);
            request.setAttribute("comments", comments);
            request.setAttribute("likeNumber", numOfLike);
            request.setAttribute("dislikeNumber", numOfDislike);
            if (emotionUser != null) {
                request.setAttribute("actionOfUser", emotionUser.getEmotionName().trim());
            }
        } catch (Exception e) {
            //log
            url = "/view/error.jsp";
        }

        request.getRequestDispatcher(url).forward(request, response);
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
