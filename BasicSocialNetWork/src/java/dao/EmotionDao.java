/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Vector;
import mapper.EmotionMapper;
import model.Emotion;

/**
 *
 * @author ADMIN
 */
public class EmotionDao extends AbstractDao<Emotion> {

    public Vector<Emotion> getEmotionOfArticle(int articleId, String emotion) {
        String sql = "SELECT id,email,emotion_type,article_id\n"
                + "FROM emotions\n"
                + "WHERE article_id = ? AND emotion_type = ?";
        Vector<Emotion> emotionList = query(sql, new EmotionMapper(), articleId, emotion);
        return emotionList;
    }
    public Vector<Emotion> getEmotionOfUser(int articleId,String email) {
        String sql = "SELECT id,email,emotion_type,article_id\n"
                + "FROM emotions\n"
                + "WHERE article_id = ? AND email like ?";
        Vector<Emotion> emotionList = query(sql, new EmotionMapper(), articleId, email);
        return emotionList;
    }

    public boolean deleteEmotion(int articleId, String email) {
        String sql = "DELETE emotions WHERE article_id = ? AND email like ?";
        boolean result = updateQuery(sql, articleId, email);
        return result;
    }

    public boolean checkEmotion(int articleId, String email) {
        String sql = "SELECT id FROM emotions WHERE article_id = ? AND email like ?";
        Vector result = query(sql, new EmotionMapper(), articleId, email);
        if (result.size() > 0) {
            return false; // ton tai
        } else {
            return true; // khong ton tai
        }
    }

    public boolean doEmotion(int articleId, String email, String emotion) {
        String sql = "INSERT INTO emotions (email,emotion_type,article_id)\n"
                + "VALUES (?,?,?)";
        boolean result = updateQuery(sql, email, emotion, articleId);
        return result;
    }

}
