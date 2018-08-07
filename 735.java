class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        if (asteroids == null || asteroids.length == 0) return new int[0];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) stack.push(asteroids[i]);
            else {
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                }
                else if (Math.abs(stack.peek()) <= Math.abs(asteroids[i])) {
                    if (Math.abs(stack.peek()) < Math.abs(asteroids[i])) i--;
                    stack.pop();    
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(0, stack.pop());
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}