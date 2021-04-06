//https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3677/

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        set.add(0);
        stack.add(0);
        while (!stack.isEmpty()) {
            int keyPopped = stack.pop();
            List<Integer> keys = rooms.get(keyPopped);
            for (Integer key : keys) {
                if (!set.contains(key)) {
                    stack.push(key);
                    set.add(key);
                }
            }
        }
        return set.size() == rooms.size();
    }
}