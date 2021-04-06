// https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3661/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        List<Integer> cnt = new ArrayList<>();
        getLevelSum(root, 0, res, cnt);

        for(int i = 0; i < res.size(); i++){
            res.set(i, res.get(i)/cnt.get(i));
        }

        return res;
    }

    private void getLevelSum(TreeNode node, int level, List<Double> res, List<Integer> cnt){
        if(node == null){ return; }
        if(res.size() <= level){
            res.add(node.val * 1.0);
            cnt.add(1);
        }else{
            res.set(level, res.get(level) + node.val);
            cnt.set(level, cnt.get(level) + 1);
        }
        getLevelSum(node.left, level+1, res, cnt);
        getLevelSum(node.right, level+1, res, cnt);
    }
}