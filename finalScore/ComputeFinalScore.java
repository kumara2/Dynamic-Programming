package finalScore;
import java.util.*;

public class ComputeFinalScore {
	public int numOfwaysToFinalScore(int target, List<Integer> scores) {
		int[][] dp = new int[scores.size()][target+1];
		for(int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		for(int i = 0; i < dp.length; i++) {
			for(int j = 1; j < dp[0].length; j++) {
				int withoutScore = i - 1 < 0 ? 0 : dp[i-1][j];
				int withScore = (j- scores.get(i) >= 0) ? dp[i][j-scores.get(i)] : 0;
				dp[i][j] = withScore + withoutScore;
			}
		}
		return dp[scores.size()-1][target];
	}
	public static void main(String[] args) {
		List<Integer> scores = new ArrayList<Integer>();
		scores.add(2); scores.add(3);scores.add(7);
		System.out.println(new ComputeFinalScore().numOfwaysToFinalScore(12, scores));
	}
}
