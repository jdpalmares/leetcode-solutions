

public class RotateList {
    //solution using 2 pointer
    // public ListNode rotateRight(ListNode head, int k) {
    //     if(head==null) return null;
    //     int size = 1;
    //     ListNode fast = head, slow = head;
        
    //     while(fast.next!=null){
    //         size++;
    //         fast = fast.next;
    //     }
        
    //     for(int i=size-k%size;i>1;i--) slow = slow.next;
        
    //     fast.next = head;
    //     head = slow.next;
    //     slow.next = null;
        
    //     return head;
    // }

    //solution using one pointer only
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ListNode tempNode = head;
        int ctr = 1;
        while(tempNode.next != null) {
            tempNode = tempNode.next;
            ctr++;
        }
        tempNode.next = head;
        k %= ctr;
        for(int i = 0; i < ctr - k; i++) tempNode = tempNode.next;
        head = tempNode.next;
        tempNode.next = null;
        return head;
    }
}

class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}