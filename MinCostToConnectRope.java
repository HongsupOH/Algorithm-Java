import java.util.*;

public class MinCostToConnectRope {
	public static void main(String[] args) {
		int[] ropes1 = {8,4,6,12};
		int[] ropes2 = {20,4,8,2};
		int[] ropes3 = {1,2,5,10,35,89};
		int[] ropes4 = {2,2,3,3};
		System.out.println(ropes1 + " answer is: " + MinSum(ropes1));
		System.out.println(ropes2 + " answer is: " + MinSum(ropes2));
		System.out.println(ropes3 + " answer is: " + MinSum(ropes3));
		System.out.println(ropes4 + " answer is: " + MinSum(ropes4));
		
	}
	public static int MinSum(int[] ropes) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i=0;i<ropes.length;i++) {
			pq.add(ropes[i]);
		}
		int total = 0;
		while(pq.size()>=2) {
			int p1 = pq.poll();
			int p2 = pq.poll();
			int tmp = p1+p2;
			pq.add(tmp);
			total+=tmp;
		}
		return total;
	}
}
