package com.qing.leet.code.leet.solution.linklist;

import com.qing.leet.code.leet.solution.linklist.ListNode;

public class S2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode();
        ListNode l3 = head;

        int tmp = 0;//进位
        while (l1 != null || l2 != null) {
            int t1 = 0;
            if (l1 != null) {
                t1 = l1.val;
            }
            int t2 = 0;
            if (l2 != null) {
                t2 = l2.val;
            }
            int t3 = t1 + t2 + tmp;

            int v1 = 0;
            if (t3 > 9) {
                v1 = Integer.parseInt(String.valueOf(t3).substring(1, 2));
                tmp = Integer.parseInt(String.valueOf(t3).substring(0, 1));
            } else {
                v1 = t3;
                tmp = 0;
            }

            l3.next = new ListNode(v1) ;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

            l3 = l3.next;
        }

        if (tmp > 0) {
            l3.next = new ListNode(tmp);
        }

        return head.next;
    }


    public static ListNode addTwoNumbersWH(ListNode l1, ListNode l2) {

        ListNode virtualHeadNode = new ListNode(0);
        ListNode current = virtualHeadNode;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (l1 != null) { l1 = l1.next; }
            if (l2 != null) { l2 = l2.next; }
        }
        if (carry > 0) { current.next = new ListNode(1); }
        return virtualHeadNode.next;
    }

    public static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }




    public static void main(String[] args) {
//        ListNode l1 = new ListNode(3);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(1);
//
//        ListNode l2 = new ListNode(7);
//        l2.next = new ListNode(7);
//        l2.next.next = new ListNode(8);
//
//        ListNode result = addTwoNumbers(l1, l2);
//        System.out.println(result);

        int a  = reverse(2147483647);
        System.out.println(a);

    }
}
