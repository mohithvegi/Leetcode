// https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3657/


class Solution {
    public int distributeCandies(int[] candies) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < candies.length; i++) {
            map.put(candies[i], map.getOrDefault(candies[i], 0) + 1);
        }
        return map.size() < candies.length/2 ? map.size() : candies.length/2;
    }
}