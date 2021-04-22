# https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3717/

import collections

try:
    xrange          # Python 2
except NameError:
    xrange = range  # Python 3


class Solution(object):
    def leastBricks(self, wall):
        """
        :type wall: List[List[int]]
        :rtype: int
        """
        widths = collections.defaultdict(int)
        result = len(wall)
        for row in wall:
            width = 0
            for i in xrange(len(row)-1):
                width += row[i]
                widths[width] += 1
                result = min(result, len(wall) - widths[width])
        return result
