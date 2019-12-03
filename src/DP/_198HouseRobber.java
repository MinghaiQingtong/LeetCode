package DP;

public class _198HouseRobber {
	public static int rob(int[] nums) {
		int[] dp = new int[nums.length];
		if(nums.length == 1) return nums[0];
		if(nums.length == 2) return Math.max(nums[0], nums[1]);
		if(nums.length == 3) return Math.max(nums[0]+nums[2], nums[1]);
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		dp[2] = Math.max(nums[0]+nums[2], nums[1]);
		for(int i = 3 ; i < nums.length ; i++) {
			dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
		}
		return dp[dp.length-1];
	}
	public static void main(String[] args) {
		int[] nums = {2,7,9,3,1};
		System.out.println(rob(nums));
	}
}
