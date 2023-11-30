import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestSums {
    //use minheap to get answer in O(klogk) time
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<> ();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return ans;
        
        PriorityQueue<int[]> minPQueue = new PriorityQueue<>(
            (arr1, arr2) -> arr1[0] + arr1[1] - arr2[0] - arr2[1]
        );
        
        for (int i = 0; i < nums1.length && i < k; i++)
            minPQueue.offer (new int[] {nums1[i], nums2[0], 0});
        
        while (k-- != 0 && !minPQueue.isEmpty ()) {
            int[] curr = minPQueue.poll();
            ans.add(List.of (curr[0], curr[1]));
            if (curr[2] + 1 < nums2.length)
                minPQueue.offer (new int[] {curr[0], nums2[curr[2] + 1], curr[2] + 1});
        }
        
        return ans;
    }
}
