// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/600/week-3-may-15th-may-21st/3745/

class Solution {
public:
    int minCameraCover(TreeNode* root) {
        int result = 0;
        if (dfs(root, &result) == UNCOVERED) {
            ++result;
        }
        return result;
    }

private:
    int dfs(TreeNode* root, int *result) {
        int left = root->left ? dfs(root->left, result) : COVERED;
        int right = root->right ? dfs(root->right, result) : COVERED;
        if (left == UNCOVERED || right == UNCOVERED) {
            ++(*result);
            return CAMERA;
        }
        if (left == CAMERA || right == CAMERA) {
            return COVERED;
        }
        return UNCOVERED;
    }
    
    enum NODE {
        UNCOVERED, COVERED, CAMERA
    };
};
