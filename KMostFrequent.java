import java.util.*;

public class KMostFrequent {
	public static void main(String[] args) {
		String[] words = {"i","love","leetcode","i","love"};
		int k = 2;
		System.out.println("Top k frequent words are: "+ KFreWord(words,k));
	}
	public static ArrayList<String> KFreWord(String[] words, int k) {
		HashMap<String,Integer>cnt = new HashMap<>();
		for(String word:words) {
			if(!cnt.containsKey(word)) {
				cnt.put(word, 1);
			}
			else {
				cnt.put(word, cnt.get(word)+1);
			}
		}
		ArrayList<Integer>tmp = new ArrayList<>();
		for(String key:cnt.keySet()) {
			tmp.add(cnt.get(key));
		}
		Collections.sort(tmp,Collections.reverseOrder());
		Queue<String>queue = new LinkedList<>();
		for(int ele:tmp) {
			for(String key:cnt.keySet()) {
				if(cnt.get(key)==ele) {
					queue.add(key);
				}
			}
		}
		int count = 0;
		ArrayList<String>ans = new ArrayList<>();
		while (count<k) {
			ans.add(queue.poll());
			count+=1;
		}
		return ans;
	}
}
