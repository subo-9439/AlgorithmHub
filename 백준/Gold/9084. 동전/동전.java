import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N;
    static int[] coin;
    static int price;
    public static void main(String[] args) {
        int T = scan.nextInt();
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            input();
            int[] dp = new int[price+1];
            dp[0] = 1;
            for (int i = 0; i < coin.length; i++) {
                for (int j = coin[i]; j <= price; j++) {
                    dp[j] += dp[j - coin[i]];
                }
            }
            sb.append(dp[price]).append("\n");
        }
        System.out.println(sb);

    }

    private static void input() {
        N = scan.nextInt();
        coin = new int[N];
        for (int i = 0; i < N; i++){
            coin[i] = scan.nextInt();
        }
        price = scan.nextInt();

    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}