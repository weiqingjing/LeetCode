package com.qing.leet.code.leet.solution.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class S100 {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> pList = new ArrayList<>();
        transPre(p, pList);

        List<Integer> qList = new ArrayList<>();
        transPre(q, qList);

        if (pList.size() == qList.size()) {
            for (int i = 0; i < pList.size(); i++) {
                if (pList.get(i) == null && pList.get(i) != null) {
                    return false;
                }
                if (pList.get(i) != null && !pList.get(i).equals(qList.get(i))) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    private static void transPre(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
            return;
        }

        list.add(root.val);
        transPre(root.left, list);
        transPre(root.right, list);
    }

    static boolean equal(TreeNode node1, TreeNode node2) {
        //如果都是 null  true
        if (node1 == null && node2 == null) {
            return true;
        }
        //如果有一个不为null false
        if ((node1 == null && node2 != null) || (node2 == null && node1 != null)) {
            return false;
        }
        //value 不一致 false
        if (node1.val != node2.val) {
            return false;
        }
        boolean isEqual = false;
        //check left
        isEqual = equal(node1.left, node2.left);
        //如果是true check right
        if (isEqual) {
            isEqual = equal(node1.right, node2.right);
        }
        //如果是true check value
        if (isEqual && node1.val == node2.val) {
            isEqual = true;
        }
        return isEqual;
    }

    static boolean isSameTreeBest(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        p.left.left = new TreeNode(4);
        p.left.right = new TreeNode(null);
        p.right.left = new TreeNode(5);
        p.right.right = new TreeNode(null);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(4);
        q.left.left = null;
        q.left.right = null;
        q.right.left = null;
        q.right.right = new TreeNode(3);
        q.right.right.left = null;
        q.right.right.right = new TreeNode(5);

        boolean result = isSameTree(p, q);
        System.out.println(result);
    }
}
