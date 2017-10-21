package com.example;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import javax.validation.constraints.NotNull;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class PullRequestYaNews {

    public String pullRequestYaNews (String str) throws IOException, InterruptedException{

        String url = "https://news.yandex.ru/yandsearch?text=" + URLEncoder.encode(str) + "&rpt=nnews2&grhow=clutop&rel=rel";
        System.out.println(url);
        Connection connection = Jsoup.connect(url);
        connection.timeout(1000);
        Document doc = connection.get();
        Elements news = doc.select("");
        if (news != null && !news.isEmpty()){
            return news.text();
        }
        else return "No news";
    }

}
