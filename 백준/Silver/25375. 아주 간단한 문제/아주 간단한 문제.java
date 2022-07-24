import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int Q;

    static int pro(long a, long b){
        if (a == 1 && b!=1) return 1;

        long t = 1;
        for (long x = 1 ; t < b; x++){
            t = a*x;
            if (b-t == 0) return 0;
            if (gcd(t, b-t) == a) return 1;
        }
        return 0;
    }
    static long gcd(long x, long y){
        if (x % y == 0) return y;
        return gcd(y,x % y);
    }
    public static void main(String[] args) {
        Q = scan.nextInt();
        for (int i = 0; i < Q; i++){
            long a = scan.nextLong(), b = scan.nextLong();
            sb.append(pro(a,b)).append("\n");
        }
        System.out.println(sb.toString());
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
        long nextLong(){
            return Long.parseLong(next());
        }
    }
}