package factchecking;

import factchecking.news.HttpHelper;
import factchecking.news.YaNews;
import factchecking.textprocessing.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactChecking {
    public Integer api(String src, String externalLink) {
        //Create list for requests to news.ya
        List<String> requestToYa = new ArrayList<>();

        //Open link from post VK
        YaNews ya = new YaNews();
        List<String> responseFromYa = new ArrayList<>();

        if (!externalLink.isEmpty()) {
            try {
                String title = HttpHelper.getTitleOnPage(externalLink);
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

        return 0;//Return result (double)
    }

    //Delete trash and transform words to normal form

}
