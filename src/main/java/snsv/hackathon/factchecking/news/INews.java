package snsv.hackathon.factchecking.news;

import java.util.List;

public interface INews {
    public List<String> getNewsTexts(List<String> queryTexts);
}