// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3773/

class Solution {
public:
    int maxResult(vector<int>& nums, int k) {
        int score = 0;
        deque<pair<int, int>> dq;
        for (int i = 0; i < size(nums); ++i) {
            if (!empty(dq) && dq.front().first == i - k - 1) {
                dq.pop_front();
            }
            score = empty(dq) ? nums[i] : dq.front().second + nums[i];
            while (!empty(dq) && dq.back().second <= score) {
                dq.pop_back();
            }
            dq.emplace_back(i, score);
        }
        return score;
    }
};
