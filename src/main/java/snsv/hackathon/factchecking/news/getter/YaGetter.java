package snsv.hackathon.factchecking.news.getter;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import snsv.hackathon.factchecking.news.HttpHelper;

public class YaGetter implements IGetter {
    private String url;

    public YaGetter(final String url) {
        this.url = url;
    }

    public List<String> getTexts() {
        List<String> result = new ArrayList<String>();
        try {
            result = findTexts(this.url);
        } catch (Exception err) {
            err.printStackTrace();
        }
        return result;
    }

    //вырезаем текст из страницы
    private List<String> findTexts(final String url) throws Exception {
        Document doc = HttpHelper.getDocumentByUrl(url);
        Elements elems = doc.select(".doc__text");
        List<String> texts = new ArrayList<String>();
        for (Element elem : elems) {
            texts.add(elem.text());
        }
        return texts;
    }
}