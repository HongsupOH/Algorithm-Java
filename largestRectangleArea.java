import java.util.*;
public class largestRectangleArea {

	public static void main(String[] args) {
		int[] heights = {2,1,5,6,2,3};
		System.out.println("Maximum Area is: "+LRA(heights));
	}
	
	public static int LRA(int[] heights) {
		if (heights.length==0) {
			return 0;
		}
		Stack<Integer>stack = new Stack<>();
		stack.add(-1);
		int maxArea = 0;
		for (int i=0;i<heights.length;i++) {
			while(stack.peek()!=-1 && heights[stack.peek()]>=heights[i]) {
				maxArea = Math.max(maxArea, heights[stack.pop()]*(i-stack.peek()-1));
			}
			stack.add(i);
		}
		while(stack.peek()!=-1) {
			maxArea = Math.max(maxArea, heights[stack.pop()]*(heights.length-stack.peek()-1));
		}
		return maxArea;
	}

}
