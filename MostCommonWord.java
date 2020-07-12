import java.util.*;
public class MostCommonWord {
	public static void main(String[] args) {
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = {"hit"};
		System.out.println("Most Common word is: " + mostCommonWord(paragraph, banned));
	}
	public static String mostCommonWord(String paragraph, String[] banned) {
		List<String>ban = Arrays.asList(banned);
		String exc = "!?',;.";
		for(int i=0;i<exc.length();i++) {
			String tmp = Character.toString(exc.charAt(i));
			paragraph = paragraph.replace(tmp, " ");
		}
		String para = paragraph.toLowerCase();
		String[] pArr = para.split(" ");
		HashMap<String,Integer> cnt = new HashMap<>();
		
		for (String word:pArr) {
			if(!cnt.containsKey(word) && !word.equals("") && !ban.contains(word)) {
				cnt.put(word,1);
			}
			else if (cnt.containsKey(word) && !word.equals("") && !ban.contains(word)) {
				cnt.put(word, cnt.get(word)+1);
			}
		}
		Set<String>keys = cnt.keySet();
		int best = 0;
		for (String key: keys) {
			best = Math.max(best, cnt.get(key));
		}
		List<String>candi = new ArrayList<>();
		for (String key: keys) {
			if (cnt.get(key)==best) {
				candi.add(key);
			}
		}
		return candi.get(0);
	}
}
