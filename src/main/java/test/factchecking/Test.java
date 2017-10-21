package test.factchecking;

import java.util.ArrayList;

import factchecking.news.YaNews;

class Test {
    public static void main(String[] args) throws Exception {
        YaNews ya = new YaNews();
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("Квартиру дочери Собянина арестовали за долги");
        System.out.println(ya.getNewsTexts(arr));
    }
}