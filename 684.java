class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        int[] p = new int[len * 2];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (find(p, from) == find(p, to)) return edge; 
            else p[find(p, to)] = find(p, from);
        }
        return new int[2];
    }
        
    private int find(int[] p, int f) {
        if (f != p[f]) p[f] = find(p, p[f]);
        return p[f];
    }
    
}