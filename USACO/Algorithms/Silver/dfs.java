import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class dfs {
	static boolean[] visited;
	static ArrayList<Integer>[] adjList;
	static int[] names;
	public static void floodfill(int node, int flag) { // groups the ones that are connected to a node into a specific flag
		if (names[node] != -1) return;
		names[node] = flag;
		for (int i = 0; i<adjList[node].size(); i++) {
			floodfill(adjList[node].get(i),flag);
		}
	}
	public static void dfs(int node) {
		if (visited[node] == true) return;
		visited[node] = true;
		for (int i = 0; i<adjList[node].size(); i++) {
			dfs(adjList[node].get(i));
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("dfs.in"));
		PrintWriter pw = new PrintWriter(new File("dfs.out"));
		
		int n = sc.nextInt(); //number of nodes
		int m = sc.nextInt();// lines of code below
		adjList = new ArrayList[n]; //an array of ArrayLists
		visited = new boolean[n];
		names = new int[n];
		for (int i = 0; i<n; i++) {
			adjList[i] = new ArrayList<Integer>();
			visited[i] = false;
			names[i] = -1;
		}
		for (int i = 0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adjList[a].add(b); //undirected map
			adjList[b].add(a);
		}
		int cur = 0;
		for (int i = 0; i<n; i++) {
			if (names[i] == -1) {
				floodfill(i,cur);
				cur++;
			}
		}
		System.out.println(Arrays.toString(names));
		//finding if we can go from 0 to 4 --> answer should be false
		dfs(0);
		if (visited[4] == true) System.out.println("YES"); //boolean checks if the node was reached through A CONNECTED graph NOT COMPLETE
		else System.out.println("NO");
		pw.close();
	}
	
}