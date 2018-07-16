class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) return new int[0][0];
        int n = people.length;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? (a[1] - b[1]) : (b[0] - a[0]));
        for (int[] p : people) {
            int index = p[1];
            list.add(index, p);
        }
        return list.toArray(new int[n][2]);
    }
}