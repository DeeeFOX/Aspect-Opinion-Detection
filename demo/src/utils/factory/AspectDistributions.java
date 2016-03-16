package utils.factory;

import models.AspectDistribution;
import models.RelationPair;

/**
 * Created by Chiu on 2016/3/12.
 */
public class AspectDistributions {

    public static AspectDistribution build(RelationPair pair) {
        AspectDistribution ad = new AspectDistribution();
        ad.setAspect(pair.getAspect());
        ad.add(pair);
        return ad;
    }
}
