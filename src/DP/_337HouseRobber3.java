package DP;

public class _337HouseRobber3 {
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
		TreeNode(){val = 0;}
	}
	public static TreeNode ConstructDPTree(TreeNode root,TreeNode DPTree) {
		if(DPTree == null) {
			DPTree = new TreeNode(0);
		}
		if(root != null) {
			DPTree.left = ConstructDPTree(root.left,DPTree.left);
			DPTree.right = ConstructDPTree(root.right,DPTree.right);
			if(DPTree.left.val == 0 && DPTree.right.val == 0) {
				DPTree.val = root.val;
			}else if(DPTree.left.val == 0) {
				DPTree.val = Math.max(root.val+DPTree.right.left.val+DPTree.right.right.val, DPTree.right.val);
			}else if(DPTree.right.val == 0) {
				DPTree.val = Math.max(root.val+DPTree.left.left.val+DPTree.left.right.val, DPTree.left.val);
			}else {
				DPTree.val = Math.max(DPTree.left.val+DPTree.right.val, 
						root.val+DPTree.left.left.val+DPTree.left.right.val+DPTree.right.left.val+DPTree.right.right.val);
			}
		}
		return DPTree;
	}
	
	public static int rob(TreeNode root) {
		TreeNode dp = new TreeNode(0);
		ConstructDPTree(root,dp);
		return dp.val;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(1);
//		System.out.println(root.left.left.val);
		System.out.println(rob(root));
		
	}
}
