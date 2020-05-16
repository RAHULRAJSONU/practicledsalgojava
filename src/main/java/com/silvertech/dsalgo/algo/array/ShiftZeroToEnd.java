package com.silvertech.dsalgo.algo.array;

/*
 * practicledsalgojava
 * MIT License
 *
 * Copyright (c) 2020 Rahul Raj
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/**
* @requirement: shift all zeros to the end without creating new array and without reordering of non-zeros element
* @input: [0,1,2,0,3,0]
* @output: [1,2,3,0,0,0]
* */
public class ShiftZeroToEnd {

  public static void shiftZeroToEndAndOneToStart(int[] arr){
    shiftZeroToEnd(arr);
    shiftOneToStarting(arr);
  }

  private static void shiftZeroToEnd(int[] arr) {
    int i = 0;
    int j = 1;
    while (j < arr.length) {
      if (0 == arr[i] && 0 != arr[j]) {
        arr[i] = arr[j];
        arr[j] = 0;
        i++;
      } else if (0 != arr[i]) {
        i++;
      }
      j++;
    }
  }

  private static void shiftOneToStarting(int[] arr) {
    int i=0;
    int j=1;
    while (j < arr.length){
      if(arr[i] != 1 && arr[j] == 1){
        arr[j]=arr[i];
        arr[i] = 1;
        i++;
      }else if(arr[i]==1){
        i++;
      }
      j++;
    }
  }
}
