package procs;

import com.google.common.collect.Lists;
import com.google.common.io.LineProcessor;
import models.Comment;
import utils.convert.CommentConvertor;

import java.io.IOException;
import java.util.List;

/**
 * Created by Chiu on 2016/3/10.
 */
public class CommentConvertProc implements LineProcessor<List<Comment>> {
    private List<Comment> comments = Lists.newLinkedList();
    @Override
    public boolean processLine(String line) throws IOException {
        comments.add(CommentConvertor.str2Comment(line));
        return true;
    }

    @Override
    public List<Comment> getResult() {
        return comments;
    }
}
