package com.silvertech.dsalgo.algo.array;

import static org.junit.jupiter.api.Assertions.*;

import com.silvertech.dsalgo.utility.Utils;
import org.junit.jupiter.api.Test;

class ShiftZeroToEndTest {

  @Test
  void shiftZeroToEndAndOneToStart() {
    int[] arr = new int[]{0,0,1,5,0,1,2,0,3,0,4,1};
    int[] expected = {1,1,1,2,3,4,5,0,0,0,0,0};
    ShiftZeroToEnd.shiftZeroToEndAndOneToStart(arr);

    assertTrue(Utils.arrayDeepEqual(arr,expected));
  }
}