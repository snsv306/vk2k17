package snsv.hackathon.spring.entity;

/**
 * Created by Данил on 21.10.2017.
 */
public class UIResponse {
    private final String link;
    private final String text;

    public UIResponse(String link, String text) {
        this.link = link;
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public String getText() {
        return text;
    }
}
