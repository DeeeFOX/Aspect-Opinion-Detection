package handlers;

import handlers.base.HandlerBase;
import models.Comment;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import utils.FileUtils;

import java.util.List;

/**
 * Created by root on 16-3-10.
 */
public class SegHandler extends HandlerBase {

    public static void main(String[] args) {
        List<Comment> comments = FileUtils.readComments();
        for (Comment comment : comments) {
            List<Term> terms = ToAnalysis.parse(comment.getContent());
            System.out.println(terms);
        }
    }
}
