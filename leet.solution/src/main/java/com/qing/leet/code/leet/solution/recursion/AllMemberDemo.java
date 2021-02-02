package com.qing.leet.code.leet.solution.recursion;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class AllMemberDemo {

    public List<List<Integer>> prmute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);

        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        log.info("backtrack begin ================{},{},{}", first, JSON.toJSONString(output), JSON.toJSONString(res));
        if (first == n) {
            res.add(new ArrayList<>(output));
            log.info("backtrack end ================{},{},{}", first, JSON.toJSONString(output), JSON.toJSONString(res));
        }

        for (int i = first; i < n; i++) {
            log.info("backtrack for ================{},{},{},{}", i,first, JSON.toJSONString(output), JSON.toJSONString(res));

            Collections.swap(output, first, i);
            backtrack(n, output, res, first + 1);
            Collections.swap(output, first, i);
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{7, 8, 9};
        List<List<Integer>> res = prmute(nums);
        System.out.println(JSON.toJSONString(res));

    }

}
