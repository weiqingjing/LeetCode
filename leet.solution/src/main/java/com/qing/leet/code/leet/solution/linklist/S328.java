package com.qing.leet.code.leet.solution.linklist;

/**
 * 奇偶列表重排序
 */
public class S328 {

    public static void main(String[] args) {

        //solution1(head1());

        solution2(head2());
    }

    /**
     * 最优解
     */
    private static ListNode solution1(ListNode head) {
        if (head == null) {
            return head;
        }
        //奇数
        ListNode odd = head;
        //偶数
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    /**
     * 这种方式会多产生很多中间变量，不如solution1节省空间
     */
    private static ListNode solution2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode aHead = null;//奇
        ListNode aPointer = null;
        ListNode bHead = null;//偶数
        ListNode bPointer = null;

        int index = 1;

        while (head != null) {
            if (index % 2 == 0) {
                //偶
                if (bHead == null) {
                    bHead = new ListNode(head.val);
                    bPointer = bHead;
                } else {
                    bPointer.next = new ListNode(head.val);
                    bPointer = bPointer.next;
                }
            } else {
                //奇
                if (aHead == null) {
                    aHead = new ListNode(head.val);
                    aPointer = aHead;
                } else {
                    aPointer.next = new ListNode(head.val);
                    aPointer = aPointer.next;
                }
            }
            head = head.next;
            index++;
        }
        aPointer.next = bHead;
        return aHead;
    }


    private static ListNode head1() {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = null;

        return n1;
    }

    private static ListNode head2() {
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for (int i = 1; i < 10; i++) {
            ListNode next = new ListNode(i + 1);
            tmp.next = next;
            tmp = tmp.next;
        }
        return head;
    }
}
