import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class BinarySearch {
	public void run() throws Exception {
		//ONLY WORKS IF ARRAY IS SORTED
		
		//for example: let the array be numbers from 0->27 by 3's
		//trying to find number 11
		int[] arr = new int[10];
		
		for(int i = 0; i < 30; i+=3) arr[i/3] = i; //arr of 0,3,6...,27
		System.out.println(Arrays.toString(arr));
		//initialize variables:
		int lo = 0;
		int hi = arr.length - 1;
		int mid = (lo + hi) / 2;
		int counter = 0;
		while(lo < hi) {
			mid = (lo + hi)/2;
			
			//CHANGE TO THE VARIABLE THAT YOU ARE TRYING TO FIND
			if(arr[mid] == 11) {
				break;
			}
			
			else if(arr[mid] > 11) {
				hi = mid;
			}
			
			else if(arr[mid] < 11) {
				lo = mid;
			}
			if (counter++>1000) break;
		}
		System.out.println(mid);
		
	}
	public static void main (String[] args) throws Exception {
		new BinarySearch().run();
	}
}
