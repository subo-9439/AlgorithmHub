import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N;
    static int[][] arr;
    static int[][] min;
    static int[][] max;
    static void input(){
        N = scan.nextInt();
        arr = new int[N][3];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < 3; j++)
                arr[i][j] = scan.nextInt();
        min = new int[N][3];
        max = new int[N][3];
    }
    static void pro(){
        min[0][0] = arr[0][0];
        max[0][0] = arr[0][0];
        min[0][1] = arr[0][1];
        max[0][1] = arr[0][1];
        min[0][2] = arr[0][2];
        max[0][2] = arr[0][2];

        for (int i = 1; i < N; i++){
            min[i][0] = Math.min(min[i-1][0],min[i-1][1]) + arr[i][0];
            max[i][0] = Math.max(max[i-1][0],max[i-1][1]) + arr[i][0];
            min[i][1] = Math.min(Math.min(min[i-1][0],min[i-1][1]),min[i-1][2]) + arr[i][1];
            max[i][1] = Math.max(Math.max(max[i-1][0],max[i-1][1]),max[i-1][2]) + arr[i][1];
            min[i][2] = Math.min(min[i-1][1],min[i-1][2]) + arr[i][2];
            max[i][2] = Math.max(max[i-1][1],max[i-1][2]) + arr[i][2];
        }
        int a=0,b=900000;
        for (int i = 0 ; i < 3; i++){
            if (max[N-1][i] > a) a = max[N-1][i];
            if (min[N-1][i] < b) b = min[N-1][i];
        }
        System.out.println(a+" "+b);
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
            while (st==null||!st.hasMoreTokens()){
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