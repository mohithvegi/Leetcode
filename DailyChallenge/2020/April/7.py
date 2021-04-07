# https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3699/


class Solution(object):
    def halvesAreAlike(self, s):
        """
        :type s: str
        :rtype: bool
        """
        check=('aeiouAEIOU')
        f_s=0
        b_s=0
        for i in range(len(s)//2):
            if s[i] in check:
                f_s+=1
            if s[-i-1] in check:
                b_s+=1

        return f_s==b_s
