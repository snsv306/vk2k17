package factchecking.news;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Данил on 21.10.2017.
 */
public class SelectorStorage {
    private Map<String, String> domains;

    public SelectorStorage() {
        initDomains();
    }

    private void initDomains() {
        domains = new HashMap<>();
        domains.put("news-r.ru", "div.item-text:first-child");
        domains.put("oane.ws", "#hypercontext");
        domains.put("ok-inform.ru", ".js-mediator-article");
        domains.put("www.vladtime.ru", ".maincont");
        domains.put("forpost-sz.ru", "div.content div.field--name-body");
        domains.put("vistanews.ru", ".story");
        domains.put("og.ru", ".article-section");
        domains.put("rupolit.net", ".page-content");
        domains.put("davydov.in", ".post-content");
        domains.put("vedomosti-ural.ru", ".uss_news_fulltext");
        domains.put("www.online812.ru", ".statya");
        domains.put("echo.msk.ru", ".typical");
        domains.put("www.apn.ru", ".full-str");
        domains.put("www.sobaka.ru", ".row__inner");
        domains.put("www.vedomosti.ru", ".b-news-item__text");
        domains.put("sobesednik.ru", ".article-body");
        domains.put("newtimes.ru", ".text");
        domains.put("argumentiru.com", "#fulltext");
        domains.put("ura.news", ".item-text");
        domains.put("polit.ru", ".text.doc");
        domains.put("mr7.ru", ".content-text");
        domains.put("tsargrad.tv", ".news__body");
        domains.put("www.dp.ru", ".b-article__content");
        domains.put("republic.ru", ".post-content");
    }

    public Map<String, String> getDomains() {
        return domains;
    }
}
