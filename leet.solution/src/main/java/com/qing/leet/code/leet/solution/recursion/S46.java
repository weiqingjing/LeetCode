package com.qing.leet.code.leet.solution.recursion;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (j != i) {
//                    for (int k = 0; k < nums.length; k++) {
//                        if (k != i && k != j) {
//                            List<Integer> tmpList = new ArrayList();
//                            tmpList.add(nums[i]);
//                            tmpList.add(nums[j]);
//                            tmpList.add(nums[k]);
//                            resultList.add(tmpList);
//                        }
//                    }
//                }
//            }
//        }
@Slf4j
public class S46 {

    private List<List<Integer>> get(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();

        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numList.add(nums[i]);
        }

        dfs(nums.length, numList, new ArrayList<>(), 0, resultList);

        return resultList;
    }

    private void dfs(int n, List<Integer> numList, List<Integer> tmpList, int currentIndex, List<List<Integer>> res) {
        log.info("n:{},numList:{},tmpList:{},currentIndex:{},res:{}",n,JSON.toJSONString(numList),JSON.toJSONString(tmpList),currentIndex,JSON.toJSONString(res));
        if (tmpList.size() == n || numList.size() == 0) {
            res.add(tmpList);
            return;
        }

        for (int i = 0; i < n; i++) {
            Integer tmp = numList.get(i);
            tmpList.add(tmp);
            numList.remove(i);

            dfs(n, numList, tmpList, currentIndex + 1, res);

        }

    }


    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3};
        log.info("result:{}", JSON.toJSONString(get(nums)));
    }
}
