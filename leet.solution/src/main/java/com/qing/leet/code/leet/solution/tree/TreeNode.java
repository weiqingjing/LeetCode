package com.qing.leet.code.leet.solution.tree;

public class TreeNode {

    Integer val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    TreeNode(Integer x) {
        val = x;
    }

    public TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
