package com.qing.leet.code.leet.solution.simple;

public class S415 {

    //https://www.jianshu.com/p/84e2b8d06f19
    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;

        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }

        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("86043", "5582"));
    }
}
