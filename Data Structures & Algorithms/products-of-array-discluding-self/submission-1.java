class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] prL = new int[N];
        int[] prR = new int[N];
        prL[0] = 1;
        prR[N - 1] = 1;
        for (int i = 1; i < N; i++) prL[i] = prL[i - 1] * nums[i - 1];
        for (int i = N - 2; i >= 0; i--) prR[i] = prR[i + 1] * nums[i + 1];
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) ans[i] = prL[i] * prR[i];
        return ans;
    }
}
