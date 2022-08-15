import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static int N,M,K;
    static int[][] A, B;
    static void input(){
        N = scan.nextInt(); //A 행렬의 row
        M = scan.nextInt(); //A 행령의 col
        A = new int[N][M];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                A[i][j] = scan.nextInt();
            }
        }
        M = scan.nextInt();
        K = scan.nextInt();
        B = new int[M][K];
        for (int i = 0; i < M; i++){
            for (int j = 0; j < K; j++){
                B[i][j] = scan.nextInt();
            }
        }

    }
    static void pro(){
        int[][] ans = new int[N][K];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < K; j++){
                for (int t = 0; t < M; t++){
                    ans[i][j] += A[i][t]*B[t][j];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++){
            for (int j = 0; j < K; j++){
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

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
            while (st == null || !st.hasMoreElements()){
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
