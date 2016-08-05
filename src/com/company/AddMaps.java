package com.company;

import java.util.HashMap;

/**
 * Created by rabota on 30.06.16.
 */
public class AddMaps {

    public static HashMap<String, Boolean> addExpressionMap(String expression) {

        String expressionList = expression.replace("(", "").replace(")", "").replace("&", " ").replace("|", " ");
        String[] quests = expressionList.split(" ");
        HashMap<String, Boolean> expressionMap = new HashMap<String, Boolean>();
        for (String name : quests) {
            if (name.startsWith("!"))
                expressionMap.put(name.substring(1, name.length()), false);
            else expressionMap.put(name, true);
        }

        return expressionMap;
    }

    public static HashMap<String, Boolean> addCompleteMap(String[] questsComplete) {

        HashMap<String, Boolean> completeMap = new HashMap<String, Boolean>();
        for (String data : questsComplete) {
            completeMap.put(data, true);
        }
        return completeMap;
    }

    public static HashMap<String, Boolean> addResultMap(HashMap<String, Boolean> questMap, HashMap<String, Boolean> completeMap) {
        HashMap<String, Boolean> resultMap = new HashMap<String, Boolean>();
        for (HashMap.Entry position : questMap.entrySet()) {
            String currentQuestName = position.getKey().toString();
            Boolean currentQuestStatus = (Boolean) position.getValue();
            if (completeMap.containsKey(currentQuestName) && (currentQuestStatus == true))
                resultMap.put(currentQuestName, true);
            if (completeMap.containsKey(currentQuestName) && (currentQuestStatus == false))
                resultMap.put(currentQuestName, false);
            if (!completeMap.containsKey(currentQuestName) && (currentQuestStatus == true))
                resultMap.put(currentQuestName, false);
            if (!completeMap.containsKey(currentQuestName) && (currentQuestStatus == false))
                resultMap.put(currentQuestName, true);
        }

        return resultMap;
    }

}

