package utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import conf.Config;
import models.AspectDistribution;
import models.Comment;
import models.RelationPair;
import models.Term;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import procs.CommentConvertProc;
import utils.factory.AspectDistributions;
import utils.factory.RelationPairs;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

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

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readLines(new File("data/relationPairs_result.csv"), Charset.forName(Config.CHARSET_GBK));
        List<RelationPair> pairs = Lists.newLinkedList();
        Files.newWriter(new File())
        for (String line : lines) {
            String[] split = line.split("\t");
            long id = Long.parseLong(split[0]);
            String[] astr = split[1].split("/");
            Term aterm = new Term(astr[0], astr[1]);
            String[] ostr = split[2].split("/");
            Term oterm = new Term(ostr[0], ostr[1]);
            RelationPair pair = RelationPairs.build(id, aterm, oterm);
            if (pair != null) {
                pairs.add(pair);
            }
        }
        Map<String, AspectDistribution> map = Maps.newHashMap();
        for (RelationPair pair : pairs) {
            if (map.containsKey(pair.getAspect().getWord())) {
                AspectDistribution ad = map.get(pair.getAspect().getWord());
                ad.add(pair);
            } else {
                AspectDistribution ad = AspectDistributions.build(pair);
                map.put(pair.getAspect().getWord(), ad);
            }
        }
        System.out.println(map.size());
        for (AspectDistribution ad : map.values()) {
            if (ad.getOpinionCounts().size() >=2 || ad.getOpinionCounts().values().iterator().next() > 1) {
                System.out.print(ad.getAspect().getWord() + "\t");
                System.out.println(ad.getOpinionCounts());
            }
        }
    }
}
