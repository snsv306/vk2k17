package factchecking.news.getter;

import java.util.ArrayList;
import java.util.Map;

public class SitesGetter implements IGetter {
    private Map<String, String> siteSelector;
    private ArrayList<String> sites;
    public SitesGetter(Map<String, String> siteSelector, ArrayList<String> sites) {
        this.siteSelector = siteSelector;
        this.sites = sites;
    }
    public ArrayList<String> getTexts() {
        return new ArrayList<String>();
    }
}