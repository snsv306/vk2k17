package snsv.hackathon.factchecking;

import snsv.hackathon.factchecking.news.YaNews;
import snsv.hackathon.factchecking.textprocessing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactChecking {
    public Integer api(String src, String externalLink) {

        //Create list for requests to news.ya
        List<String> requestToYa = new ArrayList<>();

        //Open link from post VK
        YaNews ya = new YaNews();
        List<String> responseFromYa;

        /*         if (!externalLink.isEmpty()) {
            responseFromYa = ya.getNewsTexts(headLinkVK);
        } else { */
        //Split by dot all text
        requestToYa.addAll(Arrays.asList(src.split("\\.")));

        //Delete stop words, punctuation marks
        requestToYa.replaceAll(s -> new DeleteTrash().deleteTrash(s));

        responseFromYa = ya.getNewsTexts(requestToYa);
        // }
        //Stemmer to request
        String requestAfterStem = normalizeStr(src);

        //Stemmer to response
        List<String> responseFromYaAfterStemming = normalizeList(responseFromYa);

        //Comparator

        return 0;//Return result (double)
    }

    //Delete trash and transform words to normal form
    private List<String> normalizeList(List<String> initialSentence) {
        initialSentence.replaceAll(s -> new DeleteTrash().deleteTrash(s));
        List<String> requestsAfterStemming = new ArrayList<>();
        for (String s : initialSentence) {
            StringBuilder sb = new StringBuilder();
            for (String i : s.split(" ")) {
                sb.append(new Stemmer().stemming(i)).append(" ");
            }
            String stemmed = sb.toString();
            requestsAfterStemming.add(stemmed);
        }
        return requestsAfterStemming;
    }

    private String normalizeStr(String str) {
        String res = "";
        str = new DeleteTrash().deleteTrash(str);
        for (String i : str.split(" ")) {
            res += new Stemmer().stemming(i);
        }
        return res;
    }
}
