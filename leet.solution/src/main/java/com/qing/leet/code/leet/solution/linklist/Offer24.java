package com.qing.leet.code.leet.solution.linklist;

import java.util.List;

/**
 * 单链表反转
 */
public class Offer24 {

    /**
     * 自己写的
     */
    private static ListNode solution1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode revertTail = head;
        ListNode revertHead = head.next;

        head = head.next.next;
        revertTail.next = null;

        while (head != null) {
            revertHead.next = revertTail;
            revertTail = revertHead;
            revertHead = head;
            head = head.next;
        }

        revertHead.next = revertTail;
        return revertHead;
    }

    /**
     * 最优解
     */
    private static ListNode solution2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * 自己改良的最优解
     */
    private static ListNode solution3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for (int i = 1; i < 10; i++) {
            ListNode next = new ListNode(i + 1);
            tmp.next = next;
            tmp = tmp.next;
        }
//        ListNode result = solution1(head);
//        ListNode result = solution2(head);
        ListNode result = solution3(head);
        System.out.println(result);
    }
}
