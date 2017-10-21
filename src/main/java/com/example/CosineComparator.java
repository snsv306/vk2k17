package com.example;

import org.apache.commons.text.similarity.CosineSimilarity;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

class CosineComparator {
    private static CosineSimilarity sim = new CosineSimilarity();
    public double compareNews(String inputNews, String foundNews) {
        Map<CharSequence, Integer> leftVector = Arrays.stream(inputNews.split(" ")).collect(Collectors.toMap(c -> c, c -> 1, Integer::sum));
        Map<CharSequence, Integer> rightVector = Arrays.stream(foundNews.split(" ")).collect(Collectors.toMap(c -> c, c -> 1, Integer::sum));
        return sim.cosineSimilarity(leftVector, rightVector);
    }
}
