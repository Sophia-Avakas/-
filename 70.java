class Solution {
    public boolean judgeCircle(String moves) {
        int res = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'R') res++;
            else if (ch == 'L') res--;
            else if (ch == 'U') res++;
            else if (ch == 'D') res--;
        }
        return res == 0;
    }
}