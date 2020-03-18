import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class AdjacencyList {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("GraphInputs.in"));
		PrintWriter pw = new PrintWriter(new File("GraphInputs.out"));
		
		//Adjacency List code
		int n = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<Integer>[] inputs = new ArrayList[n];
		
		for (int i = 0; i<n; i++) {
			inputs[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i<k; i++)
		{
			int first = sc.nextInt();
			int sec = sc.nextInt();
			inputs[first].add(sec);
			inputs[sec].add(first);
		}
		
		for (int i = 0; i<n; i++) {
			System.out.println(i + " " + inputs[i]);
		}
		pw.close();
	}
	
}