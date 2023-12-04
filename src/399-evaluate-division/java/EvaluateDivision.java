import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {
    // unionfind algorithm solutions/3543257/0ms-o-n-m-most-efficient-solution-modified-unionfind-simple-code/
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Node> map = new HashMap<>();
        List<Double> resList = new LinkedList<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String s1 = equation.get(0), s2 = equation.get(1);

            if (!map.containsKey(s1) && !map.containsKey(s2)) {
                map.put(s1, new Node());
                map.put(s2, new Node());
                map.get(s1).value = values[i];
                map.get(s2).value = 1;
                map.get(s1).parent = map.get(s2);
            } else if (!map.containsKey(s1)) {
                map.put(s1, new Node());
                map.get(s1).value = map.get(s2).value * values[i];
                map.get(s1).parent = map.get(s2);
            } else if (!map.containsKey(s2)) {
                map.put(s2, new Node());
                map.get(s2).value = map.get(s1).value / values[i];
                map.get(s2).parent = map.get(s1);
            } else {
                unionNodes(map.get(s1), map.get(s2), values[i], map);
            }
        }

        for (List<String> query : queries) {
            String s1 = query.get(0), s2 = query.get(1);

            if (!map.containsKey(s1) || !map.containsKey(s2) || findParent(map.get(s1)) != findParent(map.get(s2)))
                resList.add(-1.0);
            else
                resList.add(map.get(s1).value / map.get(s2).value);
        }

        double[] res = new double[resList.size()];
        for (int i = 0; i < res.length; i++) res[i] = resList.get(i);
        return res;
    }

    private static class Node {
        Node parent;
        double value = 0.0;

        Node() {
            parent = this;
        }
    }

    private void unionNodes(Node node1, Node node2, double num, Map<String, Node> map) {
        Node parent1 = findParent(node1);
        Node parent2 = findParent(node2);
        double ratio = node2.value * num / node1.value;

        for (Map.Entry<String, Node> entry : map.entrySet())
            if (findParent(entry.getValue()) == parent1)
                entry.getValue().value *= ratio;

        parent1.parent = parent2;
    }

    private Node findParent(Node node) {
        if (node.parent == node) return node;
        node.parent = findParent(node.parent);
        return node.parent;
    }

    // --------------------------------------- ANOTHER SOLUTION ------------------------------------------------------------
    //leetcode.com/problems/evaluate-division/solutions/3543257/0ms-o-n-m-most-efficient-solution-modified-unionfind-simple-code/
    // public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    //     IdGen idGen = new IdGen();
    //     Relation relation = new Relation(equations.size() * 2 + 1);

    //     for (int i = 0; i < equations.size(); ++i) {
    //         List<String> equation = equations.get(i);
    //         int a = idGen.GetId(equation.get(0));
    //         int b = idGen.GetId(equation.get(1));
    //         relation.Add(a, values[i], b);
    //     }

    //     int maxId = idGen.max();
    //     double[] results = new double[queries.size()];
    //     Arrays.fill(results, -1.0);

    //     for (int i = 0; i < queries.size(); ++i) {
    //         List<String> query = queries.get(i);
    //         int c = idGen.GetId(query.get(0));
    //         if (c > maxId) continue;
    //         int d = idGen.GetId(query.get(1));
    //         if (d > maxId) continue;
    //         Relation.Pair cPair = relation.Find(c), dPair = relation.Find(d);

    //         if (cPair.first != dPair.first) continue;

    //         results[i] = cPair.second / dPair.second;
    //     }

    //     return results;
    // }

    // class Relation {
    //     private final Map<Integer, Pair> base;
    //     private final int[] ranks;
    
    //     public Relation(int size) {
    //         base = new HashMap<>();
    //         ranks = new int[size];
    //         for (int i = 0; i < size; ++i) base.put(i, new Pair(i, 1.0));
    //     }
    
    //     public Pair Find(int x) {
    //         Pair basePair = base.get(x);
    //         if (basePair.first != x) {
    //             Pair result = Find(basePair.first);
    //             basePair.first = result.first;
    //             basePair.second *= result.second;
    //         }
    //         return basePair;
    //     }
    
    //     public void Add(int x, double ratio, int y) {
    //         Pair xPair = Find(x);
    //         Pair yPair = Find(y);
    //         if (xPair.first == yPair.first) return;
    //         if (ranks[xPair.first] < ranks[yPair.first])
    //             base.put(xPair.first, new Pair(yPair.first, ratio * yPair.second / xPair.second));
    //         else if (ranks[xPair.first] > ranks[yPair.first])
    //             base.put(yPair.first, new Pair(xPair.first, xPair.second / ratio / yPair.second));
    //         else {
    //             ++ranks[yPair.first];
    //             base.put(xPair.first, new Pair(yPair.first, ratio * yPair.second / xPair.second));
    //         }
    //     }
    
    //     private static class Pair {
    //         int first;
    //         double second;
    
    //         public Pair(int first, double second) {
    //             this.first = first;
    //             this.second = second;
    //         }
    //     }
    // }
    
    // class IdGen {
    //     private int idCounter = 0;
    //     private final Map<String, Integer> lookup = new HashMap<>();
    
    //     public int GetId(String str) {
    //         int id = lookup.computeIfAbsent(str, k -> ++idCounter);
    //         return id;
    //     }
    
    //     public int max() {
    //         return idCounter;
    //     }
    // }

    // --------------------------------------- ANOTHER SOLUTION ------------------------------------------------------------
    //dfs solution but might be slower on a lot of input
    // public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    //     HashMap<String, HashMap<String, Double>> gr = buildGraph(equations, values);
    //     double[] finalAns = new double[queries.size()];

    //     for (int i = 0; i < queries.size(); i++) {
    //         String dividend = queries.get(i).get(0);
    //         String divisor = queries.get(i).get(1);

    //         if (!gr.containsKey(dividend) || !gr.containsKey(divisor)) {
    //             finalAns[i] = -1.0;
    //         } else {
    //             HashSet<String> vis = new HashSet<>();
    //             double[] ans = {-1.0};
    //             double temp = 1.0;
    //             dfs(dividend, divisor, gr, vis, ans, temp);
    //             finalAns[i] = ans[0];
    //         }
    //     }

    //     return finalAns;
    // }

    // public void dfs(String node, String dest, HashMap<String, HashMap<String, Double>> gr, HashSet<String> vis, double[] ans, double temp) {
    //     if (vis.contains(node))
    //         return;

    //     vis.add(node);
    //     if (node.equals(dest)) {
    //         ans[0] = temp;
    //         return;
    //     }

    //     for (Map.Entry<String, Double> entry : gr.get(node).entrySet()) {
    //         String ne = entry.getKey();
    //         double val = entry.getValue();
    //         dfs(ne, dest, gr, vis, ans, temp * val);
    //     }
    // }

    // public HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
    //     HashMap<String, HashMap<String, Double>> gr = new HashMap<>();

    //     for (int i = 0; i < equations.size(); i++) {
    //         String dividend = equations.get(i).get(0);
    //         String divisor = equations.get(i).get(1);
    //         double value = values[i];

    //         gr.putIfAbsent(dividend, new HashMap<>());
    //         gr.putIfAbsent(divisor, new HashMap<>());

    //         gr.get(dividend).put(divisor, value);
    //         gr.get(divisor).put(dividend, 1.0 / value);
    //     }

    //     return gr;
    // }
}