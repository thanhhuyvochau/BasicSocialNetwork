/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import error.ArticleState;
import model.Article;

/**
 *
 * @author ADMIN
 */
public class ArticleValidator extends AbstractValidtor {

    public boolean validTitle(String title) {
        if(title == null){
            title = "";
        }
        boolean result = false;
        if (title.length() > 0 && title.length() <= 100) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean validDescription(String description) {
          if(description == null){
            description = "";
        }
        boolean result = false;
        if (description.length() > 0 && description.length() <= 200) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean validContent(String content) {
          if(content == null){
            content = "";
        }
        boolean result = false;
        if (content.length() > 0) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public ArticleState checkArticle(Article article) {
        ArticleState state = new ArticleState();
        if (!validTitle(article.getTitle().trim())) {
            state.setMessage(ArticleState.TITLE_ERROR);
        } else if (!validDescription(article.getDescription().trim())) {
            state.setMessage(ArticleState.DESCRIPTION_ERROR);
        } else if (!validContent(article.getContent())) {
            state.setMessage(ArticleState.CONTENT_ERROR);
        } else {
            state.setMessage(ArticleState.SUCCESS);
        }
        return state;
    }
}
