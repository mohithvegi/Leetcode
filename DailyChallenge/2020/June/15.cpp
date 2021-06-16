// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3780/

class Solution {
public:
    bool makesquare(vector<int>& nums) {
        int sum = accumulate(nums.begin(), nums.end(), 0);
        if (sum % 4) {
            return false;
        }

        const auto side_len = sum / 4;
        const auto all = (1 << nums.size()) - 1;

        vector<int> used_subsets;
        vector<bool> valid_half_subsets(1 << nums.size());

        for (int subset = 0; subset <= all; ++subset) {
            int subset_sum = 0;
            for (int i = 0; i < nums.size(); ++i) {
                if (subset & (1 << i)) {
                    subset_sum += nums[i];
                }
            }
            if (subset_sum == side_len) {
                for (const auto& used_subset : used_subsets) {
                    if ((used_subset & subset) == 0) {
                        int valid_half_subset = used_subset | subset;
                        valid_half_subsets[valid_half_subset] = true;
                        if (valid_half_subsets[all ^ valid_half_subset]) {
                            return true;
                        }
                    }
                }
                used_subsets.emplace_back(subset);
            }
        }
        return false;   
    }
};
