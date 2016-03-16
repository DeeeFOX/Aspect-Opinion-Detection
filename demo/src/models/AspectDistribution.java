package models;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by Chiu on 2016/3/12.
 */
public class AspectDistribution {
    private Term aspect;
    private Map<String, Integer> opinionCounts;
    private Map<String, Double> opinionDistribution;

    public AspectDistribution() {
        opinionCounts = Maps.newHashMap();
        opinionDistribution = Maps.newHashMap();
    }

    public Term getAspect() {
        return aspect;
    }

    public void setAspect(Term aspect) {
        this.aspect = aspect;
    }

    public Map<String, Integer> getOpinionCounts() {
        return opinionCounts;
    }

    public void setOpinionCounts(Map<String, Integer> opinionCounts) {
        this.opinionCounts = opinionCounts;
    }

    public Map<String, Double> getOpinionDistribution() {
        return opinionDistribution;
    }

    public void setOpinionDistribution(Map<String, Double> opinionDistribution) {
        this.opinionDistribution = opinionDistribution;
    }

    public void add(RelationPair pair) {
        Integer count = opinionCounts.get(pair.getAspect().getWord());
        if (null == count) {
            opinionCounts.put(pair.getOpinion().getWord(), 1);
        } else {
            opinionCounts.put(pair.getOpinion().getWord(), count + 1);
        }
    }
}
