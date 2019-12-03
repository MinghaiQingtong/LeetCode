package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _140WordBreak2 {

	public static List<String> wordBreak(String s,List<String> wordDict){
		List<String> ret = new LinkedList<>();
		boolean[] dp = new boolean[s.length()];
		Arrays.fill(dp, true);
		dfs(s,0,wordDict,ret,"",dp);
		for(Iterator it = ret.iterator() ; it.hasNext() ; ) {
			System.out.println(it.next());//it.next();
		}
		return ret;
	}
	
	public static String dfs(String s,int pos,List<String> wordDict,
			List<String> ret,String s_ret,boolean[] dp) {
		if(wordDict.size() == 0) return null;
		if(pos >= s.length()) {
			ret.add(s_ret);
			return s_ret;
		}
		if(!dp[pos]) return null;
		String c;
		for(int i = pos + 1 ; i <= s.length() ; ++i) {
			String c_sub = s.substring(pos, i);
			if(wordDict.contains(c_sub)) {
				c_sub = s_ret == "" ? dfs(s,i,wordDict,ret,c_sub,dp) : dfs(s,i,wordDict,ret,s_ret+" "+c_sub,dp);
				if(c_sub == null) {
					dp[i] = false;
				}
			}
		}
		
		
		return null;
	}
	
	public static void main(String[] args) {
//		List<String> ret = new LinkedList<>();
		String s = "pineapplepenapple";
		String[] str = {"apple", "pen", "applepen", "pine", "pineapple"};
		List<String> dic = new ArrayList<>();
		for(int i = 0 ; i < str.length ; ++i)
			dic.add(str[i]);
		wordBreak(s, dic);
	}
	
}
