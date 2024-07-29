import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N, M, T, cnt;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) {
        N = scan.nextInt();
        M = scan.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int r = scan.nextInt();
                int g = scan.nextInt();
                int b = scan.nextInt();

                map[i][j] = (r+g+b)/3;
            }
        }
        T = scan.nextInt();
        
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] < T || visited[i][j]) continue;
                visited[i][j] = true;
                recursion(i,j);
                cnt++; 
            }
        }

        System.out.println(cnt);
    }
    static void recursion(int x, int y) {
        for(int k = 0; k < 4; k++) {
            int dx = x + dir[k][0];
            int dy = y + dir[k][1];
            if(dx < 0 || dy < 0 || dx >= N || dy >= M) continue;
            if(map[dx][dy] < T || visited[dx][dy]) continue;
            visited[dx][dy] = true;
            recursion(dx, dy);
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