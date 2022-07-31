import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N;
    static int[][] arr,dp;
    static boolean[] visited;
    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int t = 0; t < T; t++){
            N = scan.nextInt();
            //시작
            arr = new int[2][N + 1];
            dp = new int[2][N + 1];
            for (int j = 0; j < 2; j++) { //초기화
                for (int k = 1; k <= N; k++) {
                    arr[j][k] = scan.nextInt();
                }
            }
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            for (int a = 2; a <= N; a++) {
                dp[0][a] = Math.max(dp[1][a - 1], dp[1][a - 2]) + arr[0][a];
                dp[1][a] = Math.max(dp[0][a - 1], dp[0][a - 2]) + arr[1][a];
            }
            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
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