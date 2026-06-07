class Solution {
    public int longestConsecutive(int[] nums) {
        // Map<Integer, Integer> ns = new HashMap<>();
        Set<Integer> ns = new HashSet<>();
        for (int num : nums) ns.add(num);

        int maxCount = 0;
        for (int num : nums) {
            if (ns.contains(num - 1))
                continue;
            int count = 0;
            for (int i = num; ns.contains(i); i++) count++;
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
