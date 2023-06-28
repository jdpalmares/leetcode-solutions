class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int currentIdx = m + n - 1;
        while (n > 0) {
            if ( m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[currentIdx] = nums1[--m];
            } else {
                nums1[currentIdx] = nums2[--n];
            }
            currentIdx--;
        }
    }
}