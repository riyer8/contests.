import java.io.*;
import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.math.*;
 
public class A {
	public class Two {
		int val; int ind;
		public Two(int a, int b) {
			val = a;
			ind = b;
		}
		public String toString() {
			return val + " " + ind;
		}
	}
	public class Pair {
		String name; ArrayList<Two> vals;
		public Pair(String s, ArrayList<Two> arr,int a, int b) {
			name = s;
			vals = arr;
			if (arr.size() == 0) arr.add(new Two(a,b));
			else arr.add(new Two(arr.get(arr.size()-1).val+a,b));
		}
		public String toString() {
			return name + " " + vals;
		}
	}
	public void run() throws Exception {
		FastScanner sc = new FastScanner();
		
		int n = sc.nextInt();
		Map<String, Pair> map = new HashMap<String, Pair>();
		for (int i = 1; i<=n; i++) {
			String a = sc.next();
			int b = sc.nextInt();
			if (map.containsKey(a)) map.put(a, new Pair(a,map.get(a).vals,b,i));
			else map.put(a, new Pair(a,new ArrayList<Two>(),b,i));
		}
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		int max = Integer.MIN_VALUE;
		for (String a: map.keySet()) {
			Pair b = map.get(a);
			if (max<b.vals.get(b.vals.size()-1).val) {
				max = b.vals.get(b.vals.size()-1).val;
				pairs.clear();
				pairs.add(b);
			}
			else if (max == b.vals.get(b.vals.size()-1).val) {
				pairs.add(b);
			}
		}
		if (pairs.size() == 1) System.out.println(pairs.get(pairs.size()-1).name);
		else {
			Pair ans = pairs.get(0);
			int ok = ans.vals.get(ans.vals.size()-1).val;
			int ind = ans.vals.get(ans.vals.size()-1).ind;
			for (int i = 0; i<pairs.size(); i++) {
				Pair a = pairs.get(i);
				int l = 0;
				for (int j = 0; j<a.vals.size(); j++) {
					if (a.vals.get(j).val>=ok) {
						l = a.vals.get(j).ind;
						break;
					}
				}
				if (l<ind) {
					ind = l;
					ans = a;
				}
			}
			System.out.println(ans.name);
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
		new A().run();
	}
	public void shuffleArray(long[] arr) {
        int n = arr.length;
        Random rnd = new Random();
        for(int i=0; i<n; ++i){
            long tmp = arr[i];
            int randomPos = i + rnd.nextInt(n-i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }   
	}
}