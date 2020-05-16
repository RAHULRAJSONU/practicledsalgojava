package com.silvertech.dsalgo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalExample {

  public static void main(String[] args) {
    BigDecimal marks = BigDecimal.valueOf(342);
    BigDecimal totalMarks = BigDecimal.valueOf(500);
    BigDecimal perc = marks.divide(totalMarks,4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
    System.out.println(perc);
  }

}
