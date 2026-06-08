class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int left = 0, right = 1;
        int maxlen = 1;
        while (right < s.length()) {
            int idx = s.substring(left, right).indexOf(s.charAt(right));
            if (idx!=-1)
                left += idx + 1;
            right++;
            maxlen = Math.max(maxlen, right - left);
        }
        return maxlen;
    }
}