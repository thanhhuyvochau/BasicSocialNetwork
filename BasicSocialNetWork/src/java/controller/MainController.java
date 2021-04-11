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

/**
 *
 * @author ADMIN
 */
public class MainController extends HttpServlet {

    final static String LOGIN_ACTION = "login";
    final static String LOGIN_CONTROLLER = "LoginServlet";
    final static String LOGIN_PAGE = "/view/login.jsp";
    final static String REGISTER_FORWARD = "registerRedirect";
    final static String REGISTER_ACTION = "register";
    final static String REGISTER_CONTROLLER = "RegisterServlet";
    final static String REGISTER_PAGE = "/view/register.jsp";
    final static String VERIFY_ACTION = "verify";
    final static String VERIFY_CONTROLLER = "VerifyServlet";
    final static String VERIFY_PAGE = "/view/verify.jsp";
    final static String RESEND_ACTION = "resend";
    final static String RESEND_CONTROLLER = "ResendVerifyServlet";
    final static String LOGOUT_ACTION = "logout";
    final static String LOGOUT_CONTROLLER = "LogoutServlet";
    final static String ADD_POST_FORWARD = "addPostRedirect";
    final static String ADD_POST_ACTION = "add-post";
    final static String ADD_POST_CONTROLLER = "CreatePostServlet";
    final static String ADD_POST_PAGE = "/view/post.jsp";
    final static String HOMEPAGE_ACTION = "homepage";
    final static String HOMEPAGE_CONTROLLER = "HomePageServlet";
    final static String HOMEPAGE_PAGE = "/view/homepage.jsp";
    final static String DETAIL_ACTION = "detail";
    final static String DETAIL_CONTROLLER = "DetailArticleServlet";
    final static String DETAIL_PAGE = "detail.jsp";
    final static String SEARCH_ACTION = "search";
    final static String SEARCH_CONTROLLER = "SearchServlet";
    final static String COMMENT_ACTION = "comment";
    final static String COMMENT_CONTROLLER = "CommentServlet";
    final static String DELETE_POST_ACTION = "delete";
    final static String DELETE_CONTROLLER = "DeletePostServlet";
    final static String MY_POST_REDIRECT = "mypostRedirect";
    final static String MY_POST_CONTROLLER = "MyPostController";
    final static String EMOTION_ACTION = "emotion";
    final static String EMOTION_CONTROLLER = "EmotionServlet";

    // mot hoi chinh dieu huong home page cho header gio di an com roi
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
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("identify");
        String action = request.getParameter("action");
        String z = request.getParameter("test");
        String url = LOGIN_PAGE;

        if (action == null) {
            action = "";
        }

        if (user == null) {
            if (action.equalsIgnoreCase(LOGIN_ACTION)) {
                url = LOGIN_CONTROLLER;
            } else if (action.equalsIgnoreCase(LOGIN_ACTION)) {
                url = LOGIN_PAGE;
            } else if (action.equalsIgnoreCase(REGISTER_FORWARD)) {
                url = REGISTER_PAGE;
            } else if (action.equalsIgnoreCase(REGISTER_ACTION)) {
                url = REGISTER_CONTROLLER;
            }
        } else if (user.getStatus().equalsIgnoreCase("new")) {
            if (action.equalsIgnoreCase(VERIFY_ACTION)) {
                url = VERIFY_CONTROLLER;
            } else if (action.equalsIgnoreCase(RESEND_ACTION)) {
                url = RESEND_CONTROLLER;
            } else {
                url = VERIFY_PAGE;
            }
        } else if (user.getStatus().equalsIgnoreCase("active")) {
            if (action.equalsIgnoreCase(LOGOUT_ACTION)) {
                url = LOGOUT_CONTROLLER;
            } else if (action.equalsIgnoreCase(ADD_POST_FORWARD)) {
                url = ADD_POST_PAGE;
            } else if (action.equalsIgnoreCase(ADD_POST_ACTION)) {
                url = ADD_POST_CONTROLLER;
            } else if (action.equalsIgnoreCase(DETAIL_ACTION)) {
                url = DETAIL_CONTROLLER;
            } else if (action.equalsIgnoreCase(SEARCH_ACTION)) {
                url = SEARCH_CONTROLLER;
            } else if (action.equalsIgnoreCase(COMMENT_ACTION)) {
                url = COMMENT_CONTROLLER;
            } else if (action.equalsIgnoreCase(DELETE_POST_ACTION)) {
                url = DELETE_CONTROLLER;
            } else if (action.equalsIgnoreCase(MY_POST_REDIRECT)) {
                url = MY_POST_CONTROLLER;
            } else if (action.equalsIgnoreCase(EMOTION_ACTION)) {
                url = EMOTION_CONTROLLER;
            } else {
                url = HOMEPAGE_CONTROLLER;
            }
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
