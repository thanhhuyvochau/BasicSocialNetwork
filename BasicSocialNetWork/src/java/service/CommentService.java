/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.CommentDao;
import java.util.Date;
import java.util.Vector;
import model.Comment;

/**
 *
 * @author ADMIN
 */
public class CommentService {

    private CommentDao commentDao;

    public CommentService() {
        commentDao = new CommentDao();
    }

    public Vector<Comment> getCommentByArticle(int articleId) {
        Vector<Comment> commentList = commentDao.getCommentByArticle(articleId);
        return commentList;
    }

    public boolean postComment(String commentContent, int articleId, String email) {
        if (commentContent.length() == 0) {
            return false;
        }
        Comment comment = new Comment();
        comment.setArticleId(articleId);
        comment.setEmail(email);
        comment.setDateComment(new Date());
        comment.setCommentContent(commentContent);
        commentDao.postComment(comment);
        return true;
    }

}
