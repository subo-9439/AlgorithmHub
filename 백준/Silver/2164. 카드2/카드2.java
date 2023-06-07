

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1 2 3 4 5 6
		// 2 3 4 5 6
		
		// 3 4 5 6 2
		// 4 5 6 2 
		
		// 5 6 2 4
		// 6 2 4
		
		// 2 4 6
		// 4 6
		
		// 6 4
		// 4
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i <= n; i++) {
			q.add(i);
		}
		
		while(q.size()>=2) {
			q.poll();
			q.add(q.poll());
		}
		System.out.println(q.poll());
		
	}
}