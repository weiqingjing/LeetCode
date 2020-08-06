package com.qing.leet.code.leet.solution.tree;

public class Offer55_1 {

    //先序
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            System.out.println("叶子节点！");
            return 0;
        }

        System.out.println("current tree node:" + root.val);
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(7);

        System.out.println(maxDepth(root));
    }
}
