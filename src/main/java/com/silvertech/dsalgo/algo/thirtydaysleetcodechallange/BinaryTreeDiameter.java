package com.silvertech.dsalgo.algo.thirtydaysleetcodechallange;

import static java.lang.Integer.max;

public class BinaryTreeDiameter {

  public static int diameter(Tree root){
    if(null==root)return 0;
    int leftHeight = treeHeight(root.left);
    int rightHeight = treeHeight(root.right);
    int leftDiameter = diameter(root.left);
    int rightDiameter = diameter(root.right);
    return max((leftHeight+rightHeight+1),max(leftDiameter,rightDiameter));
  }

  private static int treeHeight(Tree root) {
    if(null==root)return 0;
    return max(treeHeight(root.left),treeHeight(root.right))+1;
  }

}
