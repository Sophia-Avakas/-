class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];
        
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                set.add(num);
            }
        }
        
        int n = set.size();
        int[] res = new int[n];
        int i = 0;
        for (int num : set) {
            res[i++] = num;
        }
        
        return res;
    }
}