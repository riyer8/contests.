import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class perimeter {
	static char[][] ice;
	static boolean[][] shadow;
	static int connect;
	public static int recur(int r, int c) {
		if (r<0 || r>=ice.length || c<0 || c>=ice[r].length|| ice[r][c] == '.') {
			return 0;
		}
		if (shadow[r][c] == true) {
			connect++;
			return 0;
		}
		connect++;
		shadow[r][c] = true;
		return 1+ recur(r+1,c)+recur(r-1,c) + recur(r,c+1) + recur(r,c-1);
	}
	public static class Pair implements Comparable<Pair>{
		int area;
		int perimeter;
		public Pair(int a, int p) {
			area = a;
			perimeter = p;
		}
		public int compareTo(Pair x) {
			if (area != x.area) return x.area-area;
			return x.perimeter-perimeter;
		}
		public String toString(){
			return area + " " + perimeter;
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("perimeter.in"));
		PrintWriter pw = new PrintWriter(new File("perimeter.out"));
		
		int n = sc.nextInt();
		ice = new char[n][n];
		shadow = new boolean[n][n];
		for (int i =0 ; i<n; i++) {
			ice[i] = sc.next().toCharArray();
			Arrays.fill(shadow[i],false);
		}
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		for (int i =0 ; i<n; i++) {
			for (int j = 0; j<n; j++) {
				connect = 0;
				int x = recur(i,j);
				if (x>0) {
					int y = x*4-connect/2*2;
					Pair p = new Pair(x,y);
					pairs.add(p);
				}
			}
		}
		Collections.sort(pairs);
		pw.println(pairs.get(0));
		
		pw.close();
	}
	
}
