package factchecking.comparator;

import factchecking.textprocessing.DeleteTrash;
import factchecking.textprocessing.Stemmer;

import java.util.*;

public class Comparator {
    private String[] removeDuplicates(String src){
        String[] src_arr = src.split(" ");
        Set<String> mySet = new HashSet<>(Arrays.asList(src_arr));
        return mySet.toArray(new String[mySet.size()]);
    }
    public double compareNews(String src, List<String> dst) {
        if (dst.size() <= 3)
            return -1;
        String[] arr = this.removeDuplicates(src);
        double[] count = new double[arr.length];
        for (String article : dst) {
            for (int i = 0; i < arr.length; i++){
                if (article.contains(arr[i]))
                    count[i] += 1;
            }
        }
        System.out.println(src);
        return Arrays.stream(count).map(x -> (x / dst.size())).sum() / arr.length;
    }
}