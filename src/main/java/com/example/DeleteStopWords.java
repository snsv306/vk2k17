package com.example;

import java.util.Arrays;

public class DeleteStopWords {
    public static String[] stopWords = {"это", "как", "так", "и", "в", "над", "к", "до", "не", "на", "но",
            "за", "то", "с", "ли", "а", "во", "от", "со", "для", "о", "же",
            "ну", "вы", "бы", "что", "кто", "он", "она", "об"};


    public String deleteStopWords (String str){

        str = str.toLowerCase();

        str = str.replaceAll("[^1-9a-zA-Zа-яА-Я^ ]", "");
        String res = "";

        for(String i: str.split(" ")){
            if (!Arrays.asList(stopWords).contains(i)){
                res += i + " ";
            }
        }

        return res;
    }
}
