import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static int[] nums;
    static int[] dp;
    static ArrayList<Integer>[] list;
    static void input(){
        N = scan.nextInt();
        nums = new int[N];
        for(int i = 0; i < N ; i++) nums[i] = scan.nextInt();
        M = scan.nextInt();
    }
    static void pro(){
        dp = new int[N+1];
        dp[0] = 0;
        for(int i = 1; i <= N ; i++){
            dp[i] = dp[i-1] + nums[i-1];
        }
        for(int i= 0; i < M ; i++){
            int start = scan.nextInt();
            int end = scan.nextInt();
            int res = dp[end] - dp[start-1];
            sb.append(res).append("\n");
        }
    }
    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb.toString());
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st == null || !st.hasMoreTokens()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
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