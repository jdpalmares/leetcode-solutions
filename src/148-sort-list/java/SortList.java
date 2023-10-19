

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
            
        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) p.next = l1;
        
        if (l2 != null) p.next = l2;
        
        return l.next;
    }

    //no recursion solution
    // public ListNode sortList(ListNode head) {
    //     int BUFFER_SIZE = 8;
    //     ListNode dummy = new ListNode(0);
    //     ListNode subdummy = new ListNode(0);
    //     dummy.next = head;
    //     ListNode [] sublists = new ListNode[BUFFER_SIZE];
    //     ListNode [] sublists_tail = new ListNode[BUFFER_SIZE];

    //     for (int steps = 1;; steps *= BUFFER_SIZE) {
    //         ListNode prev = dummy;
    //         ListNode remaining = prev.next;

    //         int num_loops = 0;
    //         for (; null != remaining; ++num_loops) {
    //             for (int i = 0; i < BUFFER_SIZE; ++i) {
    //                 sublists[i] = remaining;
    //                 sublists_tail[i] = null;
    //                 for (int j = 0; null != remaining && j < steps; ++j) {
    //                     sublists_tail[i] = remaining;
    //                     remaining = remaining.next;
    //                 }
    //                 if (null != sublists_tail[i]) sublists_tail[i].next = null;
    //             }

    //             for (int num_sublists = BUFFER_SIZE; 1 < num_sublists; num_sublists /= 2) {
    //                 for (int i = 0; i < num_sublists; i += 2) {
    //                     ListNode subprev = subdummy;
    //                     subprev.next = null;
                    
    //                     while (null != sublists[i] && null != sublists[i + 1]) {
    //                         if (sublists[i].val <= sublists[i + 1].val) {
    //                             subprev.next = sublists[i];
    //                             sublists[i] = sublists[i].next;
    //                         } else {
    //                             subprev.next = sublists[i + 1];
    //                             sublists[i + 1] = sublists[i + 1].next;
    //                         }
    //                         subprev = subprev.next;
    //                     }

    //                     if (null != sublists[i]) {
    //                         subprev.next = sublists[i];
    //                         sublists_tail[i / 2] = sublists_tail[i];
    //                     } else {
    //                         subprev.next = sublists[i + 1];
    //                         sublists_tail[i / 2] = sublists_tail[i + 1];
    //                     }

    //                     sublists[i / 2] = subdummy.next;
    //                 }
    //             }
    //             prev.next = sublists[0];
    //             prev = sublists_tail[0];
    //         }
    //         if (1 >= num_loops) return dummy.next;
    //     }
    // }

    class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
}
