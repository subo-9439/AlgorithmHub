import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N;
    static int[] t;//최대 15일까지 오버할 수 있으므로
    static int[] p;
    static int[] dp;
    static int max = 0;
    public static void main(String[] args) {
        N = scan.nextInt();
        t = new int[N+16];
        p = new int[N+16];
        dp = new int[N+16];
        for (int i = 0; i < N; i++) {
            t[i] = scan.nextInt();  // 기간
            p[i] = scan.nextInt();  // 금액
        }
        for (int i = 0; i <= N; i++){
            dp[i] = Math.max(dp[i],max);
            dp[ t[i] + i ] = Math.max(dp[ t[i] + i ] , p[i] + dp[i]);
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader (){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
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