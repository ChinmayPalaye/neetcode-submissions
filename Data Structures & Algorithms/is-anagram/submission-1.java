class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] f = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            f[sc - 'a']++;
            f[tc - 'a']--;
        }
        for (int p : f)
            if (p != 0)
                return false;
        return true;
    }
}
