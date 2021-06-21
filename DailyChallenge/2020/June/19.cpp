// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3784/

class Solution {
public:
    int kInversePairs(int n, int k) {
        int mod = (int)pow(10, 9)+7;
        vector< vector<int> > a(k + 1, vector<int>(n+1, 0));
        for (int i = 0; i <= n; i++) {
            a[0][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j-i >= 0) {
                    a[j][i] = (a[j-1][i]+a[j][i-1])%mod;
                    a[j][i] = (a[j][i]-a[j-i][i-1]+mod)%mod;
                }
                else 
                    a[j][i] = (a[j-1][i]+a[j][i-1])%mod;
            }
        }
        return a[k][n];
    }
};
