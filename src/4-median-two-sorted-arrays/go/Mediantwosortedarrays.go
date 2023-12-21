// follow https://www.youtube.com/watch?v=q6IEA26hvXc&t=670s
func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
    m := len(nums1)
    n := len(nums2)
    if m > n {
        nums1, nums2 = nums2, nums1
        m, n = n, m
    }
    total := m + n
    half := (total + 1) / 2

    l, r := 0, m-1

    for {
        h1 := (l+r) >> 1
        h2 := half - h1 - 2

        var l1, l2, r1, r2 int
        if h1 >= 0 { l1 = nums1[h1] } else { l1 = -math.MaxInt }
        if h2 >= 0 { l2 = nums2[h2] } else { l2 = -math.MaxInt }
        if h1+1 < m { r1 = nums1[h1+1] } else { r1 = math.MaxInt }
        if h2+1 < n { r2 = nums2[h2+1] } else { r2 = math.MaxInt }

        if l1 <= r2 && l2 <= r1 {
            if (m+n)%2 == 0 {
                return float64(max(l1, l2)+min(r1, r2)) / 2
            }
            return float64(max(l1, l2))
        }

        if l1 > r2 {
            r = h1 - 1
        } else {
            l = h1 + 1
        }
    }
}

func max(a, b int) int {
    if a>b { return a }
    return b
}

func min(a, b int) int {
    if a<b { return a }
    return b
}