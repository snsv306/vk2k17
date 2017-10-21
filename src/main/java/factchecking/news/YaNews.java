package factchecking.news;

import java.util.ArrayList;
import factchecking.news.getter.YaGetter;

public class YaNews implements INews {
    public YaNews() {
    }

    public ArrayList<String> getNewsTexts(ArrayList<String> queryTexts) {
        YaGetter ya = new YaGetter(queryTexts.get(0));
        return ya.getTexts();
    }
}