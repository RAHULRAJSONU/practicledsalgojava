package io.github.rahulrajsonu.dsalgo.ds.graph;

import java.util.ArrayList;

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
public class Graph {
  private int vCount;
  private int eCount;
  private ArrayList[] adjacents;

  public Graph(int vCount){
    this.vCount = vCount;
    this.eCount = 0;
    adjacents = new ArrayList[vCount];
    for(int m = 0; m < vCount; m++){
      adjacents[m] = new ArrayList<Integer>();
    }
  }

  public int getVertexCount(){
    return this.vCount;
  }

  public int getEdgeCount(){
    return this.eCount;
  }

  public void addEdge(int source, int destination){
    adjacents[source].add(destination);
    eCount++;
  }

  public Object[] adj(int source){
    return adjacents[source].toArray();
  }
}
