class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int[] sufMax = new int[N];
        sufMax[N - 1] = prices[N - 1];
        for (int i = N - 2; i >= 0; i--) sufMax[i] = Math.max(sufMax[i + 1], prices[i]);

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int prof = sufMax[i] - prices[i];
            ans = Math.max(prof, ans);
        }
        return ans;
    }
}
