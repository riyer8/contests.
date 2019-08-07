import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class backforth {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("backforth.in"));
		PrintWriter pw = new PrintWriter(new File("backforth.out"));
		
		ArrayList<Integer> r1 = new ArrayList<Integer>();
		ArrayList<Integer> r2 = new ArrayList<Integer>();
		for (int i =0 ; i<10;i++) {
			r1.add(sc.nextInt());
		}
		for (int i =0 ; i<10;i++) {
			r2.add(sc.nextInt());
		}
		ArrayList<Integer> r3 = new ArrayList<Integer>();
		ArrayList<Integer> r4 = new ArrayList<Integer>();
		for (int i = 0; i<10; i++) {
			r3.add(r1.get(i));
		}
		for (int i = 0; i<10; i++) {
			r4.add(r2.get(i));
		}
		
		Set<Integer> ans = new HashSet<Integer>();
		for (int i =0; i<10; i++) {
			int b1 = r1.get(i);
			r1.remove(i);
			r2.add(b1);
			for (int j = 0; j<r2.size();j++) {
				int b2 = r2.get(j);
				System.out.println(r1);
				System.out.println(r2);
				r2.remove(j);
				r1.add(b2);
				for (int k = 0; k<r1.size(); k++) {
					int b3 = r1.get(k);
					r1.remove(k);
					r2.add(b3);
					for (int l = 0; l<r2.size();l++) {
						int b4= r2.get(l);
						ans.add(1000-b1+b2-b3+b4);
					}
					r1.add(k,b3);
					r2.remove(10);
				}
				
				r2.add(j,b2);
				r1.remove(9);
				
				System.out.println(r1);
				System.out.println(r2);System.out.println();
			}
			r1.clear();
			r2.clear();
			for (int j = 0; j<10; j++) {
				r1.add(r3.get(j));
			}
			for (int j = 0; j<10; j++) {
				r2.add(r4.get(j));
			}
			
		}
		System.out.println(ans);
		System.out.println(ans.size());
		pw.println(ans.size());
		
		
		pw.close();
	}
	
}
