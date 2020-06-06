package io.github.rahulrajsonu.dsalgo.algo.dynamic.knapsack;

import static java.lang.Math.max;

public class KnapSack {

  public static void main(String[] args) {
    int[] val = new int[]{7,3,4,10};
    int[] weight = new int[]{2,1,4,5};
    System.out.println(solve(7,weight,val,3));
  }

  public static int solve(int W, int[] wt, int[] val, int n){
    int i, w;
    int[][] K= new int[n+1][W+1];
    for(i=0;i<=n;i++){
      for(w=0;w<=W;w++){
        if(i==0 || w==0){
          K[i][w]=0;
        }else if(wt[i-1]<=w){
          K[i][w]=max(val[i-1]+K[i-1][w-wt[i-1]], K[i-1][w]);
        }else {
          K[i][w] = K[i-1][w];
        }
      }
    }
    return K[n][W];
  }
}
