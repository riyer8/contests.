import java.io.*;
import java.util.*;
import java.math.*;
import java.awt.*;
import java.lang.*;

//AtCoder:
//ARC094 C: Same Integers  

public class SameInt {
	public int num(int a, int b, int c) {
		if (a<c) {
			return c-a;
		}
		else {
			int count = (a-c)/2;
			c+= (count+1)*2;
			return count+2;
			
		}
	}
	public void run() throws Exception {
		FastScanner sc = new FastScanner();
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int min = Math.min(a, Math.min(b, c));
		a -= min;
		b -= min;
		c-=min;
		//System.out.println(a + " " + b  + " " + c);
		int max = Math.max(a, Math.max(b, c));
		int count =(max-a)/2 + (max-b)/2 + (max-c)/2;
		a += (max-a)/2 * 2;
		b += (max-b)/2 * 2;
		c += (max-c)/2 * 2;
		if (a == b && b == c) {
			System.out.println(count);
			return;
		}
		else if (a == b || b == c || c==a) {
			if (a == b) count+=num(a,b,c);
			else if (a == c) count+=num(a,c,b);
			else count+=num(b,c,a);
		}
		//System.out.println(a + " " + b  + " " + c);
		System.out.println(count);
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
		new SameInt().run();
	}
}
