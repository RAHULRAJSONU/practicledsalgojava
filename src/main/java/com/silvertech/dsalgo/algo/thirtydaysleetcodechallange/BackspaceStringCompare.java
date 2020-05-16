package com.silvertech.dsalgo.algo.thirtydaysleetcodechallange;

public class BackspaceStringCompare {
  public static boolean compare(String str1, String str2){
    return processString(str1).equals(processString(str2));
  }

  private static String processString(String str) {
    String res = "";
    if(str.length()==0){
      return res;
    }
    for(int m=0; m < str.length(); m++){
      if(str.charAt(m) >= 'a' && str.charAt(m) <= 'z'){
        res = res.concat(String.valueOf(str.charAt(m)));
      }else {
        res = executeBackspace(res);
      }
    }
    return res;
  }

  private static String executeBackspace(String str) {
    if(str.length() > 0){
      return str.substring(0,str.length()-1);
    }else {
      return str;
    }
  }
}
