package DP;

import java.util.Arrays;

public class _279PerfectSquares {
	public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, 5);
        dp[0] = 0;
        for(int i = 1 ; i <= n ; i++) {
//        	dp[i] = 1000;
        	for(int j = 1 ; j*j <= i ; j++) {
        		dp[i] = Math.min(dp[i], dp[i-j*j]+1);
        	}
        }
        System.out.println(dp[n]);
			
		return dp[n];
	}
}
