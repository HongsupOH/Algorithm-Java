import java.util.*;
public class topologySort_exe {
	public static void main(String[] args) {
		int n = 7;
		int[] indegree = new int[n+1];
		HashMap<Integer,List<Integer>>adj_list = new HashMap<>();
		TopologySort g = new TopologySort(n, indegree, adj_list);
		g.addEdge(1, 2);
		g.addEdge(1, 5);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 6);
		g.addEdge(5, 6);
		g.addEdge(6, 7);
		g.topologySort();
	}
}
