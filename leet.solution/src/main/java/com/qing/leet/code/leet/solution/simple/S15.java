package com.qing.leet.code.leet.solution.simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        List<Integer> negList = new ArrayList<>();
        Integer zero = null;
        List<Integer> posList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero = 0;
            } else if (nums[i] < 0) {
                negList.add(nums[i]);
            } else {
                posList.add(nums[i]);
            }
        }

        Collections.sort(negList);
        Collections.sort(posList);

        for (int i = 0; i < negList.size(); i++) {
            Integer neg = negList.get(i);

        }

        return resultList;
    }

}
