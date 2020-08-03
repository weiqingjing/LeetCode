package com.qing.leet.code.leet.solution.linklist;

public class S21 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode l3 = new ListNode();
        ListNode head = l3;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }

        if (l1 != null) {
            l3.next = l1;
        }
        if (l2 != null) {
            l3.next = l2;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = mergeTwoLists(l1, l2);

        System.out.println(l3);

    }

}
