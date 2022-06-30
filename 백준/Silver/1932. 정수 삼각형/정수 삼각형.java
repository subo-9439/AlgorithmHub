import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[][] arr;
    static int[][] dp;

    static void input(){
        n = sc.nextInt();
        arr = new int[n+1][n+1];
        dp = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                arr[i][j] = sc.nextInt();
            }
        }
    }
    static void pro(){
        //초기값
        dp[1][1] = arr[1][1];

        //두번씩
        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++){
                for(int cnt = 0; cnt<2; cnt++){
                    if(arr[i][j+cnt]+dp[i-1][j] > dp[i][j+cnt])
                    dp[i][j+cnt] = arr[i][j+cnt]+dp[i-1][j];

                }
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(dp[n][i] > ans) ans = dp[n][i];
        }   
        sb.append(ans);
    }
    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreElements()){
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