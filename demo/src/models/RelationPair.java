package models;

/**
 * Created by Chiu on 2016/3/12.
 */
public class RelationPair {
    private long commentId;
    private Term aspect;
    private Term opinion;

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public Term getAspect() {
        return aspect;
    }

    public void setAspect(Term aspect) {
        this.aspect = aspect;
    }

    public Term getOpinion() {
        return opinion;
    }

    public void setOpinion(Term opinion) {
        this.opinion = opinion;
    }
}
