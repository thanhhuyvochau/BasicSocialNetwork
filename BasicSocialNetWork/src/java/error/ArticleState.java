/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package error;

/**
 *
 * @author ADMIN
 */
public class ArticleState {

    final public static String TITLE_ERROR = "Title must not empty and not more than 100 characters!";
    final public static String DESCRIPTION_ERROR = "Description must not empty and not more than 200 characters!";
    final public static String CONTENT_ERROR = "Content must not empty!";
    final public static String SUCCESS = "Success";

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
