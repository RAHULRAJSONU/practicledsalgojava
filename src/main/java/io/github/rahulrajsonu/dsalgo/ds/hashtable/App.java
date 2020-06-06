package io.github.rahulrajsonu.dsalgo.ds.hashtable;

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
public class App {
  public static void main(String[] args) {
    HashTable hsTable = new HashTable(19);
    hsTable.insert("Apple");
    hsTable.insert("Dog");
    hsTable.insert("Axe");
    hsTable.insert("lend");
    hsTable.insert("pole");
    hsTable.insert("egg");
    hsTable.insert("Nose");
    hsTable.insert("Parrot");
    hsTable.insert("Laptop");
    hsTable.insert("Savings");
    System.out.println(hsTable.search("Apple"));
    System.out.println(hsTable.search("Axe"));
    System.out.println(hsTable.search("Savings"));
    System.out.println(hsTable.search("Nose"));
    System.out.println(hsTable.search("Laptop"));
    System.out.println(hsTable.search("Dog"));
    System.out.println(hsTable.search("Nose"));
    System.out.println(hsTable.search("lend"));
    System.out.println(hsTable.search("asdadsds"));
  }
}
