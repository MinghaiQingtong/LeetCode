package DP;

import java.util.ArrayList;
import java.util.List;

public class _95UniqueBinarySearchTrees2 {
	
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	
	public void travel(TreeNode r) {
		
	}
	
	public static List<TreeNode> generateTrees(int n){
		List<ArrayList<TreeNode>> lists = new ArrayList<ArrayList<TreeNode>>();
//		if(n == 0) return null;
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		list.add(null);
		lists.add(list);
		list.clear();
		list.add(new TreeNode(0));
		if(n == 0) return lists.get(0);
		if(n == 1) return lists.get(1);
		
		for(int i = 2 ; i <= n ; ++i) {
			list.clear();
			for(int j = 0 ; j < i ; ++j) {
				TreeNode t = new TreeNode(0);
				t.left = lists.get(j).get(j);
			}
		}
		
//		System.out.println(list.get(0).val);
		
		
		
		return list;
	}
	
	public static void main(String[] args) {
		generateTrees(1);
	}
	
}
