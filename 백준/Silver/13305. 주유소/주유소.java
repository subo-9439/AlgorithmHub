import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static int N;
    static long sum;
    static long[] dist;
    static long[] cost;

    public static void main(String[] args) {
        input();
        long ans = cost[0] * dist[0];
        sum-= dist[0];
        for (int i = 1; i < N-1; i++) {
            if (sum <= 0) break;
            if (cost[i] < cost[i+1]) {
                ans += cost[i] * (dist[i] + dist[i+1]);
                sum -= dist[i] + dist[i-1];
            }else {
                ans += cost[i] * dist[i];
                sum -= dist[i];
            }
        }
        System.out.println(ans);
    }

    private static void input() {
        N = scan.nextInt();
        dist = new long[N];
        cost = new long[N];
        dist[N-1] = 0;
        for (int i = 0 ; i < N-1; i++) {
            dist[i] = scan.nextInt();
            sum+=dist[i];
        }
        for (int i = 0; i < N; i++) {
            cost[i] = scan.nextInt();
        }
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
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