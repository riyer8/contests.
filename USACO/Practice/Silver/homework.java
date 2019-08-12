import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class homework {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("homework.in"));
		PrintWriter pw = new PrintWriter(new File("homework.out"));
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] min = new int[n];
		min[n-1] = arr[n-1];
		for (int i = n-2; i>=0; i--) {
			min[i] = Math.min(arr[i],min[i+1]);
		}
		System.out.println(Arrays.toString(min));
		for(int i = 1; i<n; i++) {
			arr[i] = arr[i-1]+arr[i];
		}
		System.out.println(Arrays.toString(arr));
		ArrayList<Integer> all = new ArrayList<Integer>();
		double max = 0;
		for (int i = 1; i<n-1; i++) {
			double a = (arr[n-1]-arr[i-1]-min[i])/(double)(n-i-1);
			System.out.println(a);
			if (a>max) {
				all.clear();
				max = a;
				all.add(i);
			}
			else if (a == max) {
				all.add(i);
			}
		}
		for (int i = 0; i<all.size(); i++) {
			System.out.println(all.get(i));
			pw.println(all.get(i));
		}
		
		pw.close();
	}
	
}
//2017 December Silver #1
