#  https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3711/

class Solution:
    def numSubmatrixSumTarget(self, matrix: List[List[int]], target: int) -> int:
        rows, cols = len(matrix) + 1, len(matrix[0]) + 1
        preSum = [[0] * cols for _ in range(rows)]
        for i in range(1, rows):
            for j in range(1, cols):
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1]
        
        count = 0
        for top in range(rows):
            for down in range(top + 1, rows):
                c = collections.Counter({0 : 1})
                for k in range(1, cols):
                    s = preSum[down][k] - preSum[top][k]
                    count += c[s - target]
                    c[s] += 1
        return count
