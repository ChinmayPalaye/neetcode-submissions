class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<Integer[]> fs = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        for (String str : strs) {
            Integer[] f = new Integer[26];
            Arrays.fill(f, 0);
            for (int i = 0; i < str.length(); i++) {
                f[str.charAt(i) - 'a']++;
            }
            int idx = -1;
            for (int i = 0; i < fs.size(); i++) {
                Integer[] pf = fs.get(i);
                boolean same = true;
                for (Integer j = 0; j < pf.length; j++) {
                    if (f[j] != pf[j]) {
                        same = false;
                        break;
                    }
                }
                if (same) {
                    idx = i;
                    break;
                }
            }
            if (idx != -1) {
                ans.get(idx).add(str);
            } else {
                fs.add(f);
                List<String> lstrs = new ArrayList<>();
                lstrs.add(str);
                ans.add(lstrs);
            }
        }
        return ans;
    }
}
