package io.github.rahulrajsonu.dsalgo.algo.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that amount.
 * You may assume that you have infinite number of each kind of coin.
 *
 * <h3>Example 1:</h3>
 * Input: amount = 5, coins = [1, 2, 5]<br/>
 * Output: 4<br/>
 * Explanation: there are four ways to make up the amount:<br/>
 * 5=5<br/>
 * 5=2+2+1<br/>
 * 5=2+1+1+1<br/>
 * 5=1+1+1+1+1<br/>
 *
 * <h3>Example 2:</h3>
 * Input: amount = 3, coins = [2]<br/>
 * Output: 0<br/>
 * Explanation: the amount of 3 cannot be made up just with coins of 2.<br/>
 *
 * <h3>Example 3:</h3>
 * Input: amount = 10, coins = [10]<br/>
 * Output: 1
 *
 */
public class CoinChange {

  public static void main(String[] args) {
    int[] arr = {1, 2, 5};
    System.out.println(change(arr,5));
  }

  public static int change(int[] arr, int amount){
    return 0;
  }
}
