class Solution {
    public int maxArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        int l = 0, r = heights.length - 1;
        while (l < r) {
            int c = Math.min(heights[l], heights[r]) * (r - l);
            max = Math.max(max, c);
            if (heights[l] < heights[r])
                l++;
            else
                r--;
        }
        return max;
    }
}
