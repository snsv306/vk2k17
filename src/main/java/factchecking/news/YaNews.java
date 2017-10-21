package factchecking.news;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import factchecking.news.extractor.NewsTextExtractor;
import factchecking.news.extractor.YandexNewsLinkExtractor;

public class YaNews implements INews {
    public List<String> getNewsTexts(List<String> queryTexts) throws URISyntaxException, IOException {
        List<String> result = new ArrayList<>();
        for (String query : queryTexts) {
            List<String> links = new YandexNewsLinkExtractor(query).getLinks();
            List<String> news = new NewsTextExtractor().getNews(links);
            if (news.size() > 0) {
                result = news;
                break;
            }
        }
        return result;
    }
}