//https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3670/

class Solution {
public:
    int numFactoredBinaryTrees(vector<int>& A) {
        long res = 0, M = 1e9 + 7;
        unordered_map<int, long> dp;
        sort(A.begin(), A.end());
        for (int i = 0; i < A.size(); ++i) {
            dp[A[i]] = 1;
            for (int j = 0; j < i; ++j) {
                if (A[i] % A[j] == 0 && dp.count(A[i] / A[j])) {
                    dp[A[i]] = (dp[A[i]] + dp[A[j]] * dp[A[i] / A[j]]) % M;
                }
            }
        }
        for (auto a : dp) res = (res + a.second) % M;
        return res;
    }
};