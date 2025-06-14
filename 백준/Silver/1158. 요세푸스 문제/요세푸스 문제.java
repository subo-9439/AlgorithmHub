import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
	Boj_1158
	요세푸스 순열
 */
public class Main{
	static FastReader scan  = new FastReader();
	static StringBuilder sb = new StringBuilder();
	static int N,K;
	static void input(){
		N = scan.nextInt();
		K = scan.nextInt();
	}
	static void pro(){
		sb.append("<");
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1 ; i<=N; i++) q.add(i);

		int cnt = 0;
		while (!q.isEmpty()){
			cnt++;
			int num = q.poll();
			if(cnt == K) {
				if(q.size()==0){
					sb.append(num).append(">");
				}else{
					sb.append(num).append(", ");
				}
				cnt = 0 ;
				continue;
			}
			q.add(num);

		}
		System.out.println(sb.toString());
	}
	public static void main(String[] args) {
		input();
		pro();
	}
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;

		public FastReader(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next(){
			while (st==null || !st.hasMoreTokens()){
				try {
					st = new StringTokenizer(br.readLine());
				}catch (IOException e){
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt(){
			return Integer.parseInt(next());
		}
	}
}