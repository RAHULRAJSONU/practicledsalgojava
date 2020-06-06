package io.github.rahulrajsonu.dsalgo.algo.thirtydaysleetcodechallange;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(checkHappyNumber(29));
    }

    /**
     * Check if given number is happy or not
     * Happy number: input: 19
     * 1^2+9^2=82
     * 8^2+2^2=68
     * 6^2+8^2=100
     * 1^2+0^2+0^2=1
     * if we are able to achieve 1 then the number is treat as happy number
     * */
    private static boolean checkHappyNumber(int number) {
        Set<Integer> visited=new HashSet<>();
        boolean res=true;
        visited.add(number);
        while (1!=number){
            int temp = number;
            int sum=0;
            while (temp!=0){
                sum+=(temp%10)*(temp%10);
                temp /=10;
            }
            number=sum;
            if(visited.contains(number)){
                res=false;
                break;
            }else {
                visited.add(number);
            }
        }
        return res;
    }
}
