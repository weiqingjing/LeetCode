package com.qing.leet.code.leet.solution.linklist;

public class Offer22 {

    public static ListNode getK(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode kNode = head;
        for (int i = 0; i < k; i++) {
            if (kNode == null) {
                return null;
            }
            kNode = kNode.next;
        }

        while (kNode != null) {
            kNode = kNode.next;
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for (int i = 1; i < 1; i++) {
            ListNode next = new ListNode(i + 1);
            tmp.next = next;
            tmp = tmp.next;
        }

        ListNode kNode = getK(head, 2);
        System.out.println(kNode);
    }
}
