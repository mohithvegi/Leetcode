https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3715/

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; --i) {
            List<Integer> cur = triangle.get(i);
            List<Integer> next = triangle.get(i+1);
            for (int j = 0; j < i + 1; ++j) {
                cur.set(j, Math.min(next.get(j), next.get(j+1)) + cur.get(j));   
            }
        }
        return triangle == null ? 0 : triangle.get(0).get(0);
    }
}
