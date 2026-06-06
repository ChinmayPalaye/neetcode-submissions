class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pr = 1;
        int zeros = 0;
        for (int num : nums) {
            if (num != 0)
                pr *= num;
            else
                zeros++;
        }
        int[] ans = new int[nums.length];
        if (zeros > 1)
            return ans;
        for (int i = 0; i < nums.length; i++) {
            if (zeros == 1 && nums[i] == 0)
                ans[i] = pr;
            else if (zeros == 1)
                continue;
            else
                ans[i] = pr / nums[i];
        }
        return ans;
    }
}
