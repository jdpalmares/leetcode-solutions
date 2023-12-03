import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] incLinkCounts = new int[numCourses];
        List<List<Integer>> adjs = new ArrayList<>(numCourses);
        initialiseGraph(incLinkCounts, adjs, prerequisites);
        return findBFS(incLinkCounts, adjs);
    }

    private void initialiseGraph(int[] incLinkCounts, List<List<Integer>> adjs, int[][] prerequisites){
        int n = incLinkCounts.length;
        while (n-- > 0) adjs.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            incLinkCounts[edge[0]]++;
            adjs.get(edge[1]).add(edge[0]);
        }
    }

    private int[] findBFS(int[] incLinkCounts, List<List<Integer>> adjs){
        int[] order = new int[incLinkCounts.length];
        Queue<Integer> toVisit = new ArrayDeque<>();
        for (int i = 0; i < incLinkCounts.length; i++)
            if (incLinkCounts[i] == 0)
                toVisit.offer(i);
        int visited = 0;
        while (!toVisit.isEmpty()) {
            int from = toVisit.poll();
            order[visited++] = from;
            for (int to : adjs.get(from)) {
                incLinkCounts[to]--;
                if (incLinkCounts[to] == 0) toVisit.offer(to);
            }
        }
        return visited == incLinkCounts.length ? order : new int[0];
    }

    public int[] findOrderTopSort(int numCourses, int[][] prerequisites) {
        int[] inDeg = new int[numCourses];
        List<Integer>[] chl = new ArrayList[numCourses];
        
        for (int i = 0; i < numCourses; i++)
            chl[i] = new ArrayList<Integer>();
        
        int pre, cour;
        
        for (int[] pair : prerequisites) {
            pre = pair[1];
            cour = pair[0];
            
            chl[pre].add(cour);
            inDeg[cour]++;
        }
        
        int[] res = new int[numCourses];
        int k = 0;
        
        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) res[k++] = i;
        }
        
        if (k == 0) return new int[0];
        
        int j = 0;
        List<Integer> tmp;
        
        while (k < numCourses) {
            tmp = chl[res[j++]];
            
            for (int id : tmp) {
                if (--inDeg[id] == 0) res[k++] = id;
            }
            
            if (j == k) return new int[0];
        }
        
        return res;
    }
}
