# https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3766/


class Solution(object):
    def maxArea(self, h, w, horizontalCuts, verticalCuts):
        """
        :type h: int
        :type w: int
        :type horizontalCuts: List[int]
        :type verticalCuts: List[int]
        :rtype: int
        """
        def max_len(l, cuts):
            cuts.sort()
            l = max(cuts[0]-0, l-cuts[-1])
            for i in xrange(1, len(cuts)):
                l = max(l, cuts[i]-cuts[i-1])
            return l

        MOD = 10**9+7
        return max_len(h, horizontalCuts) * max_len(w, verticalCuts) % MOD
