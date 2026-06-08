class Solution {
    public int trap(int[] height) {
        int N = height.length;
        int[] preMax = new int[N];
        int[] postMax = new int[N];
        preMax[0] = height[0];
        postMax[N - 1] = height[N - 1];
        for (int i = 1; i < N; i++) {
            preMax[i] = Math.max(preMax[i - 1], height[i]);
            postMax[N - i - 1] = Math.max(postMax[N - i], height[N - i - 1]);
        }
        int ans = 0;
        for (int i = 1; i < N - 1; i++) {
            int waterAtI = Math.min(preMax[i], postMax[i]) - height[i];
            // System.out.printf("at %d, preMax: %d, postMax: %d, height: %d, Water: %d\n", i,
            //     preMax[i], postMax[i], height[i], waterAtI);
            ans += Math.max(waterAtI, 0);
        }
        return ans;
    }
}
