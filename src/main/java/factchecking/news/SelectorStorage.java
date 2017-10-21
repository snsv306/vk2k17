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
    }

    public Map<String, String> getDomains() {
        return domains;
    }
}
