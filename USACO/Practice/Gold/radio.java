import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class radio {
	//a dp problem
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("radio.in"));
		PrintWriter pw = new PrintWriter(new File("radio.out"));

		int n = sc.nextInt();
		int m = sc.nextInt();
		int fx = sc.nextInt(); //farmer coordinates
		int fy = sc.nextInt();
		int bx = sc.nextInt();//bessie coordinates
		int by = sc.nextInt();
		String n1 = sc.next();
		String m1 = sc.next();

		int[][] dp = new int[n + 1][m + 1];

		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		} //initalizing dp matrix

		dp[0][0] = 0;
		int[][] farm = new int[n + 1][2];
		int[][] bess = new int[m + 1][2];

		farm[0][0] = fx;
		farm[0][1] = fy;
		bess[0][0] = bx;
		bess[0][1] = by;

		for (int i = 1; i <= n; i++) {
			if (n1.charAt(i - 1) == 'N') {
				farm[i][1] = farm[i - 1][1] + 1;
				farm[i][0] = farm[i - 1][0];
			} else if (n1.charAt(i - 1) == 'W') {
				farm[i][0] = farm[i - 1][0] - 1;
				farm[i][1] = farm[i - 1][1];
			} else if (n1.charAt(i - 1) == 'E') {
				farm[i][0] = farm[i - 1][0] + 1;
				farm[i][1] = farm[i - 1][1];
			} else {
				farm[i][1] = farm[i - 1][1] - 1;
				farm[i][0] = farm[i - 1][0];
			}
		}

		for (int i = 1; i <= m; i++) {
			if (m1.charAt(i - 1) == 'N') {
				bess[i][1] = bess[i - 1][1] + 1;
				bess[i][0] = bess[i - 1][0];
			} else if (m1.charAt(i - 1) == 'W') {
				bess[i][0] = bess[i - 1][0] - 1;
				bess[i][1] = bess[i - 1][1];
			} else if (m1.charAt(i - 1) == 'E') {
				bess[i][0] = bess[i - 1][0] + 1;
				bess[i][1] = bess[i - 1][1];
			} else {
				bess[i][1] = bess[i - 1][1] - 1;
				bess[i][0] = bess[i - 1][0];
			}
		}


		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < m + 1; j++) {
				if (i == 0 && j == 0)
					continue;
				int dis = (farm[i][0] - bess[j][0]) * (farm[i][0] - bess[j][0])
						+ (farm[i][1] - bess[j][1]) * (farm[i][1] - bess[j][1]);
				if (i >= 1)
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
				if (j >= 1)
					dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
				if (i >= 1 && j >= 1)
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
				dp[i][j] += dis;
			}

		}
		pw.print(dp[n][m]);
		pw.close();
	}

}
