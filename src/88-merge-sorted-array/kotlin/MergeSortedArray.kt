class MergeSortedArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var nums1Len = m;
        var nums2Len = n;
        var currentIdx = m + n - 1;
        while (nums2Len > 0) {
            if ( nums1Len > 0 && nums1[nums1Len - 1] > nums2[nums2Len - 1]) {
                nums1[currentIdx] = nums1[--nums1Len];
            } else {
                nums1[currentIdx] = nums2[--nums2Len];
            }
            currentIdx--;
        }
    }
}