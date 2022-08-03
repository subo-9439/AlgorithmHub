import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N;
    static long B;
    static int[][] matrix;
    static int[][] dp;
    static void input(){
        N = scan.nextInt();
        B = scan.nextLong();
        matrix = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                matrix[i][j] = scan.nextInt()%1000;
            }
        }
    }


    public static int[][] pow(long exponent){//4
        if (exponent == 1){
            return matrix;
        }
        int[][] temp = pow((long) Math.floor(exponent / 2));//a2

        if (exponent%2 == 1) return oddMultiple(multiple(temp));
        return multiple(temp);//a2 * a2 * a
    }
//199 290
//        435 634

    public static int[][] multiple(int[][] arr){
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                int sum = 0;
                for (int k = 0 ; k < N; k++){
                    sum += arr[i][k] * arr[k][j];
                }
                sum%=1000;
                temp[i][j] = sum;
            }
        }
        return temp;
    }
    public static int[][] oddMultiple(int[][]arr){
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                int sum = 0;
                for (int k = 0; k <N; k++){
                    sum+= arr[i][k] * matrix[k][j];
                }
                sum%=1000;
                temp[i][j] = sum;
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        input();
        int[][] ans = pow(B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
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
        double nextDouble(){
            return Double.parseDouble(next());
        }
    }
}