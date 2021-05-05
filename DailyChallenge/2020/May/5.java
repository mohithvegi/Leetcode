// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3732/

class Solution {
    public int jump(int[] nums) {
     if (nums == null || nums.length == 0)
		return 0;
 
	int lastReach = 0;
	int reach = 0;
	int step = 0;
 
	for (int i = 0; i <= reach && i < nums.length; i++) {
		//when last jump can not read current i, increase the step by 1
		if (i > lastReach) {
			step++;
			lastReach = reach;
		}
		//update the maximal jump 
		reach = Math.max(reach, nums[i] + i);
	}
 
	if (reach < nums.length - 1)
		return 0;
 
	return step;   
    }
}
