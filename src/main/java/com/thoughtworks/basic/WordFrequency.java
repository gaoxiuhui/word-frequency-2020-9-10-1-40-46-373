package com.thoughtworks.basic;

import java.util.*;

public class WordFrequency {

    public Map<String,Integer> countWordFrequency(String strings, List<String> stopWords){
        //第一步：变小写
        String stringsLower= getStringsLower(strings);
        //第二步：分割
        String[] stringArray= getStringArray(stringsLower);
        //第三步：编历数组
        Map<String,Integer> countWordFrequencyMap= getCountWordMap(stopWords, stringArray);
        //第四步：按照value排序并打印
        Map<String,Integer> sortCountWordFrequencyMap= sort(countWordFrequencyMap);
        //第五步：打印map
        print(sortCountWordFrequencyMap);
        return sortCountWordFrequencyMap;
    }

    private Map<String, Integer>  getCountWordMap(List<String> stopWords, String[] stringArray) {
        Map<String,Integer> countWordFrequencyMap=new HashMap<>();
        for(String word:stringArray){
            if(countWordFrequencyMap.containsKey(word)){
                int num=countWordFrequencyMap.get(word)+1;
                countWordFrequencyMap.put(word,num);
            }else if(!stopWords.contains(word)){
                countWordFrequencyMap.put(word,1);
            }
        }
        return countWordFrequencyMap;
    }

    private String[] getStringArray(String stringsLower) {
        return stringsLower.split(" ");
    }

    private String getStringsLower(String strings) {
        return strings.toLowerCase();
    }
    private Map<String, Integer> sort(Map<String,Integer> priWordFrequencyMap){
        Map<String, Integer> sortedMap = new HashMap<String, Integer>();
        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        };
         // map转换成list进行排序
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(priWordFrequencyMap.entrySet());
        // 排序
        Collections.sort(list,valueComparator);
        Iterator<Map.Entry<String, Integer>> iter = list.iterator();
        Map.Entry<String, Integer> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;
    }

    private  void print(Map<String,Integer> sortCountWordFrequencyMap) {
        Iterator it = sortCountWordFrequencyMap.keySet().iterator();
        while (it.hasNext()) {
            Object key = it.next();
            System.out.println(key + ":"+sortCountWordFrequencyMap.get(key));
        }
    }
}
