
public class dijkstra {
    int V;
    int[][] graph;
	
	public dijkstra(int vertices, int[][] graph) {
		this.V = vertices;
		this.graph = graph;
	}
	
	public void printSolution(int[] dist) {
		System.out.println("Vertex tDistance from Source");
		for(int i=0;i<this.V;i++) {
			System.out.println(i+" t "+dist[i]);
		}
	}
	
	public int minDistance(int[] dist, boolean[] sptSet) {
		int minVal = (int)Double.POSITIVE_INFINITY;
		int index = 0;
		for (int v=0;v<this.V;v++) {
			if(dist[v]<minVal && sptSet[v]==false) {
				minVal = dist[v];
				index = v;
			}
		}
		return index;
	}
	
	public void Dijkstra(int src) {
		int[] dist = new int[this.V];
		dist[src] = 0;
		boolean[] sptSet = new boolean[this.V];
		for(int i=0;i<this.V;i++) {
			int cur = minDistance(dist,sptSet);
			sptSet[cur] = true;
			for (int j=0;j<this.V;j++) {
				if(this.graph[cur][j]>0 && sptSet[j]==false &&dist[j] > dist[cur] + this.graph[cur][j]) {
					dist[j] = dist[cur] + this.graph[cur][j];
				}
			}
		}
		printSolution(dist);
	}


}
