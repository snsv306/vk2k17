package com.artcomp;

import org.apache.commons.text.similarity.*;
import java.util.*;
import java.util.stream.*;
interface ArticleComparator {
    double compareNews(String input_news, String found_news);
}

class CosineComparator implements ArticleComparator {
    private static CosineSimilarity sim = new CosineSimilarity();
    public double compareNews(String inputNews, String foundNews) {
        Map<CharSequence, Integer> leftVector = Arrays.stream(inputNews.split("")).collect(Collectors.toMap(c -> c, c -> 1, Integer::sum));
        Map<CharSequence, Integer> rightVector = Arrays.stream(foundNews.split("")).collect(Collectors.toMap(c -> c, c -> 1, Integer::sum));
        return sim.cosineSimilarity(leftVector, rightVector);
    }
}