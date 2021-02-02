package com.qing.leet.code.leet.solution.recursion;


import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ThereNum {


    private int max(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }


    @Test
    public void run() {
        int[] nums = new int[]{-1, -2, -3};
//        log.info("three nums the max result:{}", max(nums));

    }
}
