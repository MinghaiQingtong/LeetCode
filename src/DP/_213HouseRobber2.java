package DP;

public class _213HouseRobber2 {
	
	public static int rob1(int[] nums,int start,int end) {
		if(end-start == 0) return 0;
		if(end-start == 1) return nums[start];
		if(end-start == 2) return Math.max(nums[start], nums[start+1]);
		if(end-start == 3) return Math.max(nums[start]+nums[start+2], nums[start+1]);
		int[] dp = new int[nums.length];
		dp[start] = nums[start];
		dp[start+1] = Math.max(nums[start], nums[start+1]);
		dp[start+2] = Math.max(nums[start]+nums[start+2], nums[start+1]);
		
		for(int i = start + 3 ; i < end ; i++) {
			dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
		}
		return dp[end-1];
	}
	public static int rob2(int[] nums) {
		if(nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		if(nums.length == 2) return Math.max(nums[0], nums[1]);
		int n = nums.length-1;
		return Math.max(nums[n]+rob1(nums,1,n-1), rob1(nums,0,n));
	}
	
	
//	public static int rob2(int[] nums) {
//		if(nums.length == 0) return 0;
//		if(nums.length == 1) return nums[0];
//		if(nums.length == 2) return Math.max(nums[0], nums[1]);
//		if(nums.length == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));
//		if(nums.length == 4) return Math.max(nums[0]+nums[2], nums[1]+nums[3]);
//		int[] dp = new int[nums.length];
//		int[] tag = new int[nums.length];
//		dp[0] = nums[0]; tag[0] = 1;
//		if(nums[0] > nums[1]) {
//			dp[1] = nums[0];
//			tag[1] = 1;
//		}else {
//			dp[1] = nums[1];
//			tag[1] = 0;
//		}
//		if(nums[0]+nums[2] > nums[1]) {
//			dp[2] = nums[0]+nums[2];
//			tag[2] = 1;
//		}else {
//			dp[2] = nums[1];
//			tag[2] = 0;
//		}
//		for(int i = 3 ; i < nums.length - 1 ; i++) {
//			if(nums[i]+dp[i-2] > dp[i-1]) {
//				dp[i] = nums[i]+dp[i-2];
//				tag[i] = tag[i-2];
//			}else {
//				dp[i] = dp[i-1];
//				tag[i] = tag[i-1];
//			}
//		}
//		if(tag[nums.length-3] == 1) {
//			dp[nums.length-1] = Math.max(Math.max(dp[nums.length-3], dp[nums.length-3]+nums[nums.length-1]-nums[0]), dp[nums.length-2]);
//		}else {
//			dp[nums.length-1] = Math.max(nums[nums.length-1]+dp[nums.length-1], dp[nums.length-2]);
//		}
//		return dp[nums.length-1];
//	}
	public static void main(String[] args) {
		int[] nums = {0,0};
//		int a = 6789;
//		System.out.println(a^a);
		System.out.println(rob2(nums));
	}
}
