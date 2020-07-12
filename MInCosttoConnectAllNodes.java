import java.util.*;

public class MInCosttoConnectAllNodes {
	static HashMap<Integer,Integer> parent;
	public static void main(String[] args) {
		parent = new HashMap<>();
		int n = 6;
		int[][] edges = {{1, 4}, {4, 5}, {2, 3}};
		int[][] newEdges = {{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}};
		System.out.println("Min Cost is:" + minCostToConnectAllNodes(n,edges,newEdges));
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
		parent.put(t, s);
	}
	public static boolean isConnected(int x, int y) {
		return find(x)==find(y);
	}
	public static int minCostToConnectAllNodes(int n, int[][] edges, int[][] newEdges) {
		for (int i=1;i<=n;i++) {
			parent.put(i,i);
		}
		for (int[] edge: edges) {
			union(edge[0],edge[1]);
		}
		Arrays.sort(newEdges, (a,b)->(a[2]-b[2]));
		int cost = 0;
		for (int[] newEdge: newEdges) {
			if (! isConnected(newEdge[0],newEdge[1])) {
				union(newEdge[0],newEdge[1]);
				cost += newEdge[2];
			}
		}
		return cost;
	}

}
