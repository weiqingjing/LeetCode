package com.qing.leet.code.leet.solution.recursion;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class SumNum {


    private int sum(int current, int[] nums) {
        log.info("{},{}", current, JSON.toJSONString(nums));
        if (current == nums.length) {
            return 0;
        }
        int sum = nums[current] + sum(current + 1, nums);
        log.info("sum:{}", sum);
        return sum;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        sum(0, nums);
    }
}
