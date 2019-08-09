import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class mixmilk {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("mixmilk.in"));
		PrintWriter pw = new PrintWriter(new File("mixmilk.out"));
		
		int m1 = sc.nextInt();
		int c1 = sc.nextInt();
		int m2 = sc.nextInt();
		int c2 = sc.nextInt();
		int m3 = sc.nextInt();
		int c3 = sc.nextInt();
		for (int i = 0; i<100; i++) {
			if (i%3 == 0) {
				if (c1+c2>m2) {
					c1 = c1-(m2-c2);
					c2 = m2;
				}
				else {
					c2 = c1+c2;
					c1 = 0;
				}
			}
			else if (i%3 == 1) {
				if (c2+c3>m3) {
					c2 = c2-(m3-c3);
					c3 = m3;
				}
				else {
					c3 = c2+c3;
					c2 = 0;
				}
			}
			else{
				if (c3+c1>m1) {
					c3 = c3-(m1-c1);
					c1 = m1;
				}
				else {
					c1 = c3+c1;
					c3 = 0;
				}
			}
			System.out.println(c1 + " " + c2 + " " + c3);
		}
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		pw.println(c1);
		pw.println(c2);
		pw.println(c3);
		
		
		pw.close();
	}
	
}
