import java.util.*;

public class OPTRoute {
	public static void main(String[] args) {
		int maxTravelDist = 10000;
		int[][] forwardRouteList = {{1,3000},{2,5000},{3,7000},{4,10000}};
		int[][] returnRouteList = {{1,2000},{2,3000},{3,4000},{4,5000}};
		System.out.println(Opt_Route(maxTravelDist,forwardRouteList,returnRouteList));
	}
	
	public static List<List<Integer>> Opt_Route(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList){
		Arrays.sort(forwardRouteList, (int[] a, int[] b) -> (a[1] - b[1]));
		Arrays.sort(returnRouteList, (int[] a, int[] b) -> (a[1] - b[1]));
		int l = 0;
		int r = returnRouteList.length - 1;
		int best = (int) Double.POSITIVE_INFINITY;
		HashMap<Integer,List<List<Integer>>> candi = new HashMap<>();
		while(l<forwardRouteList.length && r>=0) {
			int[] f_info = forwardRouteList[l];
			int[] r_info = returnRouteList[r];
			int total = f_info[1] + r_info[1];
			if(total<=maxTravelDist) {
				if(maxTravelDist-total<=best) {
					best = maxTravelDist-total;
				}
				if (!candi.containsKey(maxTravelDist-total)) {
					List<Integer>info = new ArrayList<>();
					info.add(f_info[0]);
					info.add(r_info[0]);
					List<List<Integer>> res = new ArrayList<>();
					res.add(info);
					candi.put(maxTravelDist-total, res);
				}
				else if(candi.containsKey(maxTravelDist-total)) {
					List<Integer>info = new ArrayList<>();
					info.add(f_info[0]);
					info.add(r_info[0]);
					candi.get(maxTravelDist-total).add(info);
				}
				l+=1;
			}
			else {r-=1;}
		}
		int min = (int) Double.POSITIVE_INFINITY;
		for (int key: candi.keySet()) {
			min = Math.min(key, min);
		}
		return candi.get(min);
	}

}
