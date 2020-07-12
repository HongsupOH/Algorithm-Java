import java.util.*;

public class MST_exe {

	public static void main(String[] args) {
		int n = 7;
		HashMap<Integer,Integer>parents = new HashMap<>();
		for(int i=1;i<=n;i++) {
			parents.put(i,i);
		}
		List<List<Integer>>edges = new ArrayList<>();
		MST g = new MST(n,edges,parents);
		g.addEdge(1, 2, 4);
		g.addEdge(1, 3, 2);
		g.addEdge(1, 4, 3);
		g.addEdge(2, 6, 3);
		g.addEdge(2, 7, 5);
		g.addEdge(3, 5, 1);
		g.addEdge(4, 6, 4);
		g.addEdge(5, 6, 2);
		g.addEdge(6, 7, 5);
		
		g.MSTalgorithm();
		
	}

}
