package snsv.hackathon.factchecking.news;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HttpHelper {
    public static Document getDocumentByUrl(final String url) throws IOException {
        return Jsoup.connect(url).userAgent("Chrome").get();
    }

    public static String getTitleOnPage(String url) throws IOException {
        return getDocumentByUrl(url).select("title").text();
    }

    public static String encodeValue(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
    }
}