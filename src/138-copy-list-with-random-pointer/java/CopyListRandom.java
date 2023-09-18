
public class CopyListRandom {
    public Node copyRandomList(Node head) {
        Node reference = head, next;

        while (reference != null) { // make copy of each node
            next = reference.next;

            Node copy = new Node(reference.val);
            reference.next = copy;
            copy.next = next;

            reference = next;
        }

        reference = head;
        while (reference != null) { // assign random pointers for the copy nodes.
            if (reference.random != null)
                reference.next.random = reference.random.next;
            reference = reference.next.next;
        }

        reference = head;
        Node ans = new Node(0);
        Node copy, copyReference = ans;

        while (reference != null) { // restore the original list, and extract the copy list.
            next = reference.next.next;

            copy = reference.next;
            copyReference.next = copy;
            copyReference = copy;

            reference.next = next;
            reference = next;
        }

        return ans.next;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
