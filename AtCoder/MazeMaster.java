import java.io.*;
import java.util.*;
import java.math.*;
import java.awt.*;
import java.lang.*;

//AtCoder
//ABC151 D: Maze Master

public class MazeMaster {
	char[][] maze;
	int[][] shadow;
	public void recur(int r, int c, int steps) {
		if (r<0 ||c<0 ||r>=maze.length || c>=maze[0].length) return;
		if (maze[r][c] == '#') {
			return;
		}
		if (shadow[r][c]<= steps) return;
		
		shadow[r][c] = steps;
		recur(r+1, c, steps+1);
		recur(r-1, c, steps+1);
		recur(r, c+1, steps+1);
		recur(r, c-1, steps+1);
	}
	public void run() throws Exception {
		FastScanner sc = new FastScanner();
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		maze = new char[r][c];
		shadow = new int[r][c];
		for (int i = 0; i<r; i++) {
			maze[i] = sc.next().toCharArray();
			Arrays.fill(shadow[i], Integer.MAX_VALUE);
		}
		int steps = 0;
		for (int i = 0; i<r; i++) {
			for (int j = 0;j<c; j++) {
				recur(i,j,0);
				for (int x = 0; x<r; x++) {
					for (int y = 0; y<c; y++) {
						if (shadow[x][y] == Integer.MAX_VALUE) {
							continue;
						}
						steps = Math.max(steps, shadow[x][y]);
					}
				}
				for (int x = 0; x<r; x++) {
				//	System.out.println(Arrays.toString(shadow[x]));
					Arrays.fill(shadow[x], Integer.MAX_VALUE);
				}
			}
		}
		System.out.println(steps);
	}
	static class FastScanner {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

	}
	public static void main(String[] args) throws Exception {
		new MazeMaster().run();
	}
}
