import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class mooyomooyo {
	static int[][] game;
	static int[][] temp;
	static int n;
	static int k;
	public static void shiftDown() {
		int[][] arr =  new int[n][10];
		for (int i = 0; i<10; i++) {
			int cur = n-1;
			for (int j = n-1; j>=0; j--) {
				if (game[j][i] != 0) {
					arr[cur][i] = game[j][i];
					cur--;
				}
			}
		}
		game = arr;
	}
	static boolean[][] smat;
	public static int recur(int a, int r, int c) {
		if (r<0 || r>=n || c<0 || c>=10 || game[r][c] != a || smat[r][c]) return 0;
		smat[r][c] = true;
		temp[r][c] = 0;
		return 1+ recur(a,r-1,c) + recur(a,r+1,c) + recur(a,r,c-1)+ recur(a,r,c+1);
	}
	public static int[][] copyMat(int[][] orig) {
		int[][] res = new int[n][10];
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<10; j++) {
				res[i][j] = orig[i][j];
			}
		}
		return res;
	}
	public static boolean groups(int flag) {
		boolean change = false;
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<10; j++) {
				if (game[i][j] == flag) {
					int count = recur(flag,i,j);
					if (flag == 3) System.out.println(count);
					if (count>=k) {
						game = copyMat(temp);
						change = true;
					}
					else temp = copyMat(game);
				}
			}
		}
		return change;
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("mooyomooyo.in"));
		PrintWriter pw = new PrintWriter(new File("mooyomooyo.out"));
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		game = new int[n][10];
		smat = new boolean[n][10];
		temp = new int[n][10];
		for (int i = 0; i<n; i++) {
			String s = sc.next();
			for (int j = 0; j<10; j++) {
				game[i][j] = Integer.parseInt(s.substring(j, j+1));
				temp[i][j] = Integer.parseInt(s.substring(j, j+1));
				smat[i][j] = false;
			}
		}
		while(true) {
			boolean ok = false;
			for (int i = 1; i<=9; i++) {
				ok |= groups(i);
			}
			shiftDown();
			for (int i = 0; i<n; i++) {
				for (int j = 0; j<10; j++) {
					smat[i][j] = false;
				}
			}
			if (!ok) break;
		}
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<10; j++) {
				System.out.print(game[i][j]);
				pw.print(game[i][j]);
			}
			System.out.println();
			pw.println();
		}
		
		pw.close();
	}
	
}
//2018 December Silver #3
