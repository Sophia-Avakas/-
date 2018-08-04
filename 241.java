class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if (input == null || input.length() == 0) return res;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> left = diffWaysToCompute(part1);
                List<Integer> right = diffWaysToCompute(part2);
                for (int p1 : left) {
                    for (int p2 : right) {
                        int c = 0;
                        switch(input.charAt(i)) {
                            case '+': c = p1 + p2;
                                break;
                            case '-': c = p1 - p2;
                                break;
                            case '*': c = p1 * p2;
                                break;     
                        }
                        res.add(c);
                    }
                }
            } 
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }
}