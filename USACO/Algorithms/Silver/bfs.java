import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class bfs {
	static ArrayList<Integer>[] adjlist;
	static boolean[] visited;
	static Queue<Integer> queue;
	public static void bfs(int node) {
		if (visited[node] == true) return;
		visited[node] = true;
		for (int i = 0;i<adjlist[node].size(); i++) {
			queue.add(adjlist[node].get(i));
		}
		bfs(queue.poll());
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("bfs.in"));
		PrintWriter pw = new PrintWriter(new File("bfs.out"));
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		adjlist = new ArrayList[n];
		for (int i = 0; i<m; i++) {
			adjlist[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i<m; i++) {
			int fir = sc.nextInt();
			int sec = sc.nextInt();
			adjlist[fir].add(sec);
			adjlist[sec].add(fir);
		}
		visited = new boolean[n];
		queue = new LinkedList<Integer>();
    
		for (int v = 0; v< visited.length; v++) { //this loop goes through the visited array to make sure all the vertices are visited
			if (!visited[v]) {
				bfs(v);
			}
		}
		pw.close();
	}
}
