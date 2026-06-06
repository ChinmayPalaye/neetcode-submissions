class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums) {
            freqs.putIfAbsent(num, 0);
            freqs.put(num, freqs.get(num) + 1);
        }
        TreeMap<Integer, List<Integer>> f2i = new TreeMap<>();
        for (Integer key : freqs.keySet()) {
            int f = freqs.get(key);
            f2i.putIfAbsent(f, new ArrayList<Integer>());
            f2i.get(f).add(key);
        }
        int[] ans = new int[k];
        int j = 0;
        for (Integer f : f2i.descendingKeySet()) {
            List<Integer> ns = f2i.get(f);
            for (Integer n : ns) {
                ans[j++] = n;
                if (j >= k)
                    break;
            }
            if (j >= k)
                break;
        }
        return ans;
    }
}
