# https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/601/week-4-may-22nd-may-28th/3758/

class Solution(object):
    def maximumUniqueSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        lookup = {}
        prefix = [0]*(len(nums)+1)
        result, left = 0, 0
        for right, num in enumerate(nums):
            prefix[right+1] = prefix[right]+num
            if num in lookup:
                left = max(left, lookup[num]+1)
            lookup[num] = right
            result = max(result, prefix[right+1]-prefix[left])
        return result
