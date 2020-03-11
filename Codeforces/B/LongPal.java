import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

//B: Longest Palindrome: Codeforces Round #620 (Div. 2)
//Created an Arraylist of symmetric, separate words on the outside.
//A boolean and string of a symmetric singular word. This is the word in the middle.

public class LongPal {
	public static class Pair{
		String x,y;
		public Pair(String a, String b) {
			x = a;
			y = b;
		}
	}
	public void run() throws Exception {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		String[] arr = new String[n];
		int count = 0;
		for (int i  =0; i<n; i++) {
			arr[i] = sc.next();
		}
		boolean[] pal = new boolean[n];
		Arrays.fill(pal, false);
		for (int i = 0; i<n; i++) {
			String s = arr[i];
			for (int j = i+1; j<n; j++) {
				String t = arr[j];
				boolean rev = true;
				for (int x = 0; x<m; x++) {
					if (s.charAt(x) != t.charAt(m-x-1)) {
						rev = false;
						break;
					}
				}
				if (rev) {
					pairs.add(new Pair(s,t));
					count+=2*m;
					break;
				}
			}
		}
		String reverse = "";
		for (int i  =0; i<n; i++ ) {
			String s = arr[i];
			boolean rev = true;
			for (int j = 0; j<m; j++) {
				if (s.charAt(j) != s.charAt(m-j-1)) {
					rev = false;
					break;
				}
			}
			if (rev) {
				count+=m;
				reverse = s;
				break;
			}
		}
		System.out.println(count);
		String front = "";
		String back = "";
		for (int i = 0; i<pairs.size(); i++) {
			front = front + pairs.get(i).x;
			back = pairs.get(i).y+back;
		}
		System.out.println(front+reverse+back);
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
		new LongPal().run();
	}
}
