import java.util.*;
public class reverseVowel {
	public static void main(String[] args) {
		String sentence = "bacedifoguh";
		System.out.println(sentence);
		System.out.println(revVowels(sentence));
	}
	public static String revVowels(String sentence) {
		String vowels = "aeiou";
		List<String> arr = new ArrayList<>();
		Stack<String>stack = new Stack<>();
		for(int i=0;i<sentence.length();i++) {
			Character ele = sentence.charAt(i);
			String cv = Character.toString(ele);
			if (!vowels.contains(cv)) {
				arr.add(Character.toString(sentence.charAt(i)));
			}
			else {
				arr.add("0");
				stack.add(cv);
			}		
		}
		for (int i=0;i<arr.size();i++) {
			if(arr.get(i).equals("0")) {
				arr.set(i, stack.pop());
			}
		}
		String ans = "";
		for (int i=0;i<arr.size();i++) {
			ans+= arr.get(i);
		}
		return ans;
	}

}
