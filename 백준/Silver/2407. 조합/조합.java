import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N, M;
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
    }

    public static void main(String[] args) {
        input();
        BigInteger[] dp = new BigInteger[101];
        dp[0] = BigInteger.valueOf(1);
        for (int i = 1; i<= 100; i++) {
            dp[i] = dp[i-1].multiply(BigInteger.valueOf(i));
        }
        BigInteger ans = dp[N].divide(dp[N-M].multiply(dp[M]));
        System.out.println(ans);
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader () {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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