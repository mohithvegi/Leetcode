// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/602/week-5-may-29th-may-31st/3761/


class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int max = nums[0];
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }

            if (min > nums[i]) {
                min = nums[i];
            }
        }

        int bucketSize = (max - min) / (nums.length) + 1;
        int[] bucketsMax = new int[nums.length + 1];
        int[] bucketsMin = new int[nums.length + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            bucketsMax[i] = -1;
            bucketsMin[i] = -1;
        }

        for (int num : nums) {
            int index = (num - min) / bucketSize;
            if (bucketsMax[index] < num) bucketsMax[index] = num;

            if (bucketsMin[index] != -1) {
                if (bucketsMin[index] > num) {
                    bucketsMin[index] = num;
                }
            } else {
                bucketsMin[index] = num;
            }
        }

        int preMax = bucketsMax[0];
        int maxGap = 0;
        for (int i = 1; i <= nums.length; i++) {

            if (preMax != -1) {
                maxGap = bucketsMin[i] - preMax > maxGap ? bucketsMin[i] - preMax : maxGap;
            }

            if (bucketsMax[i] != -1) {
                preMax = bucketsMax[i];
            }
        }

        return maxGap;
    }
}
