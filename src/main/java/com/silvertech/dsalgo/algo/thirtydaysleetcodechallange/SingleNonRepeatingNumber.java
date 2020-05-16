package com.silvertech.dsalgo.algo.thirtydaysleetcodechallange;

public class SingleNonRepeatingNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1,2,3};
        System.out.println(nonRepeatingNumber(arr));
    }

    /**
     * API to find the single non repeating element in a given array
     * Given array: {1,2,1,2,3}
     * Output should: 3
     * */
    private static int nonRepeatingNumber(int[] arr) {
        int res = 0;
        for(int el : arr){
            res ^=el;
        }
        return res;
    }
}
