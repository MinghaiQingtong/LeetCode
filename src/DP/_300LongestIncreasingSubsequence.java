package DP;

import java.util.Arrays;

public class _300LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int ret = 0;
		for(int i = 0 ; i < nums.length ; i++) {
			for(int j = 0 ; j < i ; j++) {
				if(nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			ret = Math.max(ret, dp[i]);
		}
		System.out.println(ret);
		
		return 0;
	}
	public int lengthOfLIS2(int[] nums) {
		
		
		return 0;
	}
}
