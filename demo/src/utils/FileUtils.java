package utils;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import models.Comment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import procs.CommentConvertProc;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by root on 16-3-9.
 */
public class FileUtils {

    private static Logger logger = LogManager.getLogger(FileUtils.class);

    public static void main(String[] args) {
        try {
            List<Comment> comments = Files.readLines(new File("data/tmall_comment.csv"), Charset.forName("gbk"), new CommentConvertProc());
            System.out.println(comments.size());
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        ;
    }

}
