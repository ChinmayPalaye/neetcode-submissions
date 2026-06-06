class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append("-");
            sb.append(str);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            StringBuilder lenS = new StringBuilder();
            // int j = i;
            while (str.charAt(i) != '-') {
                lenS.append(str.charAt(i++));
            }
            // System.out.println(lenS.toString());
            int len = lenS.toString() == "" ? 0 : Integer.parseInt(lenS.toString());
            StringBuilder word = new StringBuilder();
            i++;
            // i = j;
            for (int k = i; k < i + len; k++) {
                word.append(str.charAt(k));
            }
            i += len;
            ans.add(word.toString());
        }
        return ans;
    }
}
