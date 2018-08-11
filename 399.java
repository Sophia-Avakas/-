class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if (queries == null || queries.length == 0) return new double[0];

        HashMap<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            map.putIfAbsent(equations[i][0], new HashMap<>());
            map.putIfAbsent(equations[i][1], new HashMap<>());
            map.get(equations[i][0]).put(equations[i][1], values[i]);
            map.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
        }
        
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = helper(queries[i][0], queries[i][1], 1.0, new HashSet<String>(), map);
        }
        return res;
    }
    
    private double helper(String start, String end, double value, Set<String> set, HashMap<String, Map<String, Double>> map) {
        if (!map.containsKey(start) || !set.add(start)) return -1;
        if (start.equals(end)) return value;
        Map<String, Double> next = map.get(start);
        if (start == end) return value;
        for (String s: next.keySet()) {
            double res = helper(s, end, value * next.get(s), set, map);
            if (res != -1) return res;
        }
        return -1;
    }
}