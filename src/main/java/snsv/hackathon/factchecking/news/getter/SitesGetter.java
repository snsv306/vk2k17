package snsv.hackathon.factchecking.news.getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SitesGetter implements IGetter {
    private Map<String, String> siteSelector;
    private List<String> sites;
    public SitesGetter(Map<String, String> siteSelector, ArrayList<String> sites) {
        this.siteSelector = siteSelector;
        this.sites = sites;
    }
    public List<String> getTexts() {
        return new ArrayList<String>();
    }
}