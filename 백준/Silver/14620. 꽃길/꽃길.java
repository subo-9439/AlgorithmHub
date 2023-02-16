import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N , min = Integer.MAX_VALUE;
    static int[][] cost;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1},{0,0}};
    static boolean[][] visited;
    public static void main(String[] args) {
        input();
        dfs(0,0);
        System.out.println(min);
    }

    private static void dfs(int cnt,int totalSum) {
        if (cnt == 3) {
            min = Math.min(min,totalSum);
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                boolean flag = true;
                for (int k = 0; k < 5; k++) {
                    int nx = i + dir[k][0];
                    int ny = j + dir[k][1];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                        flag = false;
                        break;
                    }
                    if (visited[nx][ny]) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) continue;
                int curSum = 0;
                for (int k = 0; k < 5; k++) {
                    int nx = i + dir[k][0];
                    int ny = j + dir[k][1];
                    curSum+=cost[nx][ny];
                    visited[nx][ny] = true;
                }

                dfs(cnt+1, totalSum + curSum);
                for (int k = 0; k < 5; k++) {
                    int nx = i + dir[k][0];
                    int ny = j + dir[k][1];
                    visited[nx][ny] = false;
                }
            }
        }
    }

    private static void input() {
        N = scan.nextInt();
        cost = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cost[i][j] = scan.nextInt();
            }
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
                try{
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