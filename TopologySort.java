import java.util.*;
public class TopologySort {
	int V;
	int[] indegree;
	HashMap<Integer,List<Integer>> adj_list;
	public TopologySort(int n, int[] indegree, HashMap<Integer,List<Integer>> adj_list) {
		this.V = n;
		this.indegree = indegree;
		this.adj_list = adj_list;
	}
	
	public void addEdge(int u, int v) {
		if (!adj_list.containsKey(u)) {
			List<Integer>tmp = new ArrayList<>();
			tmp.add(v);
			this.adj_list.put(u,tmp);
		}
		else {
			List<Integer>tmp = adj_list.get(u);
			tmp.add(v);
			this.adj_list.put(u,tmp);
		}
		this.indegree[v]+=1;
	}
	
	public boolean topologySort() {
		Queue<Integer>queue = new LinkedList<>();
		List<Integer>res = new ArrayList<>();
		for (int v=1;v<=this.V;v++) {
			if(indegree[v]==0) {
				queue.add(v);
			}
		}
		for (int i=0;i<this.V;i++) {
			if(queue.isEmpty()) {
				System.out.println("Has cycle");
				return false;
			}
			int cur = queue.poll();
			res.add(cur);
			List<Integer>adj = adj_list.get(cur);
			if (adj!=null){
				for (int ele:adj) {
					indegree[ele]-=1;
					if(indegree[ele]==0) {
						queue.add(ele);
					}
				}
			}
		}
		System.out.println(res);
		return true;
	}

}
