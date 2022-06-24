import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int  T;
    static long[] dp = new long[1000001];
    static void pro(){
        Arrays.fill(dp,1);

        for (int i = 2; i < 1000001; i++){
            for (int j = 1; j * i < 1000001; j++ ){
                dp[i * j] += i;
            }
            dp[i] += dp[i-1];
        }
    }
    public static void main(String[] args) {
        pro();
        StringBuilder sb = new StringBuilder();
        T = scan.nextInt();
        for (int i = 0 ; i < T ; i++){
            int N= scan.nextInt();
           sb.append(dp[N]).append("\n");
        }
        System.out.println(sb.toString());
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null ||!st.hasMoreTokens()){
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