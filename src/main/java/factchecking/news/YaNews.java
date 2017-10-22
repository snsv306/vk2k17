package factchecking.news;

import factchecking.news.extractor.NewsTextExtractor;
import factchecking.news.extractor.YandexNewsLinkExtractor;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class YaNews implements INews {
    public List<String> getNewsTexts(List<String> queryTexts) throws URISyntaxException, IOException {
        List<String> result = new ArrayList<>();
        for (String query : queryTexts) {
            List<String> links = new YandexNewsLinkExtractor(query).getLinks();
            List<String> news = new NewsTextExtractor().getNews(links);
            if (news.size() > 0) {
                System.out.println("Success query : "  + query);
                result = news;
                break;
            }
        }
        return result;
    }
}