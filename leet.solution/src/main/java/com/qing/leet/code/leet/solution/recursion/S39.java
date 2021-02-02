package com.qing.leet.code.leet.solution.recursion;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class S39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;

    }

    private void dfs(int[] candidates, int target, int index, List<Integer> path, List<List<Integer>> res) {
        log.info("path:{}", path);
        if (target == 0) {
            log.info("找到了满足条件的结果:{}", path);
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            log.info("加起来的和已经超过target,停止搜索,path:{}", path);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            List<Integer> childPath = new ArrayList<>(path);
            childPath.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, childPath, res);
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{2, 3, 6, 7};
        System.out.println(combinationSum(nums, 7));
    }
}
