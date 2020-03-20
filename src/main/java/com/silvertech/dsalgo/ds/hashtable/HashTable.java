package com.silvertech.dsalgo.ds.hashtable;

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
public class HashTable {
  private String[] hashArray;
  private int arraySize;
  int size = 0;

  public HashTable(int numberOfSlots){
    if(isPrime(numberOfSlots)){
      hashArray = new String[numberOfSlots];
      arraySize = numberOfSlots;
    }else{
      int nextPrimeNumber = getNextPrime(numberOfSlots);
      hashArray = new String[nextPrimeNumber];
      arraySize = nextPrimeNumber;
    }
  }

  public void insert(String word){
    int hashVal = hashFuncOne(word);
    int stepSize = hashFuncTwo(word);
    while (hashArray[hashVal] != null){
      hashVal = hashVal+stepSize;
      hashVal = hashVal % arraySize;
    }
    hashArray[hashVal] = word;
    size++;
  }

  public String search(String word){
    int hashVal = hashFuncOne(word);
    int stepSize = hashFuncTwo(word);

    while (hashArray[hashVal] != null){
      if(hashArray[hashVal].equals(word)){
        return hashArray[hashVal];
      }
      hashVal = hashVal+stepSize;
      hashVal = hashVal % arraySize;
    }
    return hashArray[hashVal];
  }

// returns the index
  private int hashFuncOne(String word){
    int hashVal = word.hashCode();
    hashVal = hashVal % arraySize;
    if(hashVal < 0){
      hashVal += arraySize;
    }
    return hashVal;
  }
  // Going to return step size greater then zero
  private int hashFuncTwo(String word){
    int hashVal = word.hashCode();
    hashVal %= arraySize;
    if(hashVal < 0 ){
      hashVal += arraySize;
    }
// 3 can be replace by any prime number lesser then array size
    return 3 - hashVal % 3;
  }

  private int getNextPrime(int number) {
    for (int m = number; true; m++){
      if(isPrime(m)){
        return m;
      }
    }
  }

  private boolean isPrime(int number) {
    for(int m = 2; m*m <= number; m++){
      if(number % m == 0){
        return false;
      }
    }
    return true;
  }
}
