package Tree.MediumQuestions;

/*
Given a Binary Search Tree (BST) and a range l-h(inclusive), count the number of nodes in the BST 
that lie in the given range.
    The values smaller than root go to the left side
    The values greater and equal to the root go to the right side

Example 1:
      10
     /  \
    5    50
   /    /  \
  1    40  100
l = 5, h = 45
Output: 3
Explanation: 5 10 40 are the node in the range.

Example 2:
     5
    /  \
   4    6
  /      \
 3        7
l = 2, h = 8
Output: 5
Explanation: All the nodes are in the given range.
*/

public class QCountBSTNodesInRange {

    int count = 0;
    int getCount(TreeNode root, int l, int h) {
        
        if (root == null)
            return 0;

        getCount(root.left, l, h);
        if (root.val >= l && root.val <= h)
            count++;
        getCount(root.right, l, h);

        return count;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}