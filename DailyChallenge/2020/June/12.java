// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3776/

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int N = stations.length;
        int[][] dp = new int[N+1][N+1];
        for(int i =0 ;i <= N ;i++)
            dp[i][0] = startFuel;
        for(int  i = 1 ; i <= N ;i++)
            for(int j = 1 ; j <=N; j++){
                dp[i][j] = dp[i-1][j];
                if(dp[i-1][j-1] >= stations[i-1][0])
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1] + stations[i-1][1]);
            }   
        for(int j = 0 ; j <= N ;j++)
            if(dp[N][j] >= target)
                return j;
        return -1;
    }
}
