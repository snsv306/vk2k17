package factchecking.news;

import factchecking.news.extractor.NewsTextExtractor;
import factchecking.news.extractor.YandexNewsLinkExtractor;

import java.net.URISyntaxException;
import java.util.List;

public class YaNews implements INews {

    public List<String> getNewsTexts(List<String> queryTexts) throws URISyntaxException {
        List<String> news = null;
        for (String query : queryTexts) {
            List<String> links = new YandexNewsLinkExtractor(query).getLinks();
            news = new NewsTextExtractor().getNews(links);
        }
        return news;
    }
}