import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class haybales {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("haybales.in"));
		PrintWriter pw = new PrintWriter(new File("haybales.out"));
		
		int n = sc.nextInt();
		int q = sc.nextInt();
		
		int[] arr = new int[n];
		for (int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		for (int i =0 ; i<q; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = Arrays.binarySearch(arr, b);
			int r = Arrays.binarySearch(arr, a);
			int ans = 0;
			if (w>=0 && r>=0) ans = w-r+1;
			else if (w<0 && r>=0) ans = ~w-r;
			else if (w>=0 && r<0) ans = w-~r+1;
			else ans = ~w-~r;
			pw.println(ans);
		}
		pw.close();
	}
	
}
//2016 December Silver #1
