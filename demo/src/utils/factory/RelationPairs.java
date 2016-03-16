package utils.factory;

import models.RelationPair;
import models.Term;

/**
 * Created by Chiu on 2016/3/12.
 */
public class RelationPairs {
    public static RelationPair build(long id, Term aterm, Term oterm) {
        RelationPair pair = null;
        if (aterm.getNature().equals("n")
                && (oterm.getNature().equals("n") || oterm.getNature().equals("a"))) {
            pair = new RelationPair();
            pair.setCommentId(id);
            pair.setAspect(aterm);
            pair.setOpinion(oterm);
        } else if (oterm.getNature().equals("n")
                && (aterm.getNature().equals("n") || aterm.getNature().equals("a"))) {
            pair = new RelationPair();
            pair.setCommentId(id);
            pair.setOpinion(aterm);
            pair.setAspect(oterm);
        } else if (aterm.getNature().equals("v")
                && (oterm.getNature().equals("n") || oterm.getNature().equals("a"))) {
            pair = new RelationPair();
            pair.setCommentId(id);
            pair.setAspect(aterm);
            pair.setOpinion(oterm);
        } else if (oterm.getNature().equals("v")
                && (aterm.getNature().equals("n") || aterm.getNature().equals("a"))) {
            pair = new RelationPair();
            pair.setCommentId(id);
            pair.setOpinion(aterm);
            pair.setAspect(oterm);
        }
        return pair;
    }
}
