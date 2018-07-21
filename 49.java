class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String strSort = new String(strArray);
            strSort = new String(strArray);
            if (!map.containsKey(strSort)) {
                map.put(strSort, new ArrayList<String>());
            }
            map.get(strSort).add(str);
        }
        
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }
}