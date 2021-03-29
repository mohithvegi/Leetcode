// https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/592/week-5-march-29th-march-31st/3689/
//
//

/**
 *  * Definition for a binary tree node.
 *   * struct TreeNode {
 *    *     int val;
 *     *     TreeNode *left;
 *      *     TreeNode *right;
 *       *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *        *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *         *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 *          * };
 *           */
class Solution {
	public:
		    vector<int> flipMatchVoyage(TreeNode* root, vector<int>& voyage) {
			            vector<int> res;
				            int i = 0;
					            return helper(root, voyage, i, res) ? res : vector<int>{-1};
						        }
		        bool helper(TreeNode* node, vector<int>& voyage, int& i, vector<int>& res) {
				        if (!node) return true;
					        if (node->val != voyage[i++]) return false;
						        if (node->left && node->left->val != voyage[i]) {
								            res.push_back(node->val);
									                return helper(node->right, voyage, i, res) && helper(node->left, voyage, i, res);
											        }
							        return helper(node->left, voyage, i, res) && helper(node->right, voyage, i, res);
								    }
};
