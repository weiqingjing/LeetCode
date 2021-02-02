package com.qing.leet.code.leet.solution.recursion;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class SimpleDemo {

    // 1.递归公式 f(n) = f(n-1)+1
    // 2.终止条件 f(1) = 1
    private int f1(int n) {
        if (n == 1) {
            return 1;
        }
        return f1(n - 1) + 1;
    }

    //1.递归公式 f(n) = f(n-1)+f(n-2)
    //2.终止条件 f(1) = 1; f(2) = 2;
    private int f2(int n) {
        log.info("current n={}", n);

        if (n == 1) {
            log.info("current n={},result=1", n);
            return 1;
        }
        if (n == 2) {
            log.info("current n={},result=2", n);
            return 2;
        }

        int ret = f2(n - 1) + f2(n - 2);
        log.info("current n={},result={}", n, ret);
        return ret;
    }

    //通过控制递归深度来避免递归过深，内存溢出
    int depth = 0;

    private int f3(int n) {
        ++depth;
        if (depth > 1000) {
            log.error("递归最大深度为1000，超过后自动截断");
            return 1;
        }

        if (n == 1) {
            return 1;
        }

        return f3(n - 1) + 1;
    }

    //解决重复计算
    private Map<Integer, Integer> solvedMap = new HashMap<>();

    private int f4(int n) {
        log.info("current n={}", n);
        if (n == 1) {
            log.info("current n={},result=1", n);
            return 1;
        }

        if (n == 2) {
            log.info("current n={},result=2", n);
            return 2;
        }

        if (solvedMap.containsKey(n)) {
            int tmp = solvedMap.get(n);
            log.info("current n={},result={},get from solvedMap", n, tmp);
            return tmp;
        }

        int ret = f4(n - 1) + f4(n - 2);
        solvedMap.put(n, ret);

        log.info("current n={},result={}", n, ret);
        return ret;
    }


    @Test
    public void test() {
//        log.info("n=5时，在第几排？" + f1(5));
//        log.info("n=5时,f2={}", f2(5));
//        log.info("n=1001时,f3={}", f3(1001));

        log.info("优化前，重复计算***********");
        log.info("f2:{}", f2(6));
        log.info("优化后，避免重复计算***********");
        log.info("f4:{}", f4(6));


    }

}
