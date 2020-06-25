import java.io.*;
import java.util.*;
import java.math.*;
import java.awt.*;
import java.lang.*;

//C: Good Array: Codeforces Round #521 (Div. 3)

public class GoodArr{
	public void run() throws Exception {
		FastScanner sc = new FastScanner();
		
		int n = sc.nextInt();
		long[] arr = new long[n];
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		long sum = 0;
		for (int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
			if (map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i])+1);
			else map.put(arr[i], 1);
			sum+=arr[i];
		}
		ArrayList<Integer> val = new ArrayList<Integer>();
		for (int i = 0; i<n; i++) {
			long tot = sum-arr[i];
			map.put(arr[i], map.get(arr[i])-1);
		//	System.out.println(tot);
			if (tot%2 == 0 && map.containsKey(tot/2) && map.get(tot/2)>0) val.add(i+1);
			map.put(arr[i], map.get(arr[i])+1);
		}
		System.out.println(val.size());
		for (int i = 0; i<val.size(); i++) {
			System.out.print(val.get(i)+ " ");
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
		new GoodArr().run();
	}
}
