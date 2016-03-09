package utils.convert;

import conf.Config;
import models.Comment;
import utils.factory.CommentFactory;

/**
 * Created by root on 16-3-9.
 */
public class CommentConvertor {

    /**
     *
     * parse the string to comment object
     *
     * @param str string input
     *
     * @return a comment structure object
     */
    public static Comment str2Comment(String str) {
        String[] strArr = str.split(Config.splitDefault);
        int id = Integer.parseInt(strArr[0]);
        String content = strArr[19];
        return CommentFactory.build(id, content);
    }
}
