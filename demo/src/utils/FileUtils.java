package utils;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import conf.Config;
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

    public static List<Comment> readComments() {
        try {
            List<Comment> comments = Files.readLines(new File(Config.DATA_INPUT_RAWDATA), Charset.forName(Config.CHARSET_GBK), new CommentConvertProc());
            return comments;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return null;
    }

    public static List<Comment> readComments(String path, Charset charset) {
        try {
            List<Comment> comments = Files.readLines(new File(path), charset, new CommentConvertProc());
            return comments;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return null;
    }
}
