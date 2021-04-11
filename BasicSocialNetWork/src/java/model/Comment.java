/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import ultis.DateConvert;

/**
 *
 * @author ADMIN
 */
public class Comment {

    private int id;
    private String email;
    private int articleId;
    private String commentContent;
    private Date dateComment;

    public Comment() {
    }

    public Comment(int id, String email, int articleId, String commentContent, Date dateComment) {
        this.id = id;
        this.email = email;
        this.articleId = articleId;
        this.commentContent = commentContent;
        this.dateComment = dateComment;
    }

    public Comment(String email, int articleId, String commentContent, Date dateComment) {

        this.email = email;
        this.articleId = articleId;
        this.commentContent = commentContent;
        this.dateComment = dateComment;
    }

    public Date getDateComment() {
        return dateComment;
    }

    public void setDateComment(Date dateComment) {
        this.dateComment = dateComment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
    public String getDateString(){
        return DateConvert.convertDateToString(dateComment,"dd-MM-yyyy");
    }

}
