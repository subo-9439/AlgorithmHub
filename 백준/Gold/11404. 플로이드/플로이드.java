import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static final int INF = 1000000000;
    static int N,M;
    static int[][] map;
    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++){
            Arrays.fill(map[i],INF);
            map[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int dist = scan.nextInt();
            map[from][to] = Math.min(map[from][to],dist);
        }


    }
    static void floydWarshall() {
        for (int k = 1; k <= N; k++) {
            for (int r = 1; r <= N; r++) {
                for (int c = 1; c <= N; c++) {
                    map[r][c] = Math.min(map[r][c], map[r][k] + map[k][c]);
                }
            }
        }

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (map[r][c] == INF) System.out.print(0+" ");
                else System.out.print(map[r][c]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        input();
        floydWarshall();
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