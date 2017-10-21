package com.example;


public class IdentifyPartOfSpeech {

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
                                    "три", "одна", "умя", "тью", "мя", "тью", "мью", "тью", "одним"};

    public String identifyPartOfSpeech(String str){

        String res = "";
        str = str.toLowerCase();
        boolean flag;

        for (String i: str.split(" ")){

            flag = false;
            //1 - прилагательное
            for (String j: prilag){
                if (i.endsWith(j)) {
                    res += "прил ";
                    flag = true;
                    break;
                }
            }

            if (flag) continue;
            //2 - причастие
            for (String j: prichstie){
                if (i.endsWith(j)) {
                    res += "прич ";
                    flag = true;
                    break;
                }
            }

            if (flag) continue;
            //3 - глагол
            for (String j: glagol){
                if (i.endsWith(j)) {
                    res += "глаг ";
                    flag = true;
                    break;
                }
            }

            if (flag) continue;
            //4 - существительное
            for (String j: susctestv){
                if (i.endsWith(j)) {
                    res += "сущ ";
                    flag = true;
                    break;
                }
            }

            if (flag) continue;
            //5 - наречие
            for (String j: narech){
                if (i.endsWith(j)) {
                    res += "нареч ";
                    flag = true;
                    break;
                }
            }

            if (flag) continue;
            //6 - числительное
            for (String j: chisl){
                if (i.endsWith(j)) {
                    res += "числ ";
                    flag = true;
                    break;
                }
            }
        }

        return res;
    }
}
