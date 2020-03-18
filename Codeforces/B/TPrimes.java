import java.io.*;
import java.util.*;
import java.math.*;
import java.awt.*;
import java.lang.*;

//B: T-primes: Codeforces Round #142 (Div. 2)

public class TPrimes{
	public void run() throws Exception {
		FastScanner sc = new FastScanner();
		
		int[] num = new int[1000002];
		Arrays.fill(num, 0);
		for (int i = 2; i<num.length+2; i++) {
			int val = i;
			if (num[i-2] == 0) {
				num[i-2] = -1;
				while (i<=1000002-val) {
					val+=i;
					num[val-2] = 1;
				}
			}
		}
		int n =sc.nextInt();
		for (int i = 0; i<n; i++) {
			long an = sc.nextLong();
			if (an == 1) {
				System.out.println("NO");
			}
			else if ((double)Math.sqrt(an) == Math.floor(Math.sqrt(an))) {
				if (num[(int)Math.sqrt(an)-2] == -1) System.out.println("YES");
				else System.out.println("NO");
			}
			else System.out.println("NO");
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
	public static void main(String[] args) throws Exception {
		new TPrimes().run();
	}
}