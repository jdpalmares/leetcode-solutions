/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class LinkedListCycle {
    // 2 pointer solutions
    public boolean hasCycle(ListNode head) {
        ListNode pointA = head, pointB = head;

        while (pointB != null && pointB.next != null) {
            pointA = pointA.next;
            pointB = pointB.next.next;

            if (pointA == pointB)
                return true;
        }

        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
