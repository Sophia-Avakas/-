class Solution {
    public int trap(int[] height) {
        int res = 0;
        if (height == null || height.length == 0) return res;
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                maxLeft = Math.max(maxLeft, height[left]);
                res += maxLeft - height[left];
                left++;
            }
            else {
                maxRight = Math.max(maxRight, height[right]);
                res += maxRight - height[right];
                right--;
            }
            
        }
    return res;
    }
}