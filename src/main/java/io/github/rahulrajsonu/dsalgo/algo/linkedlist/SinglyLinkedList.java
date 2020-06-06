package io.github.rahulrajsonu.dsalgo.algo.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

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
public class SinglyLinkedList {
  Node head;

  public static void main(String[] args) {
    SinglyLinkedList list = new SinglyLinkedList();
    list.insertLast(35);
    list.insertLast(20);
    list.insertLast(25);
    list.insertLast(30);
    list.insertLast(40);
    list.sort();
    SinglyLinkedList list2 = new SinglyLinkedList();
    list2.insertLast(45);
    list2.insertLast(50);
    list2.insertLast(60);
    list2.insertLast(65);
    list2.insertLast(70);
    SinglyLinkedList list3 = new SinglyLinkedList();
    list3.insertLast(75);
    list3.insertLast(80);
    list3.insertLast(85);
    list3.insertLast(90);
    list3.insertLast(95);
    SinglyLinkedList list4 = new SinglyLinkedList();
    list4.insertLast(-2);
    list4.insertLast(-1);
    list4.insertLast(-1);
    list4.insertLast(-1);
    list.mergeKSortedFaster(new SinglyLinkedList[]{list4,new SinglyLinkedList(),list3,list,list2});
    System.out.println();
    list.print();
  }

  public void insertLast(int val){
    Node newNode = new Node(val);
    if(null == head){
      head = newNode;
    }else{
      Node current = head;
      while (true){
        if(null == current.next){
          current.next = newNode;
          break;
        }
        current = current.next;
      }
    }
  }

  public void mergeKSorted(SinglyLinkedList[] list){
    PriorityQueue<Node> heap = new PriorityQueue<>((Comparator<Node>)(n1,n2)->n1.data-n2.data);
    for (SinglyLinkedList l: list){
      Node current = l.head;
      while (null != current){
        heap.offer(current);
        current = current.next;
      }
    }
    reset();
    while (!heap.isEmpty()){
      insertLast(heap.poll().data);
    }
  }

  public void mergeKSortedFaster(SinglyLinkedList[] list){
    PriorityQueue<Node> heap = new PriorityQueue<>((Comparator<Node>)(n1,n2)->n1.data-n2.data);
    for(SinglyLinkedList sl : list){
      if(sl.head != null)
        heap.offer(sl.head);
    }
    Node pre = new Node(-1);
    Node temp = pre;
    while (!heap.isEmpty()){
      Node current = heap.poll();
      temp.next = new Node(current.data);
      if(null != current.next){
        heap.offer(current.next);
      }
      temp = temp.next;
    }
    reset();
    this.head = pre.next;
  }

  public void mergeTowSorted(SinglyLinkedList list){
    sort();
    Node dummy = new Node(-1);
    Node temp = dummy;
    Node inp = list.head;
    while (null != inp && null != this.head){
      if(inp.data < this.head.data){
        dummy.next = inp;
        inp = inp.next;
      }else {
        dummy.next = this.head;
        this.head = this.head.next;
      }
      dummy = dummy.next;
    }

    if(inp != null){
      dummy.next = inp;
    }else{
      dummy.next = this.head;
    }
    reset();
    this.head = temp.next;
  }

  private void sort() {
    PriorityQueue<Node> queue = new PriorityQueue<>((Comparator<Node>)(n1,n2)->n1.data-n2.data);
    Node current = head;
    while (null != current){
      queue.offer(current);
      current = current.next;
    }
    reset();
    while (!queue.isEmpty()){
      insertLast(queue.poll().data);
    }
  }

  private void reset() {
    head = null;
  }

  public void print(){
    Node current = head;
    while (null != current){
      System.out.print(current.data+(null!=current.next?"->":""));
      current = current.next;
    }
  }

}
