package levenshteinDistance;

import java.util.Arrays;

public class Levenshtein {

	// solve this in space efficient way
	public int minEditDistance(String start, String end) {
		if(start.length() < end.length()) {
			return minEditDistance(end, start);
		}
		int[][] dp = new int[2][end.length()+1];
		for(int j = 0; j < end.length()+1; j++) {
			dp[0][j] = j;			
		}
		System.out.println(Arrays.toString(dp[0]));
		for(int i = 1; i < start.length()+1; i++) {
			dp[1][0] = i;
			for(int j = 1; j < dp[0].length; j++) {
				char ch1 = start.charAt(i-1);
				char ch2 = end.charAt(j-1);
				if(ch1 == ch2) {
					dp[1][j] = dp[0][j-1];
				} else {
					dp[1][j] = 1 + Math.min(dp[0][j-1], Math.min(dp[0][j], dp[1][j-1]));
				}
			}
			for(int j = 0; j < dp[0].length; j++) {
				dp[0][j] = dp[1][j];
			}
			System.out.println(Arrays.toString(dp[0]));
		}
		
		return dp[1][end.length()];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Levenshtein().minEditDistance("Orchestra", ""));
		String longString = "This string is very long.";
	    String other = "This string" + " is " + "very long.";
	    
	    String is = " is ";
	    String other1 = "This string" +" is "+ "very long.";

	    System.out.println(longString == other1); //prints false
	    System.out.println(longString == other); //prints true
	}

}
