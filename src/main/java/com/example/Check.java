package com.example;

import org.apache.lucene.morphology.russian.RussianAnalyzer;
import org.apache.lucene.morphology.english.EnglishAnalyzer;

import java.io.IOException;
import java.io.InterruptedIOException;

public class Check {
    public static void main(String[] args) throws IOException, InterruptedException{
        String src = "На православном форуме в Краснодаре: рассказали об опасностях интернета. \n" +
                "\n" +
                "Там немного ад\n";
        //String dst = "На Кирилло-Мефодиевских чтениях в Краснодаре 19 октября иерей Вячеслав Клименко рассказал об опасностях интернета Он также заявил, что миссия церкви сегодня состоит в спасении реальных душ в";
        String dest = "Новую угрозу для молодого поколения страны озвучил священник из Краснодара на одном из мероприятий, посвященного проблемам просвещения, с участием руководства региона в столице Кубани По словам иерея Вячеслава Клименко, сегодняшний мир обязывает церковь активнее действовать в той сфере, в которой ей ранее работать не приходилось.";
        String dst = "Отметим, что новая цифра зафиксировала исторический максимум по цене биткоина. Данные биржи говорят о том, что в течение нескольких часов вырос объем торгов, благодаря чему цена криптовалюты резко выросла..";

        //Удаление стоп слов и знаков препинания
        String src2 = new DeleteStopWords().deleteStopWords(src);
        String dst2 = new DeleteStopWords().deleteStopWords(dst);

        //Стеммер
        String src1 = "";
        for (String i: src2.split(" ")){
            src1 += new Stemmer().stemming(i) + " ";
        }

        //Стеммер
        String dst1 = "";
        for (String i: dst2.split(" ")){
            dst1 += new Stemmer().stemming(i) + " ";
        }

        //Компаратор
        double res = new CosineComparator().compareNews(src1, dst1);
        System.out.println("Compare result = " + res);

        //String tres = new PullRequestYaNews().pullRequestYaNews("хрень");
        //System.out.println(tres);

        //Определение части речи
        //src2 = "мама мыла раму";
        String src3 = new IdentifyPartOfSpeech().deleteAdjective(src2);
        System.out.println(src2);
        System.out.println(src3);

        String dst3 = new IdentifyPartOfSpeech().deleteAdjective(dst2);
        System.out.println(dst2);
        System.out.println(dst3);

        RussianAnalyzer russian = new RussianAnalyzer();
        EnglishAnalyzer english = new EnglishAnalyzer();
    }
}
