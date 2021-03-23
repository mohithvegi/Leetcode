//https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3668/

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        const int MAX = amount +1;
        vector<int> dp(amount+1, MAX);
        dp[0]=0;

        for(int i=1; i<=amount; i++) {
            for (int j=0; j<coins.size(); j++){
                if (i >= coins[j]) {
                    dp[i] = min( dp[i], dp[i-coins[j]] + 1 );
                }
            }
        }

        return dp[amount]==MAX ? -1 : dp[amount];
    }
};