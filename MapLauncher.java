package com.company;

import java.util.*;

public class MapLauncher{
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        System.out.println("Please, enter your text: ");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] tokens = string.split(" ");
        for (String token : tokens){
            String word = token.toLowerCase();
            Integer count = map.get(word);
            if (count==null){
                map.put(word,count=1);
            } else {
                map.put(word,count+1);
            }
        }
        printMap(map);
    }

    private static void printMap(Map<String, Integer> map) {
        Map<String,Integer> treeMap = new TreeMap<>(map);
        Set<String> keys = treeMap.keySet();
        for (String key : keys){
            System.out.printf("%-10s %-10s\n",key, map.get(key));
        }
    }
}
