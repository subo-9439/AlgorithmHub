import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N, M;
    static int[] A;
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N+1];
        for (int i = 1 ; i <= N; i++) A[i] = scan.nextInt();
    }
    static void pro(){
        int L = 1;
        int R = 1;
        int cnt = 0;
        int sum = 0;
        while (L <= N || R <= N){

            if (sum >= M || R > N) sum -= A[L++];
            else {
                sum += A[R++];
            }
            if (sum == M) cnt++;
        }
        System.out.println(cnt);
    }
    public static void main(String[] args) {
        input();
        pro();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
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