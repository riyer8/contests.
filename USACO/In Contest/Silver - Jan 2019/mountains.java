import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class mountains {
	public static class Pair implements Comparable<Pair> {
		long min;
		long max;
		public Pair(long a, long b) {
			min = a;
			max = b;
		}
		public int compareTo(Pair x) {
			if (min!=x.min) return (int)(min - x.min);
			return (int)(max-x.max);
		}
		public String toString() {
			return min + " " + max;
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("mountains.in"));
		PrintWriter pw = new PrintWriter(new File("mountains.out"));
		
		int n = sc.nextInt();
		
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		for (int i = 0; i<n; i++) {
			long x = sc.nextLong();
			long y = sc.nextLong();
			Pair mts = new Pair(x-y,x+y);
			pairs.add(mts);
		}
		Collections.sort(pairs);
		System.out.println(pairs);
		Pair a = pairs.get(0);
		Pair b = pairs.get(1);
		Pair x;
		int cnt = 0;
		if (a.max>b.max) {
			x = a;
			cnt = 1;
		}
		else {
			x=b;
			cnt = 2;
		}
		for (int i = 2; i<n-1; i++) {
			Pair c = pairs.get(i);
			if (c.max>x.max) {
				x = c;
				cnt++;
			}
		}
		System.out.println(cnt);
		pw.println(cnt);
		
		
		pw.close();
	}
	
}
