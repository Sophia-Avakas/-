class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0) return -1;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < bank.length; i++) {
            set.add(bank[i]);
        }
        if (!set.contains(end)) return -1;
        if (set.contains(start)) set.remove(start);
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        HashMap<String, Integer> map = new HashMap<>();
        map.put(start, 0);
        char[] letters = {'A', 'C', 'G', 'T'};
        while (!queue.isEmpty()) {
            String curStr = queue.poll();
            int level = map.get(curStr);
            for (int i = 0; i < curStr.length(); i++) {
                char[] curArr = curStr.toCharArray();
                char ch = curArr[i];
                for (int j = 0; j < letters.length; j++) {
                    if (letters[j] == ch) continue;
                    curArr[i] = letters[j];
                    String newStr = new String(curArr);
                    if (set.contains(newStr)) {
                        if (newStr.equals(end)) {
                            return level + 1;
                        }
                        map.put(newStr, level + 1);
                        queue.offer(newStr);
                        set.remove(newStr);
                    }
                }
                curArr[i] = ch;
            }
        }
        return -1;
    }
}