// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3782/

class Solution {
public:
    int numSubarrayBoundedMax(vector<int>& A, int L, int R) {
        return count(A, R) - count(A, L - 1);
    }
    int count(vector<int>&A,int R) {
        int ret = 0, cnt = 0;
        for (auto &a : A) {
            if (a <= R)ret++;
            else ret = 0;
            cnt += ret;
        }
        return cnt;
    }
};
