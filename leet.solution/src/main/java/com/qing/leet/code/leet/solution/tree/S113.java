package com.qing.leet.code.leet.solution.tree;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class S113 {

    public List<List<Integer>> hasPathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        dfs(root, targetSum, root.val + "", root.val, res);
        return res;
    }

    private void dfs(TreeNode root, int targetSum, String path, int sum, List<List<Integer>> res) {
        log.info("current:{},sum:{},path:{}", root.val, sum, JSON.toJSONString(path));

        if (root.left != null) {
            dfs(root.left, targetSum, String.join(",", path, root.left.val + ""), sum + root.left.val, res);
        }

        if (root.right != null) {
            dfs(root.right, targetSum, String.join(",", path, root.right.val + ""), sum + root.right.val, res);
        }

        if (root.left == null && root.right == null) {
            log.info("match:{},current val:{},target:{},sum:{},path:{}", sum == targetSum, root.val, targetSum, sum, JSON.toJSON(path));
            if (sum == targetSum) {
                String[] tmp = path.split(",");
                List<Integer> list = new ArrayList<>();
                for (String s : tmp) {
                    list.add(Integer.valueOf(s));
                }
                res.add(list);
            }
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
        List<List<Integer>> res = hasPathSum(root, 1);

        log.info("{}", JSON.toJSONString(res));

    }


}
