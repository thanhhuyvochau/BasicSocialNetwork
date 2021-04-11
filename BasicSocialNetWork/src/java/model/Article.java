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
public class Article {

    private int id;
    private String title;
    private String img;
    private Date postDate;
    private String content;
    private String email;
    private String status;
    private String description;

    public Article() {
    }

    public Article(String title, String img, Date postDate, String content, String email, String status, String description) {
        this.title = title;
        this.img = img;
        this.postDate = postDate;
        this.content = content;
        this.email = email;
        this.status = status;
        this.description = description;
    }

    public Article(int id, String title, String img, Date postDate, String content, String email, String status, String description) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.postDate = postDate;
        this.content = content;
        this.email = email;
        this.status = status;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getDateString(){
        return DateConvert.convertDateToString(postDate,"dd-MM-yyyy");
    }

}
