package com.qing.leet.code.leet.solution.linklist;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class S206 {

    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode before, ListNode current) {
        if (current == null) {
            return before;
        }
        ListNode next = current.next;
        current.next = before;
        return reverse(current, next);
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        log.info("node before:{}", JSON.toJSONString(head));
        ListNode node = reverseList(head);
        log.info("node after:{}", JSON.toJSONString(head));

    }

}
