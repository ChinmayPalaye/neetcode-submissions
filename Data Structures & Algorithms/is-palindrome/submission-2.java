class Solution {
    public boolean isPalindrome(String s) {
        int N = s.length();
        int l = 0, r = N - 1;
        String str = s.toLowerCase();
        while (l < r) {
            while (l < N && !isAlpha(str.charAt(l))) l++;
            while (r >= 0 && !isAlpha(str.charAt(r))) r--;
            if (l >= r)
                break;
            if (str.charAt(l) != str.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    private boolean isAlpha(char c) {
        if(c>='a' && c<='z') return true;
        if(c>='A' && c<='Z') return true;
        if(c>='0' && c<='9') return true;
        return false;
    }
}
