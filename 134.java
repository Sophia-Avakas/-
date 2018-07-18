
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0 || cost.length == 0 || gas.length != cost.length) return -1;
        int n = gas.length;
        int index = 0;
        int sum = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                index = i + 1;
                sum = 0;
            }
            total += gas[i] - cost[i];
        }
        return total >= 0 ? index : -1;
    }
}