// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3733/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
      if (head == null) {
        return null;
      }
      
      if (head.next == null) {
        // only one so return quick
        return new TreeNode(head.val);
      }
      
      return recursiveFromMiddle(head, null);
    }
  
    private TreeNode recursiveFromMiddle(ListNode start, ListNode end) {
      
      // Stopping condition
      if (start == end) {
        return null;
      }
      
      // get from middle and push it down
      ListNode med = start;
      ListNode fast = start.next;
      
      // since it is sorted we knew it left of middle is smaller and right is bigger
      TreeNode parentNew = null;
      while (fast != end && fast.next != end) {
        med = med.next;
        fast = fast.next.next;
      }
      
      TreeNode root = new TreeNode(med.val);
      root.left = recursiveFromMiddle(start, med);
      root.right = recursiveFromMiddle(med.next, end);
      
      return root;
    }
}
