package com.qing.leet.code.leet.solution.linklist;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class S92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        return process(head, m, n, 1);
    }

    private ListNode process(ListNode head, int m, int n, int index) {
        log.info("process current:{},index:{},m:{}", head.val, index,m);
        if (index >= m) {
            reverse(head, head.next, n, index + 1);
        }
        return process(head.next, m, n, index + 1);
    }

    private ListNode reverse(ListNode before, ListNode current, int n, int index) {
        log.info("reverse current:{},index:{}", current.val, index);

        if (index == n) {
            return before;
        }
        ListNode next = current.next;
        current.next = before;
        return reverse(current, next, n, index + 1);
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        log.info("node before:{}", JSON.toJSONString(head));
        ListNode node = reverseBetween(head, 2, 4);
        log.info("node after:{}", JSON.toJSONString(node));

    }
}
