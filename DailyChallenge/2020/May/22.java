// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/601/week-4-may-22nd-may-28th/3752/


class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        List<List<String>> res = new ArrayList<>();
        dfs(board, 0, res);
        return res;
    }
    
    private void dfs(char[][] board, int col, List<List<String>> res) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }
        
        for (int row = 0; row < board.length; row++) {
            if (validate(board, row, col)) {
                board[row][col] = 'Q';
                dfs(board, col+1, res);
                board[row][col] = '.';
            }
        }
    }
    
    private boolean validate(char[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'Q' && (
                    i+j == row+col || row+j == col+i || row == i
                )) return false;
            }
        }
        
        return true;
    }
    
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String str = new String(board[i]);
            res.add(str);
        }
        return res;

    }
}
