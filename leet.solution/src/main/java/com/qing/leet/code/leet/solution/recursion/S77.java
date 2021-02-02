package com.qing.leet.code.leet.solution.recursion;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class S77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> allList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            allList.add(i + 1);
        }

        dfs(k, allList, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int k, List<Integer> unSelectedList, List<Integer> selectedList, List<List<Integer>> res) {
        log.info("k={}", k);
        log.info("unSelectedList:{}", JSON.toJSONString(unSelectedList));
        log.info("selectedList:{}", JSON.toJSONString(selectedList));
        log.info("res:{}", JSON.toJSONString(res));
        log.info("selectedList.size:{}", selectedList.size());
        log.info("--------------------------------");
        if (selectedList.size() == k) {
            res.add(new ArrayList<>(selectedList));
            return;
        }

        for (int i = 0; i < unSelectedList.size(); i++) {
            List<Integer> childUnSelectedList = unSelectedList.subList(i + 1, unSelectedList.size());
            List<Integer> childSelectedList = new ArrayList<>(selectedList);
            childSelectedList.add(unSelectedList.get(i));

            dfs(k, childUnSelectedList, childSelectedList, res);
        }
    }


    private void dfs2(int n, int k, int current, List<Integer> selectedList, List<List<Integer>> res) {
        log.info("k={}", k);
        log.info("selectedList:{}", JSON.toJSONString(selectedList));
        log.info("res:{}", JSON.toJSONString(res));
        log.info("selectedList.size:{}", selectedList.size());
        log.info("--------------------------------");
        if (selectedList.size() == k) {
            res.add(new ArrayList<>(selectedList));
            return;
        }

        for (int i = 0; i < n - current; i++) {
            List<Integer> childList = new ArrayList<>(selectedList);
            childList.add(i + 1 + current);
            dfs2(n, k, i + current + 1, childList, res);
        }
    }

    @Test
    public void test() {
        log.info("result1:{}", JSON.toJSONString(combine(4, 2)));

        List<List<Integer>> res = new ArrayList<>();
        dfs2(4, 2, 0, new ArrayList<>(), res);
        log.info("result2:{}", JSON.toJSONString(res));
    }

}
