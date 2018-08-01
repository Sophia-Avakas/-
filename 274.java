class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int len = citations.length;
        int[] arr = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (citations[i] > len) {
                arr[len] += 1;
            }
            else {
                arr[citations[i]] +=1;
            }
        }
        
        int sum = 0;
        for (int i = len; i >= 0; i--) {
            sum += arr[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}