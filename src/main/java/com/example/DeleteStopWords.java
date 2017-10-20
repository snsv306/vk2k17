package com.example;

/**
 * Created by Данил on 21.10.2017.
 */
public class DeleteStopWords {
    public static String[] stopWords = {"это", "как", "так", "и", "в", "над", "к", "до", "не", "на", "но", "за", "то",
                    "с", "ли", "а", "во", "от", "со", "для", "о", "же", "ну", "вы", "бы", "что", "кто", "он", "она"};

    public String deleteStopWords (String str){
        for (int i = 0; i < stopWords.length; i++){
            str.replaceAll(stopWords[i] ,"");
        }

        return str;
    }
}
