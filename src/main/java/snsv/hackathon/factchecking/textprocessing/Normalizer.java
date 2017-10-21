package snsv.hackathon.factchecking.textprocessing;

import java.util.ArrayList;
import java.util.List;

public class Normalizer {
    public Normalizer(){}

    public List<String> normalizeList(List<String> initialSentence) {
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

    public String normalizeStr(String str) {
        String res = "";
        str = new DeleteTrash().deleteTrash(str);
        for (String i : str.split(" ")) {
            res += new Stemmer().stemming(i);
        }
        return res;
    }
}
