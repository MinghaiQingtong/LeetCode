package DP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class test {
	
	public static Integer[] a = new Integer[10];
	public static void F() {
		Integer b = test.a[0];
		b = 2;
	}
	public static void main(String[] args) {
		_300LongestIncreasingSubsequence s300 = new _300LongestIncreasingSubsequence();
		int[] nums = {10,9,2,5,3,7,101,18};
		s300.lengthOfLIS(nums);
		s300.lengthOfLIS2(nums);
//		_279PerfectSquares s279 = new _279PerfectSquares();
//		System.out.println(s279.numSquares(12));
		
//		_264UglyNumber2 s264 = new _264UglyNumber2();
//		s264.nthUglyNumber(1000);
//		
//		_221MaximalSquare solution = new _221MaximalSquare();
//		char[][] matrix = /*{{'0','0','0','1'},
//							{'1','1','0','1'},
//							{'1','1','1','1'},
//							{'0','1','1','1'},
//							{'0','1','1','1'}};*/
//							{{'0','0','1','0','0'},
//							{'1','0','1','1','1'},
//							{'1','1','1','1','1'},
//							{'1','0','1','0','1'}};
//		solution.maximalSquare(matrix);
		
		
	}
	
	
}
/*
[["1","0","1","0","0"],
 ["1","0","1","1","1"],
 ["1","1","1","1","1"],
 ["1","0","0","1","0"]]
		 
[["0","0","0","1"],
 ["1","1","0","1"],
 ["1","1","1","1"],
 ["0","1","1","1"],
 ["0","1","1","1"]]

*/