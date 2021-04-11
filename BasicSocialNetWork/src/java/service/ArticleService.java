/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ArticleDao;
import error.ArticleState;
import java.util.Vector;
import model.Article;
import model.Page;
import validation.ArticleValidator;

/**
 *
 * @author ADMIN
 */
public class ArticleService {

    private ArticleDao arDao;
    private ArticleValidator validtor;

    public ArticleService() {
        arDao = new ArticleDao();
        validtor = new ArticleValidator();
    }

    public ArticleState postArticle(Article article) {
        ArticleState state = validtor.checkArticle(article);
        if (state.getMessage().equals(ArticleState.SUCCESS)) {
            arDao.postArticle(article);
        }
        return state;
    }

    public Vector<Article> loadAllArticleByStatus(Page page) {
        page = arDao.getAllArticleByStatusPaging(page);
        int start = page.getIndexPage() * page.getNumObjectInPage() - page.getNumObjectInPage();
        int end = page.getNumObjectInPage();
        Vector<Article> listArticle = arDao.getAllArticleByStatus(start, end);
        return listArticle;
    }

    public Article loadArticleById(int id) {
        Article ar = null;
        ar = arDao.getArticleById(id);
        return ar;
    }

    public Vector<Article> searchByContent(String content, Page page) {
        Vector<Article> arList = null;
        page = arDao.searchByContentPaging(content, page);
        int start = page.getIndexPage() * page.getNumObjectInPage() - page.getNumObjectInPage();
        int end = page.getNumObjectInPage();
        arList = arDao.searchByContent(content, start, end);
        return arList;
    }

    public boolean deleteArticle(int articleId) {
        boolean result = false;
        result = arDao.deletePost(articleId);
        return result;
    }

    public Vector<Article> searchByUser(String email, Page page) {
        Vector<Article> arList = null;
        page = arDao.getAllArticleByUserPaging(page,email);
        int start = page.getIndexPage() * page.getNumObjectInPage() - page.getNumObjectInPage();
        int end = page.getNumObjectInPage();
        arList = arDao.getAllArticleByUser(email, start, end);
        return arList;
    }

//    public static void main(String[] args) {
//        ArticleService z  = new ArticleService();
//        Page sa = new Page();
//        Vector<Article> s = z.searchByContent("da",sa);
//        System.out.println("TOTAL:"+sa.getTotalRecordNum());
//        
//    }
}
