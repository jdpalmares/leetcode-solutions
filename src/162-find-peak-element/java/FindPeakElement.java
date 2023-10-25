
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int numLen = nums.length;
        if(numLen == 0) return -1;
        else if(numLen == 1) return 0;
        else {
            if(nums[0] > nums[1]) return 0;
            if(nums[numLen-1] > nums[numLen-2]) return numLen-1;

            int start = 1, end = numLen - 2;

            while(start <= end) {
                int mid = start + (end - start)/2;
                if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
                else if(nums[mid] < nums[mid-1]) end = mid - 1;
                else if(nums[mid] < nums[mid+1]) start = mid + 1;
            }
        }
        return -1;
    }
}
