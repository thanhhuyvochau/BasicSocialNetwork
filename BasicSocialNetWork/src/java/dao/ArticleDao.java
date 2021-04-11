/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import java.util.Vector;
import mapper.ArticleMapper;
import model.Article;
import model.Page;

/**
 *
 * @author ADMIN
 */
public class ArticleDao extends AbstractDao<Article> {
//
//    public Vector<Article> getAllArticle(int start, int end) {
//
//    }
//
//    public Page getAllArticlePaging(Page page) {
//
//    }

    public Vector<Article> getAllArticleByStatus(int start, int end) {
        String sql = "SELECT id,title,img,date_post,post_content,description,email,status\n"
                + " FROM article\n"
                + " WHERE status = 'active'\n"
                + " ORDER BY date_post\n"
                + "OFFSET ? ROWS \n"
                + "FETCH NEXT ? ROWS ONLY";
        Vector<Article> arList = query(sql, new ArticleMapper(), start, end);
        return arList;
    }

    public Page getAllArticleByStatusPaging(Page page) {
        String sql = "SELECT id,title,img,date_post,post_content,description,email,status\n"
                + " FROM article\n"
                + " WHERE status = 'active'\n";

        Vector<Article> arList = query(sql, new ArticleMapper());
        page.setTotalRecordNum(arList);
        return page;
    }

    public Vector<Article> getAllArticleByUser(String email, int start, int end) {
        String sql = "SELECT id,title,img,date_post,post_content,description,email,status\n"
                + " FROM article\n"
                + " WHERE status = 'active' AND email like ?\n"
                + " ORDER BY date_post\n"
                + "OFFSET ? ROWS \n"
                + "FETCH NEXT ? ROWS ONLY";
        Vector<Article> arList = query(sql, new ArticleMapper(), email, start, end);
        return arList;
    }

    public Page getAllArticleByUserPaging(Page page,String email) {
        String sql = "SELECT id,title,img,date_post,post_content,description,email,status\n"
                + " FROM article\n"
                + " WHERE status = 'active' AND email like ?\n";
        Vector<Article> arList = query(sql, new ArticleMapper(),email);
        page.setTotalRecordNum(arList);
        return page;
    }

    public boolean postArticle(Article article) {
        String sql = "INSERT INTO article (title,img,date_post,post_content,description,email,status)\n"
                + "VALUES (?,?,?,?,?,?,?)";
        String title = article.getTitle();
        String img = article.getImg();
        String content = article.getContent();
        String description = article.getDescription();
        String email = article.getEmail();
        String status = article.getStatus();
        Date postDate = article.getPostDate();
        boolean result = false;
        result = updateQuery(sql, title, img, postDate, content, description, email, status);
        return result;
    }

    public Article getArticleById(Integer id) {
        String sql = "SELECT id,title,img,date_post,post_content,description,email,status\n"
                + " FROM article\n"
                + " WHERE status = 'active' AND id=?\n";
        Vector<Article> arList = query(sql, new ArticleMapper(), id);
        Article ar = null;
        if (arList.size() > 0) {
            ar = arList.get(0);
        }
        return ar;
    }

    public Vector<Article> searchByContent(String content, int start, int end) {
        String sql = "SELECT id,title,img,date_post,post_content,description,email,status\n"
                + " FROM article\n"
                + " WHERE status = 'active' AND post_content like ?\n"
                + " ORDER BY date_post\n"
                + "OFFSET ? ROWS \n"
                + "FETCH NEXT ? ROWS ONLY";
        Vector<Article> arList = query(sql, new ArticleMapper(), "%" + content + "%", start, end);

        return arList;
    }

    public Page searchByContentPaging(String content, Page page) {
        String sql = "SELECT id,title,img,date_post,post_content,description,email,status\n"
                + " FROM article\n"
                + " WHERE status = 'active' AND post_content like ?\n";

        Vector<Article> arList = query(sql, new ArticleMapper(), "%" + content + "%");
        page.setTotalRecordNum(arList);
        return page;
    }

    public boolean deletePost(int postId) {
        String sql = "UPDATE article\n"
                + "SET status = 'inactive'\n"
                + "WHERE id = ?;";
        boolean result = updateQuery(sql, postId);
        return result;
    }

    public static void main(String[] args) {
        ArticleDao z = new ArticleDao();
        System.out.println(z.deletePost(1));
    }
}
