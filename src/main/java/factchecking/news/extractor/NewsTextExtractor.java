package factchecking.news.extractor;

import factchecking.news.HttpHelper;
import factchecking.news.SelectorStorage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Данил on 21.10.2017.
 */
public class NewsTextExtractor {
    public List<String> getNews(List<String> links) throws URISyntaxException {
        Map<String, String> domains = new SelectorStorage().getDomains();
        List<String> news = new ArrayList<>();
        for (String link : links) {
            String host = new URI(link).getHost();
            if (domains.containsKey(host)) {
                String selector = domains.get(host);
                Document doc;
                try {
                    doc = new HttpHelper().getDocumentByUrl(link);
                } catch (IOException e) {
                    continue;
                }
                Element element = doc.select(selector).first();
                news.add(element.text());
            }
        }
        return news;
    }
}
