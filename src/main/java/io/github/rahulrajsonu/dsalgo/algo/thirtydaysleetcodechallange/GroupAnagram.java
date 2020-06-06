package io.github.rahulrajsonu.dsalgo.algo.thirtydaysleetcodechallange;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] arr = new String[]{"eat","tea","tan","ate","nat","bat"};
        Map<String, List<String>> group = groupAnagram(arr);
        group.forEach((k,v)-> System.out.println(v));
    }

    /**
     * API to group the anagram strings
     * Given input as array of String
     * eg; {"eat","tea","tan","ate","nat","bat"}
     * output should group the string as
     * ("eat","tea","ate"),("tan","nat"),("bat")
     * */
    private static Map<String, List<String>> groupAnagram(String[] strArr) {
        Map<String, List<String>> group = new HashMap<>();
        for (String str : strArr) {
            char[] ar = str.toCharArray();
            Arrays.sort(ar);
            String sortedStr = String.valueOf(ar);
            if(group.containsKey(sortedStr)){
                List<String> strings = group.get(sortedStr);
                strings.add(str);
                group.put(sortedStr,strings);
            }else {
                List<String> strList = new LinkedList<>();
                strList.add(str);
                group.put(sortedStr,strList);
            }
        }
        return group;
    }
}
