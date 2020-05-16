package com.silvertech.dsalgo.algo.thirtydaysleetcodechallange;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,0,0,1,1,0,0,1,1,0};
        System.out.println(findLongestContiguousArray(arr));
    }

    /**
    * Find the length of longest contiguous sub array in a given array of zeros and ones
     * @param arr
     * @return length of longest contiguous sub array;
     * eg; given arr = {1,1,0,0,1,1,0,1,1};
     * output will be 6 {1,0,0,1,1,0};
     * time complexity: O(n);
     * space complexity: O(n);
    * */
    private static int findLongestContiguousArray(int[] arr) {
        Map<Integer, Integer> visitorMap = new HashMap<>();
        int sum = 0;
        int longestSubArr = 0;
        for (int m = 0; m < arr.length; m++) {
            if (arr[m] == 0) {
                sum+=-1;
            }else {
                sum+=1;
            }
            visitorMap.putIfAbsent(sum,m);
            if(visitorMap.containsKey(sum)){
                int currentLength = m-visitorMap.get(sum);
                if(longestSubArr < currentLength){
                    longestSubArr = currentLength;
                }
            }
        }
        return longestSubArr;
    }
}
