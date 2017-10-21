package factchecking.comparator;

import org.apache.commons.text.similarity.*;
import java.util.*;
import java.util.stream.*;


public class CosineComparator {
    private static CosineSimilarity sim = new CosineSimilarity();
    private double checkSimilarity(String inputNews, String foundNews) {
        Map<CharSequence, Integer> leftVector = Arrays.stream(inputNews.split("")).collect(Collectors.toMap(c -> c, c -> 1, Integer::sum));
        Map<CharSequence, Integer> rightVector = Arrays.stream(foundNews.split("")).collect(Collectors.toMap(c -> c, c -> 1, Integer::sum));
        return sim.cosineSimilarity(leftVector, rightVector);
    }
    public double compareNews(String src, List<String> dst) {
        double ans = 0;
        double tmp = 0;
        for (String article : dst) {
            tmp = checkSimilarity(src, article);
//            System.out.println(tmp);
            ans += tmp;
        }
        return ans / dst.size();
    }
}