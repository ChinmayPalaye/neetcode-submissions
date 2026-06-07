class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            map.putIfAbsent(nums[i], new ArrayList<Integer>());
            map.get(nums[i]).add(i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        Set<String> trips = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int sum = nums[i] + nums[j];
                if (!map.containsKey(-sum))
                    continue;
                List<Integer> idxs = map.get(-sum);
                for (int idx : idxs) {
                    if (idx <= i || idx <= j)
                        continue;
                    List<Integer> newList =
                        new ArrayList<Integer>(List.of(nums[i], nums[j], nums[idx]));
                    Collections.sort(newList);
                    String stringList = newList.toString();
                    if (!trips.contains(stringList)) {
                        trips.add(stringList);
                        ans.add(newList);
                    }
                }
            }
        }

        return ans;
    }
}
