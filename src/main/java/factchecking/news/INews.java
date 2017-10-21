package factchecking.news;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface INews {
    List<String> getNewsTexts(List<String> queryTexts) throws URISyntaxException, IOException;
}