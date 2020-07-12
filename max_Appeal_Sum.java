
public class max_Appeal_Sum {
	public static void main(String[] args) {
		int[][] infos = {{1,3,1},{1,6,1,1,1,1,7},{6,2,7,4,4,1,6}};
		for(int[] info: infos) {
			int[] ans = maxAppealSum(info);
			System.out.println(ans[0]+" "+ans[1]);
		}
	}
	
	public static int[] maxAppealSum(int[] nums) {
		int[] res = {0,0};
		int TMax = 0;
		int left = 0;
		int right = nums.length-1;
		while(left<=right) {
			int total = nums[left] + nums[right] + Math.abs(left-right);
			if(total>TMax) {
				TMax = total;
				res[0] = left;
				res[1] = right;
			}
			else if(nums[left]<nums[right]) {
				left+=1;
			}
			else {
				right-=1;
			}
		}
		return res;
	}
}
