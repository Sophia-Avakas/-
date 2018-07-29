public class Codec {
    
    Map<String, String> map1 = new HashMap<>();
    Map<String, String> map2 = new HashMap<>();
    String baseurl = "https://leetcode.com";
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    Random random = new Random();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (map1.containsKey(longUrl)) return baseurl + map1.get(longUrl);
        StringBuilder sb = new StringBuilder();
        do {
            for (int i = 0; i < 6; i++) {
                sb.append(characters.charAt(random.nextInt(characters.length())));
            }
        } while (map1.containsKey(sb.toString()));
        map1.put(longUrl, sb.toString());
        map2.put(sb.toString(), longUrl);
        return baseurl + map1.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map2.get(shortUrl.substring(baseurl.length()));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));