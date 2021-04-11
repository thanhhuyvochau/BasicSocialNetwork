/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import java.sql.ResultSet;
import java.util.Date;
import model.Comment;

/**
 *
 * @author ADMIN
 */
public class CommentMapper implements MapperInterface<Comment> {

    public CommentMapper() {
    }

    public Comment mapper(ResultSet result) {
        Comment comment = null;
        try {
            int id = result.getInt("id");
            String email = result.getString("email");
            int articleId = result.getInt("article_id");
            String commentContent = result.getString("comment_content");
            Date date = result.getDate("date");
            comment = new Comment(id, email, articleId, commentContent, date);
        } catch (Exception e) {
            //log
        }
        return comment;
    }

}
