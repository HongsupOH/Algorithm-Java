
public class LongestCommonSequence {
	public static void main(String[] args) {
		String[] s1s = {"abcde","abc","abc"};
		String[] s2s = {"ace","abc","def"};
		for (int i=0;i<s1s.length;i++) {
			System.out.println("["+s1s[i]+","+s2s[i]+"]'s answer is: " + LCS(s1s[i],s2s[i]));
		}
	}
	public static int LCS(String s1, String s2) {
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		for(int i=1;i<s1.length()+1;i++) {
			for(int j=1;j<s2.length()+1;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}
}
