
public class MovieOnFlight {
	public static void main(String[] args) {
		int[] movie_duration = {90, 85, 75, 60, 120, 150, 125};
		int d = 250;
		int[] ans = MovieFlight(movie_duration, d);
		System.out.println("Answer is: "+ "["+ans[0]+","+ans[1]+"]");
	}
	
	public static int[] MovieFlight(int[] movie_duration, int d) {
		int[] res = new int[2];
		d-=30;
		int l = 0;
		int r = movie_duration.length -1;
		int diff = (int) Double.POSITIVE_INFINITY;
		while(l<=r) {
			int total = movie_duration[l] + movie_duration[r];
			if(total==d) {
				res[0] = movie_duration[l];
				res[1] = movie_duration[r];
				return res;
			}
			else if(total<d) {
				if(d-total<=diff) {
					diff = d-total;
					res[0] = movie_duration[l];
					res[1] = movie_duration[r];
				}
				l+=1;
			}
			else {
				r-=1;
			}
		}
		return res;
	}
	
}
