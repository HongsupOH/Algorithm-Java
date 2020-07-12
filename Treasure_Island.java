import java.util.*;

public class Treasure_Island {
	public static void main(String[] args) {
		String[][] grid = {{"O","O","O","O"},
				           {"D","O","D","O"},
				           {"O","O","O","D"},
				           {"X","D","D","O"}};
		System.out.println("Length of Path is:" + findTreasure(grid));
	}
	
	public static int findTreasure(String[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		Set<int[]> visit = new HashSet<>();
		Queue<List<int[]>>queue = new LinkedList<>();
		int[] origin = {0,0};
		visit.add(origin);
		List<int[]> tmp = new ArrayList<>();
		tmp.add(origin);
		queue.add(tmp);
		while(!queue.isEmpty()) {
			List<int[]> path = queue.poll();
			int[] node = path.get(path.size()-1);
			int y = node[0];
			int x = node[1];
			if(grid[y][x].equals("X")) {
				return path.size();
			}
			int[] dy = {-1,1,0,0};
			int[] dx = {0,0,-1,1};
			for (int i=0;i<dy.length;i++) {
				int y2 = y+dy[i];
				int x2 = x+dx[i];
				int[] coor = {y2,x2};
				if(0<=y2&&y2<m&&0<=x2&&x2<n&& !grid[y2][x2].equals("D") && !visit.contains(coor)) {
					List<int[]> new_path = new ArrayList<>();
					List<int[]> tmp1 = new ArrayList<>();
					tmp1.add(coor);
					new_path.addAll(path);
					new_path.addAll(tmp1);
					queue.add(new_path);
					visit.add(coor);
				}
			}
		}
		return -1;
	}
}
