import java.util.*;
import java.io.*;
import java.math.*;

//Dice Cup: 1.2

public class DiceCup {
	public class Pair implements Comparable<Pair> {
		int val, times;
		public Pair (int a, int b) {
			val = a;
			times = b;
		}
		public int compareTo(Pair a) {
			if (times == a.times) {
				return val-a.val;
			}
			else return a.times-times;
		}
		public String toString() {
			return val + " " + times;
		}
	}
	public  void run() throws Exception{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 1; i<=n;i++) {
			for (int j = 1; j<=m; j++) {
				int sum = i+j;
				if (map.containsKey(sum)) map.put(sum, map.get(sum)+1);
				else map.put(sum, 1);
			}
		}
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		for (int val: map.keySet()) {
			pairs.add(new Pair(val, map.get(val)));
		}
		Collections.sort(pairs);
	//	System.out.println(pairs);
		int max = pairs.get(0).times;
		for (int i = 0; i<pairs.size(); i++) {
			if (max == pairs.get(i).times) System.out.println(pairs.get(i).val);
		}
	}
	public static void main(String[] args) throws Exception {
		DiceCup x = new DiceCup();
		x.run();
	}
}
