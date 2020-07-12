
public class CourseSchedule2 {
	public static void main(String[] args) {
		int numCourses = 4;
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		Topological_Sort tp = new Topological_Sort(numCourses);
		for (int[] pre:prerequisites) {
			tp.addEdge(pre[0], pre[1]);
		}
		System.out.println("Sequence is: "+tp.topo());
	}
}
