package com.silvertech.dsalgo.algo.tree;

import java.util.Objects;

class TreeNode implements Comparable{
  int val;
  TreeNode left;
  TreeNode right;
  public TreeNode(int val){
    this.val = val;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TreeNode)) {
      return false;
    }
    TreeNode node = (TreeNode) o;
    return val == node.val;
  }

  @Override
  public int hashCode() {
    return Objects.hash(val);
  }

  @Override
  public int compareTo(Object o) {
    return Integer.valueOf(this.val).compareTo(((TreeNode)o).val);
  }
}
