import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class blist {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("blist.in"));
		PrintWriter pw = new PrintWriter(new File("blist.out"));
		
		int times = sc.nextInt();
		int start = Integer.MAX_VALUE;
		int end = Integer.MIN_VALUE;
		int[] s = new int[times];
		int[] e = new int[times];
		int[] buc = new int[times];
		for (int i = 0; i<times; i++) {
			s[i] = sc.nextInt();
			e[i] = sc.nextInt();
			buc[i] = sc.nextInt();
			if (s[i]<start) start = s[i];
			if (e[i] > end) end = e[i];
		}
		for (int i =0 ; i<times;i++) {
			s[i] -= start;
			e[i] -= start;
		}
		end-=start;
		int[] ans = new int[end];
		for (int i = 0; i<times; i++) {
			for (int j = s[i]; j<e[i]; j++) {
				ans[j] += buc[i];
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i<end; i++) {
			int a = ans[i];
			if (max<a) max = a;
		}
		System.out.println(max);
		pw.println(max);
		
		
		pw.close();
	}
	
}
