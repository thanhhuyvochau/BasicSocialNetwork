/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Vector;
import mapper.CommentMapper;
import model.Comment;

/**
 *
 * @author ADMIN
 */
public class CommentDao extends AbstractDao<Comment> {

    public CommentDao() {
    }

    public Vector<Comment> getCommentByArticle(Integer articleId) {
        String sql = "SELECT id,email,article_id,comment_content,date\n"
                + "FROM comments\n"
                + "WHERE article_id = ?";
        Vector<Comment> commentList = query(sql, new CommentMapper(), articleId);
        return commentList;
    }

    public boolean postComment(Comment comment) {
        String sql = "INSERT INTO comments (email,article_id,comment_content,date)\n"
                + "VALUES(?,?,?,?)";
        boolean result = updateQuery(sql, comment.getEmail().trim(), comment.getArticleId(), comment.getCommentContent().trim(), comment.getDateComment());
        return result;
    }

}
