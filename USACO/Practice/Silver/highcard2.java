import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class highcard2 {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("highcard.in"));
		PrintWriter pw = new PrintWriter(new File("highcard.out"));
		
		int cards = sc.nextInt();
		
		ArrayList<Integer> Elsie = new ArrayList<Integer>();
		ArrayList<Integer> Bessie = new ArrayList<Integer>();
		
		int[] arr = new int[2*cards];
		for (int i = 0; i<cards; i++) {
			arr[sc.nextInt()-1] = 1;
			//1 is Elsie's card. 0 is Bessie's card
		}
		
		for (int i = 0 ; i<2*cards; i++) {
			if (arr[i] == 1) Elsie.add(i+1);
			else Bessie.add(i+1);
		}
		
		int i = 0;
		int j = 0;
		int score = 0;
		while((i!=cards) && (j!=cards)) {
			int x = Bessie.get(j);
			int y = Elsie.get(i);
			if (x>y) {
				i++;
				j++;
				score++;
			}
			else j++;
		}
		
		pw.println(score);
		pw.close();
	}
}
//2015 December Silver #2
//This solution uses two-pointer
//First tried Collections.sort on Elsie but that gave a runtime error (cards max input was 50,000)
//Then I used one array to list all the cards and both cow's cards got sorted
