// https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3701/

class Solution {
public:
    unordered_map<char, string> M = {
        {'0', ""},
        {'1', ""},
        {'2', "abc"},
        {'3', "def"},
        {'4', "ghi"},
        {'5', "jkl"},
        {'6', "mno"},
        {'7', "pqrs"},
        {'8', "tuv"},
        {'9', "wxyz"}
    };

    string digits;
    int n;
    string s;
    vector<string> v;

    void next(int i) {
        if (i == n) return v.push_back(s);
        for (auto c : M[digits[i]]) { s[i] = c; next(i+1); }
    }

    vector<string> letterCombinations(string digits) {
        n = digits.size();
        this->digits = digits;
        s.resize(n);

        if (n > 0) next(0);
        return v;
    }
};
