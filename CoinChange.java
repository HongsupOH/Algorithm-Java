
public class CoinChange {
	public void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 11;
		System.out.println("Min number of coins is: "+ coin_change(coins,amount));
	}
	public int coin_change(int[] coins, int amount) {
		int n = coins.length;
		int[][] dp = new int[n+1][amount+1];
		for(int i=1;i<amount+1;i++) {
			dp[0][i] = (int)Double.POSITIVE_INFINITY;
		}
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<amount+1;j++) {
				if(j-coins[i-1]>=0) {
					dp[i][j] = Math.min(dp[i][j-coins[i-1]]+1, dp[i-1][j]);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		if (dp[n][amount]==(int)Double.POSITIVE_INFINITY) {
			return -1;
		}
		return dp[n][amount];
	}
}
