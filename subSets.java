import java.util.*;
public class subSets {
	public static void main(String[] args) {
		
	}
	public static List<List<Integer>> subsets(int[] nums){
		HashMap<Integer, int[]> gr = new HashMap<>();
		for (int i=0;i<nums.length;i++) {
			gr.put(nums[i], Arrays.copyOfRange(int[] nums, i+1, nums.length));
		}
	}
}
