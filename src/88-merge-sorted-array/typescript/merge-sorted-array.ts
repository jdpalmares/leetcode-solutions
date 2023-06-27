function merge(nums1: number[], m: number, nums2: number[], n: number): void {
    let currentIdx = m + n - 1;
    while (n) {
        if ( m > 0 && nums1[m - 1] > nums2[n - 1]) {
            nums1[currentIdx] = nums1[--m];
        } else {
            nums1[currentIdx] = nums2[--n];
        }
        currentIdx--;
    }
};