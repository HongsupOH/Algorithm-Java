import java.util.*;

public class MeetingRoom {

	public static void main(String[] args) {
		int[][] rooms = {{0, 30},{5, 10},{15, 20}};
		System.out.println("Minimum number of rooms is: "+meetingRoom(rooms));

	}
	
	public static int meetingRoom(int[][] rooms) {
		Arrays.sort(rooms, (a,b)->(a[1]-b[1]));
		PriorityQueue<Integer>pq = new PriorityQueue<>();
		for(int[] room:rooms) {
			if(!pq.isEmpty() && pq.peek()<=room[0]) {
				pq.poll();
			}
			pq.add(room[1]);
		}
		return pq.size();
	}
}
