package com.qing.leet.code.leet.solution.tree;

import com.qing.leet.code.leet.solution.tree.TreeNode;
import java.util.HashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class S112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Set<Boolean> set = new HashSet<>();
        dfs(root, targetSum, set);
        return set.contains(true);
    }

    private void dfs(TreeNode root, int targetSum, Set<Boolean> set) {

        if (root.left != null) {
            root.left.val = root.left.val + root.val;
            dfs(root.left, targetSum, set);
        }

        if (root.right != null) {
            root.right.val = root.right.val + root.val;
            dfs(root.right, targetSum, set);
        }

        if (root.left == null && root.right == null) {
            log.info("match:{},current val:{},target:{}", root.val == targetSum, root.val, targetSum);
            set.add(root.val == targetSum);
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        System.out.println(hasPathSum(root, 22));

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        System.out.println(hasPathSum(root, 1));


    }
}
