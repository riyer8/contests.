import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class highcard {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("highcard.in"));
		PrintWriter pw = new PrintWriter(new File("highcard.out"));
		
		int card = sc.nextInt();
		int[] arr = new int[card*2];
		
		for (int i = 0; i<card; i++) {
			arr[sc.nextInt()-1] = 1;
			//1 represents Elsie's card. 0 represents Bessie's card
		}
		
		int score = 0;
		int diff = 0;
		for (int i = 0; i<card*2; i++) {
			 if (arr[i] == 1) diff--;
			 if (arr[i] == 0 && diff<0) {
				 score++;
				 diff++;
			 }
		}
		pw.println(score);
    
		pw.close();
	}
	
}
//2015 December Silver #2
//This was my first solution
//It has both Elsie's and Bessie's cards in one array
