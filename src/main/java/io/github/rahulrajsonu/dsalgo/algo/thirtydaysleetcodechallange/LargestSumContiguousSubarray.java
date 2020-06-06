package io.github.rahulrajsonu.dsalgo.algo.thirtydaysleetcodechallange;

public class LargestSumContiguousSubarray {
    public static void main(String[] args) {
        System.out.println(largestSumInContiguousSubArray(new int[]{-2,-3,4,-1,-2,1,5,-3}));
    }

    /**
     * API to find the largest sum in the contiguous sub array
     * given array: {-2,-3,4,-1,-2,1,5,-3}
     * the sub array {4,-1,-2,1,5} has the largest sum as 7
     * */
    private static int largestSumInContiguousSubArray(int[] arr) {
        int maxEnd = 0;
        int maxSoFar = Integer.MIN_VALUE;
        for (int m = 0; m < arr.length; m++) {
            maxEnd+=arr[m];
            if(maxEnd < arr[m])maxEnd = arr[m];
            if(maxSoFar < maxEnd)maxSoFar=maxEnd;
        }
        return maxSoFar;
    }
}
