package com.silvertech.dsalgo.algo.thirtydaysleetcodechallange;

import java.util.HashMap;
import java.util.Map;

public class CountElement {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,3,4};
        System.out.println(countElement(arr));
    }

    /**
     * Count the number of x where x+1 is present in the array
     * eg; given arr: {1,1,2,3,4}
     * output will be 4
     * bcoz, 1+1 = 2->present in the array so count=2 (1 appears twice)
     * 2+1 = 3->present in the array so count=3
     * 3+1 = 4->present in the array so count=4
     * 4+1 = 5-> not present in the array hence count will remain 4
     * */
    private static int countElement(int[] arr) {
        Map<Integer, Integer> xPlusOneMap = new HashMap<>();
        int count = 0;
        for (int x : arr) {
            xPlusOneMap.putIfAbsent(x,0);
            xPlusOneMap.computeIfPresent(x, (key,val)->val+1);
        }
        for(Map.Entry<Integer,Integer> entry: xPlusOneMap.entrySet()){
            if(xPlusOneMap.containsKey(entry.getKey()+1)){
                count+=entry.getValue();
            }
        }
        return count;
    }
}
