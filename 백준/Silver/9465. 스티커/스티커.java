import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N;
    static int[][] dp;
    static boolean[] visited;
    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int t = 0; t < T; t++){
            N = scan.nextInt();
            dp = new int[N+1][3];
            visited = new boolean[N+1];
            for (int i = 1; i <= N; i++)dp[i][1] = scan.nextInt();
            for (int i = 1; i <= N; i++)dp[i][2] = scan.nextInt();
            pro();
        }
    }
    static void pro(){
        for (int i = 1; i <= N; i++){
            dp[i][0] += Math.max(dp[i-1][1],dp[i-1][2]);
            dp[i][1] += Math.max(dp[i-1][0],dp[i-1][2]);
            dp[i][2] += Math.max(dp[i-1][0],dp[i-1][1]);
        }
        System.out.println(Math.max(Math.max(dp[N][0], dp[N][1]),dp[N][2]));
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st== null||!st.hasMoreTokens()){
                try {
                    st= new StringTokenizer(br.readLine());
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