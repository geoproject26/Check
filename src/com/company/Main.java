package com.company;

import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        String string = (new InputString()).readData(); //исходная строка
        String expression = (new FindData()).getExpression(string); // выражение логическое
        try {
            String [] questsComplete = (new FindData()).getQuests(string); //выполненные квесты
            HashMap<String, Boolean> questMap = AddMaps.addExpressionMap(expression);//базовые значения переменных квестов
            HashMap<String, Boolean> completeMap = AddMaps.addCompleteMap(questsComplete);//Карта пройденных квестов
            HashMap<String, Boolean> resultMap = AddMaps.addResultMap(questMap, completeMap); // Итоговая карта для вычислений
            String finalString = expression.replace("!", "");
            for (HashMap.Entry entry : resultMap.entrySet()) {
                finalString = finalString.replace(entry.getKey().toString(), entry.getValue().toString());
                finalString = finalString.replace("true", "1").replace("false", "0");
            }
            int result = Evalute.eval(finalString); //запрос на вычисление (польская запись)
            if (result == 1) System.out.println(expression + " => true");
            else System.out.println(expression + " => false");
        } catch (Exception e) {
            System.out.println(expression + " => error");
        }
    }
}