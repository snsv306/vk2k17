package com.example;


public class DeleteStopWords {
    public static String[] stopWords = {"это ", "как ", "так ", "и ", "в ", "над ", "к ", "до ", "не ", "на ", "но ", "за ", "то ",
                    "с ", "ли ", "а ", "во ", "от ", "со ", "для ", "о ", "же ", "ну ", "вы ", "бы ", "что ", "кто ", "он ", "она "};


    public String deleteStopWords (String str){

        str = str.toLowerCase();

        str = str.replaceAll("[^a-zA-Zа-яА-Я]", " ");
        for (String i: stopWords) {
            str = str.replaceAll(i, "");
        }
        return str;
    }
}
