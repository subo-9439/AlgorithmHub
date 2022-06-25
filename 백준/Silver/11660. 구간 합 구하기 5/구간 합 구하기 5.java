import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static FastReader scan = new FastReader();
    static int N,M;
    static int[][] map;
    static int[][] dp;
    static int[][] pos;
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        map = new int[N+1][N+1];
        dp = new int[N+1][N+1];
        pos = new int[M][4];
        for(int i =1; i<= N; i++){
            for(int j = 1; j <= N; j++){
                map[i][j] = scan.nextInt();
            }
        }
        for(int i = 1; i <=N; i++){
            for(int j = 1; j <=N; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];
            }
        }
        for(int i = 0; i<M; i++){
            for(int j = 0; j<4;j++){
                pos[i][j] = scan.nextInt();
            }
        }
    }
    static void pro(){
        long ans;
        for(int i = 0; i < M; i++){
            int x1 = pos[i][0];
            int y1 = pos[i][1];
            int x2 = pos[i][2];
            int y2 = pos[i][3];
            ans = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];
            System.out.println(ans);
        }
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