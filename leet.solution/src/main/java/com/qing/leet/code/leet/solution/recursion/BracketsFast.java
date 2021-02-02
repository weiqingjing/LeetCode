package com.qing.leet.code.leet.solution.recursion;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


@Slf4j
public class BracketsFast {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        //这里只是边界条件，并不是跳出条件
        if (n <= 0) {
            return res;
        }
        dfs(n, "", res, 0, 0);
        return res;
    }

    //枝剪，剩余成对括号
    private void dfs(int n, String path, List<String> res, int openNum, int closeNum) {
        log.info("dfs begin ..., path.length={},path={},res={}", path.length(), path, JSON.toJSONString(res));
        if (openNum > n || closeNum > openNum) {

            log.info("dfs xxx cut this path ..., path.length={},path={},res={}", path.length(), path, JSON.toJSONString(res));
            return;
        }

        if (path.length() == 2 * n) {
            res.add(path);
            log.info("dfs end ... ,path.length={},path={},res={}", path.length(), path, JSON.toJSONString(res));
            return;
        }
        dfs(n, path + "(", res, openNum + 1, closeNum);
        dfs(n, path + ")", res, openNum, closeNum + 1);
    }

    @Test
    public void test() {
        generateParenthesis(2);
    }

}
