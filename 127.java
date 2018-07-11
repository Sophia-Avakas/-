class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int curLevel = map.get(word);
            char[] ch = word.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                char c = ch[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    ch[i] = j;
                    String newWord = String.valueOf(ch);
                   
                    if (set.contains(newWord)) {
                        
                         if (newWord.equals(endWord)) {
                            return curLevel + 1;
                         }
                        
                        queue.offer(newWord);
                        set.remove(newWord);
                        map.put(newWord, curLevel + 1);
                    }
                }
                ch[i] = c;
                
            }
        }
        return 0;
    }
    

}