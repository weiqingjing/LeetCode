package com.qing.leet.code.leet.solution.linklist;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值 输入： 1->2->3->4->5 和 k = 2 输出： 4
 */
public class Interview0202 {

    /**
     * 使用的中间变量有点多
     */
    private static int solution1(ListNode head, int k) {
        if (head == null) {
            return -1;
        }

        int length = 0;
        ListNode tmpNode = head;
        while (tmpNode != null) {
            length++;
            tmpNode = tmpNode.next;
        }

        if (length < k) {
            return -1;
        }

        int ascK = length - k;
        int index = 0;
        ListNode tNode = head;
        while (tNode != null) {
            index++;

            if (ascK + 1 == index) {
                return tNode.val;
            }
            tNode = tNode.next;
        }
        return -1;
    }

    /**
     * 双指针游走
     */
    private static int solution2(ListNode head, int k) {
        if (head == null) {
            return -1;
        }

        ListNode p = head;
        ListNode q = head;
        for (int i = 1; i < k; i++) {
            if (q != null) {
                q = q.next;
            } else {
                return -1;
            }
        }

        while (q != null) {
            if (q.next == null) {
                return p.val;
            }
            p = p.next;
            q = q.next;
        }
        return -1;
    }

    /**
     * 双指针游走,最优解
     */
    private static int solution3(ListNode head, int k) {
        if (head == null) {
            return -1;
        }

        ListNode q = head;
        for (int i = 0; i < k; i++) {
            if (q != null) {
                q = q.next;
            } else {
                return -1;
            }
        }

        while (q != null) {
            q = q.next;
            head = head.next;
        }
        return head.val;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        ListNode tmp = head;
//        for (int i = 1; i < 10; i++) {
//            ListNode next = new ListNode(i + 1);
//            tmp.next = next;
//            tmp = tmp.next;
//        }
//        int result = solution1(head,2);

        //int result = solution2(head, 2);

        int result = solution3(null, 2);

        System.out.println(result);


    }
}
