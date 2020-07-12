import java.util.*;
public class FindPairWIthGivenSum {
	public static void main(String[] args) {
		int target = 90;
		int[][] nums = {{1, 10, 25, 35, 60},{20,50,40,25,30,10}};
		for (int[] num: nums) {
			int[] ans = FindPair(num,target);
			System.out.println("Answer is:"+ "["+ans[0]+","+ans[1]+"]");
		}
	}
	
	public static int[] FindPair(int[] nums, int target) {
		target -= 30;
		int[] ans = new int[2];
		HashMap<Integer,Integer>check = new HashMap<>();
		for (int i=0;i<nums.length;i++) {
			check.put(nums[i],i);
		}
		for (int i=0;i<nums.length;i++) {
			int s = target - nums[i];
			if (check.containsKey(s) && check.get(s)!=i) {
				ans[0] = Math.min(i,check.get(s));
				ans[1] = Math.max(i,check.get(s));
			}
		}
		return ans;
	}

}
