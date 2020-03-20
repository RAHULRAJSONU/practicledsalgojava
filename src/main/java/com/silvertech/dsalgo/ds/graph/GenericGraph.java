package com.silvertech.dsalgo.ds.graph;

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
public class GenericGraph {
  Vertex[] arrayOfLists;
  int indexCounter;
  boolean unidirectional = true;

  public GenericGraph(int vCount, String graphType){
    if(graphType.equals("directed")){
      this.unidirectional = false;
    }
    arrayOfLists = new Vertex[vCount];
  }

  public void addVertex(String vertexName){
    arrayOfLists[indexCounter] = new Vertex(vertexName, null);
    indexCounter++;
  }

  public void addEdge(String srcVertexName, String destVertexName){
    int v1Idx = indexForName(srcVertexName);
    int v2Idx = indexForName(destVertexName);
    arrayOfLists[v1Idx].adjList = new Node(v2Idx,arrayOfLists[v1Idx].adjList);
    if(unidirectional){
      arrayOfLists[v2Idx].adjList = new Node(v1Idx, arrayOfLists[v2Idx].adjList);
    }
  }

  private int indexForName(String name){
    for(int v=0; v<arrayOfLists.length; v++){
      if(arrayOfLists[v].name.equals(name)){
        return v;
      }
    }
    return -1;
  }

  public void print(){
    System.out.println();
    for(int n=0; n<arrayOfLists.length; n++){
      System.out.print(arrayOfLists[n].name);
      for (Node nNode = arrayOfLists[n].adjList; nNode !=null; nNode = nNode.next){
        System.out.print("--->"+ arrayOfLists[nNode.vertexIdx].name);
      }
      System.out.println("\n");
    }
  }

  class Node{
    public int vertexIdx;
    Node next;
    public Node(int vertexIdx, Node next){
      this.vertexIdx = vertexIdx;
      this.next = next;
    }
  }

  class Vertex{
    String name;
    Node adjList;
    Vertex(String name, Node adj){
      this.name = name;
      this.adjList = adj;
    }
  }
}
