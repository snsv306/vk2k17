package factchecking.news;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HttpHelper {
    private Map<String, String> headers;
    private Map<String, String> cookies;
    private static final String UA = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36";

    public HttpHelper() {
        cookies = new HashMap<>();
        headers = new HashMap<>();
        headers.put("Accept-Language", "en");
        headers.put("Accept-Encoding", "gzip,deflate,sdch");
    }

    public Document getDocumentByUrl(final String url) throws IOException {
        Connection.Response res = Jsoup
                .connect(url)
                .headers(this.headers)
                .cookies(this.cookies)
                .validateTLSCertificates(false)
                .userAgent(HttpHelper.UA)
                .execute();
        this.cookies = res.cookies();
        return res.parse();
    }

    public Document getDocumentByUrlOnYandex(final String url) throws IOException, InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return getDocumentByUrl(url);
    }

    public String getTitleOnPage(String url) throws IOException {
        return getDocumentByUrl(url).select("title").text();
    }

    public static String encodeValue(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
    }
}