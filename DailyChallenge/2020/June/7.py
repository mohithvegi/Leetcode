# https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3770/



class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        length=len(cost)
        if length==0 or length==1:
            return 0
        elif length==2:
            return min(cost[0],cost[1])
        count=[0 for i in range(0,length+1)]
        count[0]=0
        count[1]=0
        for i in  range(2,length+1):
            count[i]=min(count[i-2]+cost[i-2],count[i-1]+cost[i-1])
        return count[length]
