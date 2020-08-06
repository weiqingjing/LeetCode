package com.qing.leet.code.leet.solution.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer33_3 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }

        int j = 1;
        while (!queue.isEmpty()) {
            List<Integer> row = new ArrayList<>();

            int count = queue.size();
            for (int i = count; i > 0; i--) {

                TreeNode node = queue.poll();
                row.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (j % 2 > 0) {
                list.add(row);
            } else {
                Collections.reverse(row);
                list.add(row);
            }
            j++;
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = levelOrder(root);
        System.out.println(result);
    }

}
