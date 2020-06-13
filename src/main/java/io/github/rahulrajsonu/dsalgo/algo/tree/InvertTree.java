package io.github.rahulrajsonu.dsalgo.algo.tree;

public class InvertTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root = insert(root,2);
    root = insert(root,7);
    root = insert(root,1);
    root = insert(root,3);
    root = insert(root,6);
    root = insert(root,9);
    System.out.println(root);
    invert(root);
    System.out.println(root);
  }

  public static TreeNode invert(TreeNode root){
    if(null==root)return null;
    invert(root.left);
    invert(root.right);
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    return root;
  }

  public static TreeNode insert(TreeNode root,int val){
    if(null==root)return new TreeNode(val);
    if(val < root.val){
      root.left = insert(root.left,val);
    }else {
      root.right = insert(root.right,val);
    }
    return root;
  }
}
