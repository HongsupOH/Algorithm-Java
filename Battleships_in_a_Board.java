
public class Battleships_in_a_Board {
	public static void main(String[] args) {
		char[][] board = {{'X','.','.','X'},
				          {'X','.','.','X'},
				          {'.','X','.','X'}};
		
		System.out.println("The Number of Battleships is: "+countBattleships(board));
	}
	
	public static int countBattleships(char[][] board) {
		int m = board.length;
		int n = board[0].length;
		int cnt = 0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(board[i][j]=='X') {
					cnt+=1;
					explore(i,j,board);
				}
			}
		}
		return cnt;
	}
	
	public static void explore(int i, int j, char[][] board) {
		int m = board.length;
		int n = board[0].length;
		board[i][j]='.';
		int[] dy = {-1,1,0,0};
		int[] dx = {0,0,-1,1};
		for(int k=0;k<dy.length;k++) {
			int y2 = i+dy[k];
			int x2 = j+dx[k];
			if(0<=y2&&y2<m&&0<=x2&&x2<n&& board[y2][x2]=='X') {
				explore(y2,x2,board);
			}
		}
	}

}
