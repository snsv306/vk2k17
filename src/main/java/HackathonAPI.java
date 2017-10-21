import FormatString.DeleteTrash;
import com.example.Stemmer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HackathonAPI {
    public Integer hackathonAPI(String src){

        //Create list for requests to news.ya
        List<String> requestToYa = new ArrayList<>();

        //Split by dot all text
        requestToYa.addAll(Arrays.asList(src.split("\\.")));

        //Delete stop words, punctuation marks
        requestToYa.replaceAll(s -> new DeleteTrash().deleteTrash(s));

        //Request to news.yandex


        //Stemmer to request
        List<String> requestsAfterStem = new ArrayList<>();
        for (String s : requestToYa) {
            StringBuilder sb = new StringBuilder();
            for (String i : s.split(" ")){
                sb.append(new Stemmer().stemming(i)).append(" ");
            }
            String stemmed = sb.toString();
            requestsAfterStem.add(stemmed);
        }


        //Stemmer to response
        return 0;
    }
}
