package factchecking;

import factchecking.news.HttpHelper;
import factchecking.news.YaNews;
import factchecking.textprocessing.*;
import factchecking.comparator.Comparator;
import factchecking.comparator.CosineComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactChecking {
    public double api(String src, String link) {
        //Create list for requests to news.ya
        List<String> requestToYa = new ArrayList<>();

        //Open link from post VK
        YaNews ya = new YaNews();
        List<String> responseFromYa = new ArrayList<>();

        if (!link.isEmpty()) {
            try {
                String title = HttpHelper.getTitleOnPage(link);
                requestToYa.add(title);
                responseFromYa = ya.getNewsTexts(requestToYa);
            } catch (Exception err) {}
        }
        if (responseFromYa.size() == 0) {
            try {
                requestToYa.clear();
                //Split by dot all text
                requestToYa.addAll(Arrays.asList(src.split("\\.")));
                //Delete stop words, punctuation marks
                requestToYa.replaceAll(s -> new DeleteTrash().deleteTrash(s));
                responseFromYa = ya.getNewsTexts(requestToYa);
            } catch (Exception err) {}
        }

        Normalizer normalizer = new Normalizer();
        //Stemmer to request
        String requestAfterStem = normalizer.normalizeStr(src);

        //Stemmer to response
        List<String> responseFromYaAfterStemming = normalizer.normalizeList(responseFromYa);

        //Comparator
        Comparator cmp = new Comparator();
//        CosineComparator cmp = new CosineComparator();
        return cmp.compareNews(requestAfterStem, responseFromYaAfterStemming);
    }
}
