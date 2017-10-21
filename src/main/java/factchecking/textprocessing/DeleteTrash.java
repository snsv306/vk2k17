package factchecking.textprocessing;

import java.util.Arrays;

public class DeleteTrash {
    public static String[] stopWords = {"это", "как", "так", "и", "в", "над", "к", "до", "не", "на", "но",
            "за", "то", "с", "ли", "а", "во", "от", "со", "для", "о", "же", "ни", "они", "оно",
            "ну", "вы", "бы", "что", "кто", "он", "она", "об", "по"};


    public String deleteTrash(String str){

        str = str.toLowerCase();

        str = str.replaceAll("[^0-9a-zA-Zа-яА-Я^ ]", "");
        String res = "";

        for(String i: str.split(" ")){
            if (!Arrays.asList(stopWords).contains(i)){
                res += i + " ";
            }
        }

        return res;
    }
}
