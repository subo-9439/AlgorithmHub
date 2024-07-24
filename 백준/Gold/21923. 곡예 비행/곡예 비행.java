import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N,M;
    static int[][] num;
    static int[][] upDp, downDp;
    public static void main(String[] args) {
        N = scan.nextInt();
        M = scan.nextInt();

        num = new int[N][M];
        upDp = new int[N][M];
        downDp = new int[N][M];


        //초기화
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < M; j++) {
                num[i][j] = scan.nextInt() ;
            }
        }

        //시작지점 초기화
        //가로 초기화
        //세로 초기화
        upDp[N-1][0] = num[N-1][0];
        for (int j = 1; j < M; j++) upDp[N-1][j] = upDp[N-1][j-1] + num[N-1][j];
        for (int i = N-2; i >= 0; i--) upDp[i][0] = upDp[i+1][0] + num[i][0];
        
        //상승
        for (int i = N-2 ; i >= 0; i--) {
            for (int j = 1; j < M; j++) {
                upDp[i][j] = Math.max(upDp[i+1][j], upDp[i][j-1]) + num[i][j];
            }
        }

        //끝지점 초기화
        //가로 초기화
        //세로 초기화
        downDp[N-1][M-1] = num[N-1][M-1];
        for (int j = M-2; j >= 0; j--) downDp[N-1][j] = downDp[N-1][j+1] + num[N-1][j];
        for (int i = N-2; i >= 0; i--) downDp[i][M-1] = downDp[i+1][M-1] + num[i][M-1];
    
        //하강
        for (int i = N-2 ; i >= 0; i--) {
            for (int j = M-2; j >= 0; j--) {
                downDp[i][j] = Math.max(downDp[i+1][j], downDp[i][j+1]) + num[i][j];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < N; i++) {
            for (int j = 0; j < M; j++){
                max = Math.max(max, upDp[i][j] + downDp[i][j]);
            }
        }
        System.out.println(max);

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
                }catch(IOException e) {
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