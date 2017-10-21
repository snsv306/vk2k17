package factchecking.news;

import java.util.ArrayList;

import factchecking.news.getter.YaGetter;

public class YaNews implements INews {
    public YaNews() {
    }

    public ArrayList<String> getNewsTexts(ArrayList<String> queryTexts) {
        ArrayList<String> result = new ArrayList<String>();
        for (String query : queryTexts) {
            YaGetter ya = new YaGetter(query);
            ArrayList<String> texts = ya.getTexts();
            if (texts.size() > 0) {
                result = ya.getTexts();
            }
        }
        return result;
    }
}