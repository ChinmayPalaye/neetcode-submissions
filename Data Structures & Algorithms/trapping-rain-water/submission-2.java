class Solution {
    public int trap(int[] height) {
        int N = height.length;
        int[] pref = new int[N];
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            pref[i] = i == 0 ? height[i] : pref[i - 1] + height[i];
            map.computeIfAbsent(height[i], k -> new ArrayList<Integer>()).add(i);
        }
        List<Integer> peaks = new ArrayList<>();
        int minPeak = Integer.MAX_VALUE;
        int maxPeak = Integer.MIN_VALUE;
        for (int h : map.descendingKeySet()) {
            for (int i : map.get(h)) {
                if (i > minPeak && i < maxPeak)
                    continue;
                peaks.add(i);
                minPeak = Math.min(i, minPeak);
                maxPeak = Math.max(i, maxPeak);
            }
            if (minPeak == 0 && maxPeak == height.length - 1)
                break;
        }
        Collections.sort(peaks);
        int ans = 0;
        for (int i = 1; i < peaks.size(); i++) {
            int currPeakPos = peaks.get(i);
            int prevPeakPos = peaks.get(i - 1);

            int capacity = (currPeakPos - prevPeakPos - 1)
                * (Math.min(height[currPeakPos], height[prevPeakPos]));
            int valley = pref[currPeakPos - 1] - pref[prevPeakPos];
            ans += (capacity - valley);
        }
        return ans;
    }
}
