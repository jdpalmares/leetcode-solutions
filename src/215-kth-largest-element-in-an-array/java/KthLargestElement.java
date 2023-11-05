import java.util.PriorityQueue;

public class KthLargestElement {
    //solution using min-heap
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> ans = new PriorityQueue<>();
        for (int i = 0; i < k; i++) ans.offer(nums[i]);
        
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > ans.peek()) {
                ans.poll();
                ans.offer(nums[i]);
            }
        }
        
        return ans.peek();
    }

    //solution using quickSelect START
    // public int findKthLargest(int[] nums, int k) {
    //     return quickSelect(nums, 0, nums.length - 1, k - 1);
    // }

    // private int quickSelect(int[] nums, int left, int right, int k) {
    //     while(true) {
    //         if(left == right)
    //             return nums[left];
    //         int pivotIndex = getPivot(nums, left, right);
    //         pivotIndex = partition(nums, left, right, pivotIndex);
    //         if(pivotIndex == k)
    //             return nums[k];
    //         else if(pivotIndex > k)
    //             right = pivotIndex-1;
    //         else
    //             left = pivotIndex+1;
    //     }
    // }

    // private int getPivot(int[] nums, int left, int right) {
    //     int mid = left + (right - left) / 2;
    //     if(nums[right] > nums[left])
    //         swap(nums, left, right);
    //     if(nums[right] > nums[mid])
    //         swap(nums, right, mid);
    //     if(nums[mid] > nums[left])
    //         swap(nums,left, mid);
    //     return mid;
    // }

    // private int partition(int[] nums, int left, int right, int pivotIndex) {
    //     int pivotValue = nums[pivotIndex];
    //     swap(nums, pivotIndex, right);
    //     int index = left;
    //     for(int i = left; i < right; ++i) {
    //         if(nums[i] > pivotValue) {
    //             swap(nums, index, i);
    //             ++index;
    //         }
    //     }
    //     swap(nums, right, index);
    //     return index;
    // }

    // private void swap(int[] nums, int x, int y) {
    //     int temp = nums[x];
    //     nums[x] = nums[y];
    //     nums[y] = temp;
    // }
    //solution using quickSelect END
}
