import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class AdjacencyMatrix {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("GraphInputs.in"));
		PrintWriter pw = new PrintWriter(new File("AdjacencyMatrix.out"));
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] arr = new int[n][n];
		for (int i = 0; i<k; i++) {
			int fir = sc.nextInt();
			int sec = sc.nextInt();
			arr[fir][sec] = 1;
			arr[sec][fir] = 1;
		}
		
		for (int i = 0; i<n; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
		pw.close();
	}
	
}