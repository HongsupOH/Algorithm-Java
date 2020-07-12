import java.util.*;

public class KdistinctWord {
	public static void main(String[] args) {
		String str = "awaglknagawunagwkwagl";
		int k = 4;
		System.out.println("k distinct words are: "+Kdistinct(str,k));
	}
	
	public static List<String> Kdistinct(String str, int k){
		ArrayList<String> ans = new ArrayList<>();
		HashSet<Character>cur = new HashSet<>();
		int idx = 0;
		for (int i=0;i<str.length();i++) {
			while (cur.contains(str.charAt(i))) {
				cur.remove(str.charAt(idx));
				idx++;
			}
			cur.add(str.charAt(i));
			if (cur.size()==k) {
				ans.add(str.substring(idx,idx+k));
				cur.remove(str.charAt(idx));
				idx++;
			}
		}
		return ans;
	}
	

}
