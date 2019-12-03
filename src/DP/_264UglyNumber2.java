package DP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _264UglyNumber2 {
	public int min3(int a,int b,int c) {
		return a > b ? (b > c ? c : b) : (a > c ? c : a);
	}
	public int nthUglyNumber(int n) {
		int[] u = new int[n];
		u[0] = 1;
		int e_2 = 0 , e_3 = 0 , e_5 = 0;
		for(int i = 1 ; i < n ; i++) {
			int m = min3(u[e_2]*2,u[e_3]*3,u[e_5]*5);
			if(m == u[e_2]*2) e_2++;
			if(m == u[e_3]*3) e_3++;
			if(m == u[e_5]*5) e_5++;
			u[i] = m;
		}
		System.out.println(u[n-1]);
		return u[n-1];
	}
	/*
	 * 
	 * Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
	 */
}
