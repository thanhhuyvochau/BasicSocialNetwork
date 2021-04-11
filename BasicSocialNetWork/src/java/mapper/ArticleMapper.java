/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import java.sql.ResultSet;
import java.util.Date;
import model.Article;

/**
 *
 * @author ADMIN
 */
public class ArticleMapper implements MapperInterface<Article> {

    public ArticleMapper() {
    }

    public Article mapper(ResultSet result) {
        Article article = null;
        try {
            int idArticle = result.getInt("id");
            String title = result.getString("title");
            String img = result.getString("img");
            Date datePost = result.getDate("date_post");
            String postContent = result.getString("post_content");
            String description = result.getString("description");
            String email = result.getString("email");
            String status = result.getString("status").trim();
            article = new Article(idArticle, title, img, datePost, postContent, email, status,description);
        } catch (Exception e) {
            //log
        }
        return article;
    }

}
