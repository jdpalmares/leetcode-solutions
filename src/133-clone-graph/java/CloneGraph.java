import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;

        Node ans = new Node(node.val);
        Node[] visited = new Node[101];

        Arrays.fill(visited , null);
        depthFirstSearch(node , ans , visited);

        return ans;
    }

    public void depthFirstSearch(Node node , Node ans , Node[] visited){
        visited[ans.val] = ans;
        
        for(Node n : node.neighbors) {
            if( visited[n.val] == null ) {
                Node newNode = new Node(n.val);
                ans.neighbors.add(newNode);
                depthFirstSearch(n , newNode , visited);
            } else {
                ans.neighbors.add(visited[n.val]);
            }
        }
    }
    
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
