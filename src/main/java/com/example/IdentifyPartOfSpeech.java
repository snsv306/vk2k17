package com.example;


public class IdentifyPartOfSpeech {

    public static String[] adject = {"ее", "ие", "ые", "ое", "ими", "ыми", "ей", "ий", "ый", "ой", "ем", "им", "ым",
            "ом", "его", "ого", "ему", "ому", "их", "ых", "ую", "юю", "ая", "яя", "ою", "ею"};

    public String deleteAdjective(String str){
        String res = "";
        Boolean flag;

        for (String i: str.split(" ")){
            flag = false;
            for (String j: adject){
                if((i.endsWith(j))) flag = true;
            }
            if (!flag) res += i + " ";
        }

        return res;
    }
    /*
    //1 - прилагательное
    //2 - причастие
    //3 - глагол
    //4 - существительное
    //5 - наречие
    //6 - числительное

    public static String[] prilag = {"ее", "ие", "ые", "ое", "ими", "ыми", "ей", "ий", "ый", "ой", "ем", "им", "ым",
                                    "ом", "его", "ого", "ему", "ому", "их", "ых", "ую", "юю", "ая", "яя", "ою", "ею"};
    public static String[] prichstie = {"ивш","ывш","ующ","ем","нн","вш","ющ","ущи","ющи","ящий","щих","щие","ляя"};
    public static String[] glagol = {"ила", "ыла", "ена", "ейте", "уйте", "ите", "или", "ыли", "ей", "уй", "ил", "ыл",
                                    "им", "ым", "ен", "ило", "ыло", "ено", "ят", "ует", "уют", "ит", "ыт", "ены",
                                    "ить", "ыть", "ишь", "ую", "ю", "ла", "на", "ете", "йте", "ли", "й", "л", "ем",
                                    "н", "ло", "ет", "ют", "ны", "ть", "ешь", "нно"};
    public static String[] susctestv = {"а", "ев", "ов", "ье", "иями", "ями", "ами", "еи", "ии", "и", "ией", "ей",
                                        "ой", "ий", "й", "иям", "ям", "ием", "ем", "ам", "ом", "о", "у", "ах", "иях",
                                        "ях", "ы", "ь", "ию", "ью", "ю", "ия", "ья", "я", "ок", "мва", "яна", "ровать",
                                        "ег", "ги", "га", "сть", "сти"};
    public static String[] narech = {"чно", "еко", "соко", "боко", "роко", "имо", "мно", "жно", "жко", "ело", "тно",
                                    "льно", "здо", "зко", "шо", "хо", "но"};
    public static String[] chisl = {"чуть", "много", "мало", "еро", "вое", "рое", "еро", "сти", "одной", "двух", "рех",
                                    "еми", "яти", "ьми", "ати", "дного", "сто", "ста", "тысяча", "тысячи", "две",
                                    "три", "одна", "умя", "тью", "мя", "тью", "мью", "тью", "одним"};*/
}
