import java.util.*;
public class MST {
	
    int V;
    List<List<Integer>> edges;
    HashMap<Integer,Integer> parents;
    
	public MST(int n, List<List<Integer>> edges, HashMap<Integer,Integer>parents) {
		this.V = n;
		this.edges = edges;
		this.parents = parents;
	}
	
	public void addEdge(int u, int v, int w) {
		List<Integer>edge = new ArrayList<>();
		edge.add(u);
		edge.add(v);
		edge.add(w);
		this.edges.add(edge);
	}
	
	public int find(int x) {
		if (x!=this.parents.get(x)) {
			this.parents.put(x, find(this.parents.get(x)));
		}
		return this.parents.get(x); 
	}
	
	public void union(int x, int y) {
		int s = find(x);
		int t = find(y);
		this.parents.put(t,s);
	}
	
	public void MSTalgorithm() {
		
		Collections.sort(edges, new Comparator<List<Integer>>() {
			public int compare(List<Integer> e1, List<Integer>e2) {
				return e1.get(2).compareTo(e2.get(2));
			}
		});
		
		int cost = 0;
		List<Integer>path = new ArrayList<>();
		for(List<Integer>edge:edges) {
			if(find(edge.get(0))!=find(edge.get(1))) {
				union(edge.get(0),edge.get(1));
				cost+=edge.get(2);
				if (!path.contains(edge.get(0))) {
					path.add(edge.get(0));
				}
				if (!path.contains(edge.get(1))) {
					path.add(edge.get(1));
				}
			}
		}
		System.out.println("Min Cost is: "+ cost);
		System.out.println("Path is: "+path);
	}
	
}
