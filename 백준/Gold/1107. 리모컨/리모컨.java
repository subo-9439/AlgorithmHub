import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int M,N;
    static int[] err;
    static boolean[] remoteErr;
    static void input(){
        N = scan.nextInt();

        M = scan.nextInt();
        err = new int[M];
        remoteErr = new boolean[11];
        for (int i = 0; i < M; i++) err[i] = scan.nextInt();

        for (int a: err) remoteErr[a] = true;

    }

    static void pro(){
        int result = Math.abs(N - 100);
        for (int i = 0; i < 1000000; i++){
            String str = String.valueOf(i);
            boolean isBreak = false;

            for (int j = 0; j < str.length(); j++){
                if (remoteErr[str.charAt(j) - '0']){
                    isBreak = true;
                    break;
                }
            }
            if (!isBreak){
                int min = Math.abs(N-i) + str.length();
                result = Math.min(min,result);
            }
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        input();
        pro();

    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
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