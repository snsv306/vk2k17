package factchecking.news.aggregator;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import factchecking.news.HttpHelper;

/**
 * YaAggregator
 */
public class YaAggregator implements IAggregator {
    private final String YANDEX_URL = "http://news.yandex.ru/";
    private String query;
    private String urlWithLinks;

    public String getUrlWithLinks() {
        
    }

    public YaAggregator(String query) {
        this.query = query;
    }

    public ArrayList<String> getLinks() {
        ArrayList<String> result = new ArrayList<String>();
        try {
            String url = makeFindStoryUrl(this.query);
            url = findStory(url);
            url = findSources(url);
            result = findLinks(url);
        } catch (Exception err) {
            err.printStackTrace();
        }
        return result;
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

    private ArrayList<String> findLinks(final String url) throws Exception {
        Document doc = HttpHelper.getDocumentByUrl(url);
        Elements elems = doc.select("h2.doc__title a");
        ArrayList<String> links = new ArrayList<String>();
        for (Element elem : elems) {
            links.add(elem.attr("abs:href"));
        }
        return links;
    }
}