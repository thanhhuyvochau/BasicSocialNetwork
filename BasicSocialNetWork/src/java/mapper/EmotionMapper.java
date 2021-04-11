/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import java.sql.ResultSet;
import model.Emotion;

/**
 *
 * @author ADMIN
 */
public class EmotionMapper implements MapperInterface<Emotion> {

    public EmotionMapper() {
    }

    public Emotion mapper(ResultSet result) {
        Emotion emotion = null;
        try {
            int idEmotion = result.getInt("id");
            String email = result.getString("email");
            int articleId = result.getInt("article_id");
            String emotionName = result.getString("emotion_type");
            emotion = new Emotion(idEmotion, email, articleId, emotionName);
        } catch (Exception e) {
            //log
        }
        return emotion;
    }

}
