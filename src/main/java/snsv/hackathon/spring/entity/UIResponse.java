package snsv.hackathon.spring.entity;

/**
 * Created by Данил on 21.10.2017.
 */
public class UIResponse {
    private final String result;

    public UIResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
