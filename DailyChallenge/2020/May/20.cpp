// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/600/week-3-may-15th-may-21st/3748/

class Solution {
public:
    int minMoves2(vector<int>& nums) {
       size_t n = nums.size();
       if (n == 0) return 0;

       nth_element(nums.begin(), nums.begin() + n / 2, nums.end());
       int k = nums[n / 2];

       int moves = accumulate(nums.begin(), nums.end(), 0,
               [k](int x, int v) { return x + abs(v - k); });
       return moves;
    }
};
