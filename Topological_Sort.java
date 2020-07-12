import java.util.*;

public class Topological_Sort {
    int n;
    HashMap<Integer,ArrayList<Integer>> adjList;
    int[] inorder;
    
	public Topological_Sort(int numCourse) {
		this.n = numCourse;
		this.adjList = new HashMap<>();
		for (int i=0;i<this.n;i++) {
			ArrayList<Integer>tmp = new ArrayList<>();
			this.adjList.put(i,tmp);
		}
		this.inorder = new int [this.n];
	}
	
	public void addEdge(int i, int j) {
		this.inorder[i]+=1;
		this.adjList.get(j).add(i);
	}
	
	public ArrayList<Integer> topo(){
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer>res = new ArrayList<>();
		for(int i=0;i<this.n;i++) {
			if(this.inorder[i]==0) {
				q.add(i);
			}
		}
		for(int i=0;i<this.n;i++) {
			if (q.isEmpty()) {
				ArrayList<Integer>err = new ArrayList<>();
				return err;
			}
			int cur = q.poll();
			res.add(cur);
			ArrayList<Integer>adj_list = this.adjList.get(cur);
			for (int adj:adj_list) {
				this.inorder[adj]-=1;
				if(this.inorder[adj]==0) {
					q.add(adj);
				}
			}
		}
		return res;
	}

}
