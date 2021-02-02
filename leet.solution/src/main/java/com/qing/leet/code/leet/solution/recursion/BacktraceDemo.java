package com.qing.leet.code.leet.solution.recursion;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 回溯算法
 *
 */

@Slf4j
public class BacktraceDemo {


    //循环求解
    private int[] sumNums(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i + 1] = nums[i + 1] + nums[i];
        }
        return nums;
    }

    //递归求解
    private int sumNum(int n, int[] nums) {
        log.info("当前n:{}", n);
        if (n == 0) {
            log.info("n:{},nums[n]:{}", n, nums[0]);
            return nums[0];
        }
        nums[n] = sumNum(n - 1, nums) + nums[n];
        log.info("n:{},nums[n]:{}", n, nums[n]);
        return nums[n];
    }

    @Test
    public void test() {

        int[] nums = new int[]{1, 2, 3, 4};

        log.info("result{}", JSON.toJSONString(sumNums(nums)));

        log.info("result{}", JSON.toJSONString(sumNum(nums.length - 1, nums)));

    }

}
