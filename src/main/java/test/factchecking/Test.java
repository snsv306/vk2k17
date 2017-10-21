package test.factchecking;

import factchecking.news.YaNews;

import java.util.ArrayList;
import java.util.List;

class Test {
    public static void main(String[] args) throws Exception {
        YaNews ya = new YaNews();
        List<String> arr = new ArrayList<>();
        arr.add("Квартиру дочери Собянина арестовали за долги");
        System.out.println(ya.getNewsTexts(arr));
    }
}