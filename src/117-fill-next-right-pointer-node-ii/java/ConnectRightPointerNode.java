
public class ConnectRightPointerNode {
    public Node connect(Node root) {
        Node head = new Node(0);
        Node iteratorNode = head;
        Node ans = root;

        while (root != null) {
            if (root.left != null) {
                iteratorNode.next = root.left;
                iteratorNode = iteratorNode.next;
            }
            if (root.right != null) {
                iteratorNode.next = root.right;
                iteratorNode = iteratorNode.next;
            }
            root = root.next;
            if (root == null) {
                iteratorNode = head;
                root = head.next;
                head.next = null;
            }
        }
        return ans;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
