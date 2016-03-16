package models;

import models.base.TextBase;

import java.util.List;

/**
 * Created by root on 16-3-9.
 */
public class Comment extends TextBase{
    private int id;
    private String content;
    private List<RelationPair> pairs;

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
