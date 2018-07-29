class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int index = 0;
        int res = 0;
        for (int house : houses) {
            while (index < heaters.length && heaters[index] < house) index++;
            int dist = Integer.MAX_VALUE;
            if (index != 0) {
                dist = Math.min(dist, house - heaters[index - 1]);
            }
            if (index != heaters.length) {
                dist = Math.min(dist, heaters[index] - house);
            }
            res = Math.max(res, dist);
        }
        return res;
    }
}