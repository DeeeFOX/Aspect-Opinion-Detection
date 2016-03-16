package utils.factory;

import models.Comment;

/**
 * Created by root on 16-3-9.
 */
public class Comments {
    public static Comment build(int id, String content) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setContent(content);
        return comment;
    }
}
