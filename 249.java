class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings == null) return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            int diff = s.charAt(0) - 'a';
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char ch = (char) (s.charAt(i) - diff);
                if (ch < 'a') {
                    ch += 26;
                }
                sb.append(ch);
            }
            String news = sb.toString();
            if (!map.containsKey(news)) {
                map.put(news, new ArrayList<String>());
            }
            map.get(news).add(s);
        }
        
        for (List<String> list : map.values()) {
            res.add(list);
        }
        
        return res;
    }
}