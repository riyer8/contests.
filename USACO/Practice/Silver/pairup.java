import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class pairup {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("pairup.in"));
		PrintWriter pw = new PrintWriter(new File("pairup.out"));
		
		int n = sc.nextInt();
		Map<Object, Long> map = new HashMap<Object, Long>();
		for (int i = 0; i<n; i++) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			map.put(b,a);
		}
		long max = Long.MIN_VALUE;
		Set<Object> set = map.keySet();
		Object[] arr = set.toArray();
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int onep = 0;
		int twop = n-1;
		while(onep<twop) {
			long onenum = map.get(arr[onep]);
			long twonum = map.get(arr[twop]);
			if (onenum<twonum) {
				max = Math.max((long)arr[onep]+(long)arr[twop], max);
				twonum-=onenum;
				map.remove(arr[onep]);
				onep++;
				map.put(arr[twop], twonum);
			}
			else if (onenum>twonum) {
				max = Math.max((long)arr[onep]+(long)arr[twop], max);
				onenum-= twonum;
				map.remove(arr[twop]);
				twop--;
				map.put(arr[onep], onenum);
			}
			else {
				max = Math.max((long)arr[onep]+(long)arr[twop], max);
				map.remove(arr[onep]);
				map.remove(arr[twop]);
				onep++;
				twop--;
			}
		}
		System.out.println(max);
		pw.println(max);
		
		pw.close();
	}
	
}
//2017 US Open Silver #1 
