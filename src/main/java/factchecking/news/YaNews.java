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
        ArrayList<String> result = new ArrayList<>();
        for (String query : queryTexts) {
            List<String> links = new YandexNewsLinkExtractor(query).getLinks();
            List<String> news = new NewsTextExtractor().getNews(links);
//            justForDomains(links);
        }
        return result;
    }

    private void justForDomains(List<String> links) throws URISyntaxException {
        List<String> domains = new ArrayList<>();
        for (String link : links) {
            domains.add(new URI(link).getHost());
        }
        domains.isEmpty();
    }
}