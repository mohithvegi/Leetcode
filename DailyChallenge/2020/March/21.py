# https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3679/

class Solution(object):
    def reorderedPowerOf2(self, N):
        """
        :type N: int
        :rtype: bool
        """
        c = collections.Counter(str(N))
        return any(c == collections.Counter(str(1 << i)) for i in xrange(32))
