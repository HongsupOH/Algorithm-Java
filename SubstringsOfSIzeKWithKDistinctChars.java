import java.util.*;
public class SubstringsOfSIzeKWithKDistinctChars {
	public static void main(String[] args) {
		String sentence = "awaglknagawunagwkwagl";
		int k = 4;
		System.out.println("Subsets are "+GetSubstrs(sentence,k));
	}
	
	public static List<String> GetSubstrs(String sentence, int k){
		List<String>ans = new ArrayList<>();
		HashSet<Character>cur = new HashSet<>();
		int curidx = 0;
		for (int i=0;i<sentence.length();i++) {
			while(cur.contains(sentence.charAt(i))) {
				cur.remove(sentence.charAt(curidx));
				curidx++;
			}
			cur.add(sentence.charAt(i));
			if(cur.size()==k) {
				ans.add(sentence.substring(curidx,curidx+k));
				cur.remove(sentence.charAt(curidx));
				curidx++;
			}
		}
		return ans;
	}

}
