/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Emotion {

    private int idEmotion;
    private String email;
    private int articleId;
    private String emotionName;

    public Emotion() {
    }

    public Emotion(int idEmotion, String email, int articleId, String emotionName) {
        this.idEmotion = idEmotion;
        this.email = email;
        this.articleId = articleId;
        this.emotionName = emotionName;
    }

    public Emotion(String email, int articleId, String emotionName) {

        this.email = email;
        this.articleId = articleId;
        this.emotionName = emotionName;
    }

    public int getIdEmotion() {
        return idEmotion;
    }

    public void setIdEmotion(int idEmotion) {
        this.idEmotion = idEmotion;
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

    public String getEmotionName() {
        return emotionName;
    }

    public void setEmotionName(String emotionName) {
        this.emotionName = emotionName;
    }
    
}
