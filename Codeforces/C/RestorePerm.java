import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

//C: Restoring Permutation: Codeforces Round #623 (Div. 2, based on VK Cup 2019-2020 - Elimination Round, Engine)
//The lexicographically order would be the minimum on the left
//Array of numbers that are not in b[i] = not[i]
//Iterate through the array and take the smallest number larger than the element to the left

public class RestorePerm {
	public void run() throws Exception {
		FastScanner sc = new FastScanner();
		
		int test = sc.nextInt();
		outer:
		for (int j = 0; j<test; j++) {
			int n = sc.nextInt();
			int[] b = new int[n];
			int[] a = new int[2*n];
			int[] not = new int[n];
			for (int i = 0; i<n; i++) {
				b[i] = sc.nextInt();
				a[2*i] = b[i];
			}
			Arrays.sort(b);
			int point = 0;
			int points = 0;
			for (int i = 1; i<=2*n; i++) {
				if (point==n) {
					not[points] = i;
					points++;
				}
				else if (b[point] == i) {
					point++;
				}
				else {
					not[points] = i;
					points++;
				}
			}
			if (not[0] == 1 || b[n-1] == 2*n) {
				System.out.println(-1);
				continue;
			}
			boolean[] ok = new boolean[n];
			Arrays.fill(ok, true);
		
			for (int i = 0; i<n; i++) {
				for (int x = 0; x<n+1; x++) {
					if (x == n) {
						System.out.println(-1);
						continue outer;
					}
					else if (a[2*i]>not[x]) {
						;
					}
					else if (!ok[x]) ;
					else {
						a[2*i+1] = not[x];
						ok[x] = false;
						break;
					}
				}
			}
			for (int i = 0; i<n; i++) {
				System.out.print(a[2*i] + " " + a[2*i+1] + " ");
			}
			System.out.println();
		}
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
	public static void main (String[] args) throws Exception {
		new RestorePerm().run();
	}
}
