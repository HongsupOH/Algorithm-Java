
public class cutWood {
	public static void main(String[] args) {
		int[] wood = {5,9,7};
		int k = 4;
		System.out.println(WoodCut(wood,k));
	}
	public static int WoodCut(int[] wood, int k) {
		if(wood.length==0 || k==0) {
			return 0;
		}
		int lo = 1;
		int hi = 0;
		for (int w:wood) {
			hi = Math.max(hi, w);
		}
		if (!isValid(wood,lo,k)) {
			return 0;
		}
		int res = 0;
		while(lo<=hi) {
			int mid = (lo+hi)/2;
			boolean valid = isValid(wood,mid,k);
			if(valid) {
				lo = mid+1;
				res = mid;
			}
			else {
				hi = mid;
			}
		}
		return res;
	}
	
	public static boolean isValid(int[] wood, int cutLen, int k) {
		int cnt = 0;
		for (int w: wood) {
			cnt+= w/cutLen;
		}
		return cnt>=k;
	}
}
