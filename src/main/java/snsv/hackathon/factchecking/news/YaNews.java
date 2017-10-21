package snsv.hackathon.factchecking.news;

import java.util.ArrayList;
import java.util.List;

import snsv.hackathon.factchecking.news.getter.YaGetter;
import snsv.hackathon.factchecking.news.aggregator.YaAggregator;

public class YaNews implements INews {
    public YaNews() {
    }

    public List<String> getNewsTexts(List<String> queryTexts) {
        List<String> result = new ArrayList<String>();
        for (String query : queryTexts) {
            YaAggregator yaA = new YaAggregator(query);
            yaA.getLinks(); // костыль
            YaGetter yaG = new YaGetter(yaA.getUrlWithLinks());
            List<String> texts = yaG.getTexts();
            if (texts.size() > 0) {
                result = texts;
            }
        }
        return result;
    }
}