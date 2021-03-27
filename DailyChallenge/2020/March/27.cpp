// https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3686/

class Solution {
public:
    int countSubstrings(string s) 
    {
        int count=0;
        int n=s.size();
        
        for (int i=0; i<s.size(); i++)
        {
            int len=0;
            while (i-len>=0 && i+len<n && s[i-len]==s[i+len])
                len++;
            count+=len;
            
            len=0;
            while (i-len>=0 && i+1+len<n && s[i-len]==s[i+1+len])
                len++;
            count+=len;
        }
        return count;

    }
};
