import java.util.*;

public class Reconstruct_Itinerary {
	public static void main(String[] args) {
		String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		System.out.println(findItinerary(tickets));
	}
	
	public static List<String>findItinerary(String[][] tickets){
		HashMap<String,PriorityQueue<String>> cache = new HashMap<>();
		for(String[] ticket:tickets) {
			if (!cache.containsKey(ticket[0])) {
				PriorityQueue<String> pq = new PriorityQueue<>();
				cache.put(ticket[0],pq);
				cache.get(ticket[0]).add(ticket[1]);
			}
			else {
				cache.get(ticket[0]).add(ticket[1]);
			}
		}
		ArrayList<String>res = new ArrayList<>();
		dfs("ICN",cache,res);
		Collections.reverse(res);
		return res;
	}
	
	
	public static void dfs(String from1, HashMap<String, PriorityQueue<String>>cache, ArrayList<String>res) {
		while(!cache.get(from1).isEmpty()) {
			String to1 = cache.get(from1).poll();
			dfs(to1, cache, res);
		}
		res.add(from1);
		
	}
}
