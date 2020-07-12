import java.util.*;
public class MinCostToRepariEdges {
	public static HashMap <Integer,Integer> parent;
	public static void main(String[] args) {
		parent = new HashMap<>();
		int n = 5;
		int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
		int[][] edgesToRepair = {{1, 2, 12}, {3, 4, 30}, {1, 5, 8}};
		System.out.println("Minimum Cost to repair is: " + MinCost(n,edges, edgesToRepair));
	}
	
	public static int find(int x) {
		if (x!=parent.get(x)) {
			parent.put(x, find(parent.get(x)));
		}
		return parent.get(x);
	}
	
	public static void union(int x, int y) {
		int s = find(x);
		int t = find(y);
		parent.put(t,s);
	}
	
	public static boolean isConnected(int x, int y) {
		return find(x)==find(y);
	}
	
	public static int MinCost(int n, int[][] edges, int[][] edgesToRepair) {
		for (int i=1;i<=n;i++) {
			parent.put(i,i);
		}
		
		for (int[] edge: edges) {
			if (!check.contains(edge)) {
				System.out.println(edge[0]+" "+edge[1]);
				union(edge[0],edge[1]);
			}
		}
		System.out.println(parent);
		Arrays.sort(edgesToRepair, (a, b)->(a[2]-b[2]));
		int cost = 0;
		for (int[] edgeToRepair:edgesToRepair) {
			if(!isConnected(edgeToRepair[0],edgeToRepair[1])) {
				union(edgeToRepair[0],edgeToRepair[1]);
				cost += edgeToRepair[2];
			}
		}
		return cost;
	}

}
