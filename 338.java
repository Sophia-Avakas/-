class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for(int i = 1; i <= num; i++){
            // we want to right shift one because res[i>>1] must have been calculted already
            res[i] = res[i>>1] + (i&1);
        }
        return res;
    }
}