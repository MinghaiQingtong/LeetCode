package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _139WordBreak {

	private static class Recorder{
		public static Integer start;
		public static Integer end;
//		public static boolean ret;
		Recorder(int start,int end){Recorder.start = start;Recorder.end = end;}
		
		public boolean equals(Object o) {
			if(this == o) return true;
			if(o == null || getClass() != o.getClass()) return false;
			
			Recorder r = (Recorder) o;
			
			if(this.start == r.start && this.end == r.end) return true;
			
			return false;
		}
		
		public int hashCode() {
			return start != null ? start.hashCode(end) : 0;
		}
	
	}
//	public static Map<Recorder,Boolean> buf = new HashMap<Recorder,Boolean>();
	public static boolean wordBreak(String s,List<String> wordDict) {
		if(wordDict.size() == 0) return false;
		boolean[] dp = new boolean[s.length()];
		Arrays.fill(dp, true);
		return dfs2(s,0,wordDict,dp);
	}
	
	public static boolean dfs2(String s,int pos,List<String> dic,boolean[] dp) {
		if(pos >= s.length()) return true;
		if(!dp[pos]) return false;
		for(int i = pos + 1 ; i <= s.length() ; ++i) {
			String c_s = s.substring(pos, i);
			if(dic.contains(c_s)) {
				boolean ret = dfs2(s,i,dic,dp);
				if(ret) {
					return true;
				}
				dp[i] = false;
			}
		}
		return false;
	}
	
	public static int count = 0;
	public static boolean dfs(String s,int start,int end,Set<String> dic) {//[start,end)
		if(start == end ) {//|| buf.containsKey(new Recorder(start,end))) {
			return true;
		}	
		else if(buf.containsKey(new Recorder(start,end))) {
			count++;
			return buf.get(new Recorder(start,end));
		}
		else{
			for(int i = start + 1 ; i <= end ; ++i) {
				if(dic.contains(s.substring(start, i))) {
					Boolean ret ;
					if(buf.containsKey(new Recorder(start,i))) {
						ret = buf.get(new Recorder(start,i));
						_139WordBreak.count++;
					}else {
						_139WordBreak.count++;
						ret = dfs(s,i,end,dic);
						buf.put(new Recorder(start,i), ret);
					}
					//= dfs(s,i,end,dic);
					
					if(ret) return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] arsg) {
		String s = "aaaa";
		for(int i = 0; i < 1000; ++i) {
			s += "a";
		}
		System.out.println(s.length());
		String[] w = {"a","b"};
		List<String> wordDic = new ArrayList<>();
		for(int i = 0 ; i < w.length ; ++i) {
//			System.out.println(w[i]);
			wordDic.add(w[i]);
		}
		System.out.println(wordBreak(s,wordDic)+" "+_139WordBreak.count);
			
	}
}
