// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3730/

class Solution {
    public int[] runningSum(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = nums[0];
        for(int i=1;i<len;i++){
            ans[i] = ans[i-1] + nums[i];
        }
        return ans;
    }
}
