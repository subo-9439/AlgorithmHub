import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        long H,W,N,M;
        FastReader scan = new FastReader();
        H = scan.nextInt();
        W = scan.nextInt();
        N = scan.nextInt();
        M = scan.nextInt();

        long a = H / (N+1);
        long b = H % (N+1);
        long c = W / (M+1);
        long d = W % (M+1);

        if (b > 0){
            a++;
        }
        if (d > 0){
            c++;
        }

        System.out.println(a*c);

    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        
        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st== null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}