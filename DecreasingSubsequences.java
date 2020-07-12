import java.util.*;

public class DecreasingSubsequences {

	public static void main(String[] args) {
		int[] nums = {2, 9, 12, 13, 4, 7, 6, 5, 10};
		System.out.println("Subarrays are: "+DecreaingSub(nums));
	}
	
	public static List<List<Integer>> DecreaingSub(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		HashSet<Integer>visit = new HashSet<>();
		for (int i=0;i<nums.length;i++) {
			if (!visit.contains(i)) {
				ArrayList<Integer> part = new ArrayList<>();
				visit.add(i);
				part.add(nums[i]);
				for(int j=0;j<nums.length;j++) {
					if(part.get(part.size()-1)>nums[j] && !visit.contains(j)) {
						part.add(nums[j]);
						visit.add(j);
					}
				}
				res.add(part);
			}
		}
		return res;
	}

}
