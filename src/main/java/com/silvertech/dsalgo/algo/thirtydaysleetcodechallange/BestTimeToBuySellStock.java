package com.silvertech.dsalgo.algo.thirtydaysleetcodechallange;

public class BestTimeToBuySellStock {
    public static void main(String[] args) {
        int[] ar = new int[]{7,1,5,3,6,4};
        System.out.println(getMaxProfit(ar));
    }

    /**
     * Maximize the profit by buying or selling the stock
     * Given a array of price on different days
     * eg; {7,1,5,3,6,4}
     * how we can maximize the profit:-
     * we can buy the share on the 2nd day when price is: 1
     * we can sell the share on 3rd day when price is: 5 so our profit is: 4
     * we can again buy on 4th day when price is: 3
     * and we can sell on 5th day when price is: 6 so our profit is: 4+3 = 7
     * */
    private static int getMaxProfit(int[] arr) {
        int profit = 0;
        for (int m = 1; m < arr.length; m++) {
            if(arr[m] > arr[m-1]){
                profit+=arr[m]-arr[m-1];
            }
        }
        return profit;
    }
}
