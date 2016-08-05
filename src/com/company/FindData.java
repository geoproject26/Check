package com.company;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindData {

    public String getExpression(String string) {
        string = string.replace(" ", "");
        byte[] quote = string.getBytes();
        ArrayList position = new ArrayList();

        for (int expression = 0; expression < quote.length; ++expression) {
            if (quote[expression] == 34) {
                position.add(Integer.valueOf(expression));
            }
        }
        return string.substring(((Integer) position.get(0)).intValue() + 1, ((Integer) position.get(1)).intValue());
    }

    public String[] getQuests(String string) {
        string = string.replace(" ", "");
        byte[] quote = string.getBytes();
        ArrayList position = new ArrayList();

        for (int quests = 0; quests < quote.length; ++quests) {
            if (quote[quests] == 34) {
                position.add(Integer.valueOf(quests));
            }
        }
        return string.substring(((Integer) position.get(2)).intValue() + 1, ((Integer) position.get(3)).intValue()).split(",");
    }

}

