// https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3710/


class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().c == ch) {
                stack.peek().freq++;
            } else {
                stack.push(new Pair(ch, 1));
            }
            if (stack.peek().freq == k) {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair peek = stack.pop();
            for (int i = 0; i < peek.freq; i++) {
                sb.append(peek.c);
            }
        }
        return sb.reverse().toString();
    }

    class Pair {
        char c;
        int freq;

        public Pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
}