import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N,M,min = Integer.MAX_VALUE;
    static int[][] map;
    public static void main(String[] args) {

        input();
        for (int col = 0; col < M; col++) {
            dfs(0, col,map[0][col],2);
        }

        System.out.println(min);
    }
    private static void dfs(int row, int col, int sum ,int dir){
        if (row+1 == N) {
            if (min > sum)
                min = sum;
            return;
        }
        if (dir!=0)
            dfs(row+1, col, sum + map[row+1][col], 0);
        if (col-1 >= 0 && dir!=-1)
            dfs(row+1, col-1, sum + map[row+1][col-1] , -1);
        if (col+1 < M && dir!=1)
            dfs(row+1, col+1, sum + map[row+1][col+1], 1);
    }
    private static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        map = new int[N][M];
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scan.nextInt();
            }
        }
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

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}