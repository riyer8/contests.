import java.io.*;
import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.math.*;

//C: Almost Equal: Codeforces Round #580 (Div. 2)

public class C {
	public void run() throws Exception {
		FastScanner sc = new FastScanner();
		
		int n = sc.nextInt();
		ArrayList<Integer> g1 = new ArrayList<Integer>();
		ArrayList<Integer> g2 = new ArrayList<Integer>();
		int counter = 0;
		for (int i = 0; i<2*n; i++) {
			counter++;
			if (((counter)%4 == 0) || (counter)%4 == 1) g1.add(2*n-i);
			else g2.add(2*n-i);
		}
		Collections.reverse(g1);
		Collections.reverse(g2);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i<g1.size(); i++) {
			arr.add(g1.get(i));
		}
		for (int i = 0; i<g2.size(); i++) {
			arr.add(g2.get(i));
		}
		for (int i = 0; i<n-1; i++) {
			arr.add(g1.get(i));
		}
		int minsum = Integer.MAX_VALUE;
		int maxsum = Integer.MIN_VALUE;
		for (int i = 0; i<arr.size()-1; i++) {
			arr.set(i+1, arr.get(i)+arr.get(i+1));
		}
		arr.add(0,0);
		for (int i = n; i<arr.size(); i++) {
			int sum = arr.get(i)-arr.get(i-n);
			minsum = Math.min(sum, minsum);
			maxsum = Math.max(sum, maxsum);
		}
		if (Math.abs(minsum-maxsum)>1) System.out.println("NO");
		else {
			System.out.println("YES");
			for (int i = 0; i<g1.size(); i++) {
				System.out.print(g1.get(i)+" ");
			}
			for (int i = 0; i<g2.size()-1; i++) {
				System.out.print(g2.get(i)+ " ");
			}
			System.out.print(g2.get(g2.size()-1));
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
		new C().run();
	}
}
