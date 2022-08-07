import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N;
    static int[][] map;
    static int[][] dp;
    static void input(){
        N = scan.nextInt();
        map = new int[N][3];
        dp = new int[N][3];
        for (int i = 0; i < N; i++){
            for (int j = 0 ; j < 3; j++){
                dp[i][j] = scan.nextInt();
            }
        }
    }
    static void pro(){
        for (int i = 1; i < N; i++){
            dp[i][0] += Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] += Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] += Math.min(dp[i-1][0],dp[i-1][1]);
        }
        System.out.println(Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]),dp[N-1][2]));
    }
    public static void main(String[] args) {
        input();
        pro();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st == null || !st.hasMoreTokens()){
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