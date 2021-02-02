package com.qing.leet.code.leet.solution.tree;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class S46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> allList = new ArrayList<>();
        for(int num:nums){
            allList.add(num);
        }

        dfs(allList,new ArrayList<>(),res);
        return res;
    }

    private void dfs(List<Integer> allList, List<Integer> selectedList, List<List<Integer>> res) {
        if (selectedList.size() == allList.size()) {
            res.add(new ArrayList<>(selectedList));
            return;
        }

        List<Integer> currentList = new ArrayList<>(allList);
        currentList.removeAll(selectedList);

        for (Integer num : currentList) {
            List<Integer> selectedChildList = new ArrayList<>(selectedList);
            selectedChildList.add(num);

            dfs(allList, selectedChildList, res);
        }
    }

    @Test
    public void test(){
        int[] nums = new int[]{};
        System.out.println(JSON.toJSONString(permute(nums)));
    }
}
