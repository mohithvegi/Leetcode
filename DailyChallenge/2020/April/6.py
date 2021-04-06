# https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3698/


class Solution(object):
    def minOperations(self, n):
        """
        :type n: int
        :rtype: int
        """
        return (n//2)*((n+1)//2)
