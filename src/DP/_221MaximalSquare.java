package DP;

public class _221MaximalSquare {
	public int maximalSquare(char[][] matrix) {
//		System.out.println(matrix[0][0]);
		if(matrix.length <= 0) return 0;
		int[][] dp = new int[matrix.length][matrix[0].length];
		int maxret = 0;
		for(int i = 0 ; i < matrix.length ; i++) {
			for(int j = 0 ; j < matrix[0].length ; j++) {
				if(matrix[i][j] == '1') {
					dp[i][j] = 1;
					int maxlen = 0;
					if(i - 1 >= 0 && j - 1 >= 0 && dp[i-1][j-1] != 0 && (maxlen = check(matrix,i,j,dp[i-1][j-1])) > 0) {
						dp[i][j] += maxlen;
					}
				}
				maxret = maxret < dp[i][j] ? dp[i][j] : maxret;
			}
		}
//		System.out.println(maxret);
		
		return maxret*maxret;// maxret;
	}
	public int check(char[][] matrix,int cur_i,int cur_j,int len) {
		if( cur_i - len < 0 || cur_j - len < 0) return 0;
		int max_len_i = 0, max_len_j = 0;
		for(int i = cur_i - 1 ; i >= cur_i - len ; i--) {
			if(matrix[i][cur_j] == '0')
				break;
			max_len_j++;
		}
		for(int j = cur_j - 1 ; j >= cur_j -len ; j--) {
			if(matrix[cur_i][j] == '0')
				break;
			max_len_i++;
		}
		return Math.min(max_len_i, max_len_j);
	}

}
