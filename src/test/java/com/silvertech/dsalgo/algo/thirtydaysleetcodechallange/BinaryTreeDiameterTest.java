package com.silvertech.dsalgo.algo.thirtydaysleetcodechallange;

import static org.junit.jupiter.api.Assertions.*;

import com.silvertech.dsalgo.utility.Utils;
import org.junit.jupiter.api.Test;

class BinaryTreeDiameterTest {

  @Test
  void diameterOfBinaryTreeTest() {
    Tree root = new Tree(20);
    int[] vals = {10,5,15,12,18,25,30,35,33,32,34,40};
    for(int val : vals)
      root = Utils.insertIntoBinaryTree(root,val);
    assertEquals(9,BinaryTreeDiameter.diameter(root));
  }

}