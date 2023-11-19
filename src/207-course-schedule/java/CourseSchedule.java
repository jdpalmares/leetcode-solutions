import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    //Breadth First Search Solution
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue queue = new LinkedList();
        int count=0;
        
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();
            
        for(int i=0; i<prerequisites.length;i++){
            degree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for(int i=0; i<degree.length;i++){
            if(degree[i] == 0){
                queue.add(i);
                count++;
            }
        }
        
        while(queue.size() != 0){
            int course = (int)queue.poll();
            for(int i=0; i<graph[course].size();i++){
                int pointer = (int)graph[course].get(i);
                degree[pointer]--;
                if(degree[pointer] == 0){
                    queue.add(pointer);
                    count++;
                }
            }
        }
        if(count == numCourses) return true;
        else return false;
    }

    //Depth First Search Solution (TLE)
    // public boolean canFinish(int numCourses, int[][] prerequisites) {
    //     ArrayList[] graph = new ArrayList[numCourses];
    //     for(int i = 0; i < numCourses; i++)
    //         graph[i] = new ArrayList();
            
    //     boolean[] visited = new boolean[numCourses];
    //     for(int i=0; i<prerequisites.length;i++){
    //         graph[prerequisites[i][1]].add(prerequisites[i][0]);
    //     }

    //     for(int i = 0; i < numCourses; i++)
    //         if(!dfs(graph,visited,i)) return false;
    //     return true;
    // }
    // private boolean dfs(ArrayList[] graph, boolean[] visited, int course){
    //     if(visited[course]) return false;
    //     else visited[course] = true;;

    //     for(int i=0; i<graph[course].size();i++)
    //         if(!dfs(graph,visited,(int)graph[course].get(i)))
    //             return false;

    //     visited[course] = false;
    //     return true;
    // }

    //BFS Kahn's Algo (slower)
    // public boolean canFinish(int n, int[][] prerequisites) {
    //     List<Integer>[] adj = new List[n];
    //     int[] indegree = new int[n];
    //     List<Integer> ans = new ArrayList<>();

    //     for (int[] pair : prerequisites) {
    //         int course = pair[0];
    //         int prerequisite = pair[1];
    //         if (adj[prerequisite] == null) adj[prerequisite] = new ArrayList<>();
    //         adj[prerequisite].add(course);
    //         indegree[course]++;
    //     }

    //     Queue<Integer> queue = new LinkedList<>();
    //     for (int i = 0; i < n; i++)
    //         if (indegree[i] == 0) queue.offer(i);

    //     while (!queue.isEmpty()) {
    //         int current = queue.poll();
    //         ans.add(current);

    //         if (adj[current] != null) {
    //             for (int next : adj[current]) {
    //                 indegree[next]--;
    //                 if (indegree[next] == 0) queue.offer(next);
    //             }
    //         }
    //     }

    //     return ans.size() == n;
    // }
}
