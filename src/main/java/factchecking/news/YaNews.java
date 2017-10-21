package factchecking.news;

import java.util.ArrayList;

import factchecking.news.getter.YaGetter;
import factchecking.news.aggregator.YaAggregator;

public class YaNews implements INews {
    public YaNews() {
    }

    public ArrayList<String> getNewsTexts(ArrayList<String> queryTexts) {
        ArrayList<String> result = new ArrayList<String>();
        for (String query : queryTexts) {
            YaAggregator yaA = new YaAggregator(query);
            yaA.getLinks(); // костыль
            YaGetter yaG = new YaGetter(yaA.getUrlWithLinks());
            ArrayList<String> texts = yaG.getTexts();
            if (texts.size() > 0) {
                result = texts;
            }
        }
        return result;
    }
}