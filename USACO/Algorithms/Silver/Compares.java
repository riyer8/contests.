import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class Compares {
	public static class Pair implements Comparable<Pair> {
		int a;
		int b;
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public int compareTo(Pair x) {
			if(b != x.b) return b-x.b;
			return a-x.a;
		}
	}
	public static int dist(Pair a, Pair b) {
		return a.a-b.a + a.b-b.b;
	}
	static class Int implements Comparable<Int> {
		int i;
		public Int(int i) {
			this.i = i;
		}
		public int compareTo(Int x) {
			return (x.i-i);
		}
	}
	static class Name implements Comparable<Name> {
		String first_name, last_name;
		public Name(String f, String l) {
			first_name = f;
			last_name = l;
		}
		public int compareTo(Name n) {
			if(!last_name.equals(n.last_name)) {
				return last_name.compareTo(n.last_name);
			}
			return first_name.compareTo(n.first_name);
		}
		public String toString() {
			return first_name + " " + last_name;
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("Compares.in"));
		PrintWriter pw = new PrintWriter(new File("Compares.out"));
		
		int n = sc.nextInt();
		ArrayList<Pair> arr = new ArrayList<Pair>();
		for (int i = 0; i<n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			Pair p = new Pair(a,b);
			arr.add(p);
			arr.add(new Pair(a,b));
		}
		Collections.sort(arr);
		
		pw.close();
	}
}