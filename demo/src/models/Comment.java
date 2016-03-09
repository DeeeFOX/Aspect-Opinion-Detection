package models;

import models.base.TextBase;

/**
 * Created by root on 16-3-9.
 */
public class Comment extends TextBase{
    private int id;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
