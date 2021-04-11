/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.EmotionDao;
import java.util.Vector;
import model.Emotion;

/**
 *
 * @author ADMIN
 */
public class EmotionService {

    private EmotionDao emotionDao;

    public EmotionService() {
        emotionDao = new EmotionDao();
    }

    public boolean doEmotion(Emotion emotion) {
        boolean result = false;
        String type = emotion.getEmotionName().trim();
        if (type.equalsIgnoreCase("like") || type.equalsIgnoreCase("dislike")) {
            String emotionName = emotion.getEmotionName().trim();
            String email = emotion.getEmail().trim();
            int articleId = emotion.getArticleId();
            boolean existEmotion = emotionDao.checkEmotion(articleId, email);
            if (existEmotion == false) {
                emotionDao.deleteEmotion(articleId, email);
                emotionDao.doEmotion(articleId, email, emotionName);
                result = true;
            } else {
                emotionDao.doEmotion(articleId, email, emotionName);
                result = true;
            }
        }
        return result;
    }
    public Vector<Emotion> getEmotionOfArticle(Emotion emotion){
        Vector<Emotion> emotionList = emotionDao.getEmotionOfArticle(emotion.getArticleId(),emotion.getEmotionName());
        return emotionList;
    }
    public Emotion getEmotionOfUser(int articleId,String email){
        Vector<Emotion> emotionList = emotionDao.getEmotionOfUser(articleId, email);
        Emotion emotion = null;
        if(emotionList.size()>0){
            emotion = emotionList.get(0);
        }
        return emotion;
    }
}
