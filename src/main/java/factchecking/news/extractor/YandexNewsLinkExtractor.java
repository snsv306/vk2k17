package factchecking.news.extractor;

import factchecking.news.HttpHelper;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * YandexNewsLinkExtractor
 */
public class YandexNewsLinkExtractor implements ILinkExtractor {
    private final String YANDEX_URL = "http://news.yandex.ru/";
    private String query;
    private HttpHelper pageGetter;
    private List<String> links;

    public YandexNewsLinkExtractor(String query) {
        this.query = query;
        this.pageGetter = new HttpHelper();
    }

    public List<String> getLinks() {
        if (links == null) {
            initLinks();
        }
        return links;
    }

    private void initLinks() {
        links = new ArrayList<String>();
        try {
            String url = makeFindStoryUrl(this.query);
            url = findStory(url);
            url = findSources(url);
            links = findLinks(url);
        } catch (Exception err) {
            System.out.println("Error while fetch data from " + this.query);
            err.printStackTrace();
        }
    }

    //for phase 1
    private String makeFindStoryUrl(final String text) throws UnsupportedEncodingException {
        final String urlQuery = "text=" + HttpHelper.encodeValue(text) + "&rpt=nnews2&grhow=clutop&rel=rel";
        return YANDEX_URL.concat("yandsearch?").concat(urlQuery);
    }

    //phase 1 поиск ссылки на странице с поиском
    private String findStory(final String url) throws Exception {
        Document doc = pageGetter.getDocumentByUrlOnYandex(url);
        Element link = doc.select(".story-item .title a").first();
        return link.attr(   "abs:href");
    }

    //phase 2 поиск ссылки 'Источники - ...'
    private String findSources(final String url) throws Exception {
        Document doc = pageGetter.getDocumentByUrlOnYandex(url);
        Element link = doc.select(".story__total").first();
        return link.attr("abs:href");
    }

    //phase 3 поиск ссылок на другие новостные ресурсы
    private ArrayList<String> findLinks(final String url) throws Exception {
        Document doc = pageGetter.getDocumentByUrlOnYandex(url);
        Elements elems = doc.select("h2.doc__title a");
        ArrayList<String> links = new ArrayList<String>();
        for (Element elem : elems) {
            links.add(elem.attr("abs:href"));
        }
        return links;
    }
}