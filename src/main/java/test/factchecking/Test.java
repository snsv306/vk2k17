package test.factchecking;

import factchecking.FactChecking;
import factchecking.news.YaNews;

import java.util.ArrayList;
import java.util.List;

class Test {
    public static void main(String[] args) throws Exception {
        FactChecking fc = new FactChecking();
        System.out.println(fc.api("Квартиру дочери Собянина арестовали за долги. Позже приставы сказали, что не могут найти ни дочь, ни квартирit ", "http://news.lenta.ch/lQSK"));
    }
}