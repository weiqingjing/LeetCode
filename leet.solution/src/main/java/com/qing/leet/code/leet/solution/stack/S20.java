package com.qing.leet.code.leet.solution.stack;

import com.qing.leet.code.leet.solution.linklist.ListNode;
import java.util.Stack;

public class S20 {

    public static boolean isValid(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }

        char[] chars = s.toCharArray();

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String current = String.valueOf(chars[i]);

            if (stack.size() == 0) {
                stack.push(current);
            } else if ("(".equals(stack.peek()) && ")".equals(current)) {
                stack.pop();
            } else if ("[".equals(stack.peek()) && "]".equals(current)) {
                stack.pop();
            } else if ("{".equals(stack.peek()) && "}".equals(current)) {
                stack.pop();
            } else {
                stack.push(current);
            }
        }

        return stack.size() == 0;
    }

    public static boolean isValid2(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }

        char[] chars = s.toCharArray();

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String current = String.valueOf(chars[i]);
            if(current.equals("(")|| current.equals("[") ||current.equals("{")){
                stack.push(current);
            }else if(stack.size() == 0){
                return false;
            }else if(!stack.pop().equals(current)){
                return false;
            }
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {
        String s = "()";
        boolean result = isValid2(s);
        System.out.println(result);
    }

}
