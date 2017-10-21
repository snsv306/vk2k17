package factchecking.news.getter;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import factchecking.news.getter.HttpHelper;

public class YaGetter implements IGetter {
    private final String YANDEX_URL = "http://news.yandex.ru/";
    private String queryText;
    private ArrayList<String> result;

    public YaGetter(final String queryText) {
        this.queryText = queryText;
        this.result = new ArrayList<String>();
        this.work();
    }  

    private void work() {
        try {
            String url = makeFindStoryUrl(this.queryText);
            url = findStory(url);
            url = findSources(url);
            this.result = findTexts(url);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public ArrayList<String> getTexts() {
        return this.result;
    }

    //for phase 1
    private String makeFindStoryUrl(final String text) throws UnsupportedEncodingException {
        final String urlQuery = "text=" + HttpHelper.encodeValue(text) + "&rpt=nnews2&grhow=clutop&rel=rel";
        return YANDEX_URL.concat("yandsearch?").concat(urlQuery);
    }
    //phase 1 поиск ссылки на странице с поиском
    private String findStory(final String url) throws Exception {
        Document doc = HttpHelper.getDocumentByUrl(url);
        Element link = doc.select(".story-item .title a").first();
        return link.attr("abs:href");
    }
    //phase 2 поиск ссылки 'Источники - ...'
    private String findSources(final String url) throws Exception {
        Document doc = HttpHelper.getDocumentByUrl(url);
        Element link = doc.select(".story__total").first();
        return link.attr("abs:href");
    }
    //phase 3 вырезаем текст из страницы
    private ArrayList<String> findTexts(final String url) throws Exception {
        Document doc = HttpHelper.getDocumentByUrl(url);
        Elements elems = doc.select(".doc__text");
        ArrayList<String> texts = new ArrayList<String>();
        for (Element elem : elems) {
            texts.add(elem.text());
        }
        return texts;
    }
}