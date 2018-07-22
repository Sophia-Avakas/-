class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        
        int[] indeg = new int[numCourses];
        for (int[] pre : prerequisites) {
            indeg[pre[0]]++;
        }
        
        Queue<Integer> queue  = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        
        int k = 0;
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            res[k++] = pre;
            for (int[] pair : prerequisites) {
                if (pair[1] == pre) {
                    indeg[pair[0]]--;
                    if (indeg[pair[0]] == 0) {
                        queue.offer(pair[0]);
                    }
                }
            }
        }
        
        return k == numCourses ? res : new int[0];
        
    }
}