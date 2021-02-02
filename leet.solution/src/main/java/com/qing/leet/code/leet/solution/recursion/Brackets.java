package com.qing.leet.code.leet.solution.recursion;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


@Slf4j
public class Brackets {


    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        //这里只是边界条件，并不是跳出条件
        if (n <= 0) {
            return res;
        }
        dfs(n, "", res);
        return res;
    }

    //全排列
    private void dfs(int n, String path, List<String> res) {
        log.info("dfs begin ..., path.length={},path={},res={}", path.length(), path, JSON.toJSONString(res));
        if (path.length() == 2 * n) {
            res.add(path);
            log.info("dfs end ... ,path.length={},path={},res={}", path.length(), path, JSON.toJSONString(res));
            return;
        }
        dfs(n, path + "(", res);
        dfs(n, path + ")", res);
    }

    @Test
    public void test() {
        generateParenthesis(2);
    }

}
