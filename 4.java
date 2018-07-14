class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int size = len1 + len2;
        int cutL = 0, cutR = len1 - 1;
        int cut1 = 0, cut2 = 0;
        while (cut1 <= len1) {
            cut1 = cutL + (cutR - cutL) / 2;
            cut2 = size / 2 - cut1;
            double L1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double R1 = cut1 == len1 ? Integer.MAX_VALUE : nums1[cut1];
            double L2 = cut2 == 0? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R2 = cut2 == len2 ? Integer.MAX_VALUE : nums2[cut2];
            if (L1 > R2) {
                 cutR = cut1 - 1;
            }
            else if (L2 > R1) {
                cutL = cut1 + 1;
            }
            else {
                if (size % 2 == 0) {
                    return (Math.min(R1, R2) + Math.max(L1, L2)) / 2;
                }
                else {
                    return Math.min(R1, R2);
                }
            }
        }
        return -1;
    }
}