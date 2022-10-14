import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static int N, M, maxSum;
    static int[][] map;
    static boolean[][] visited;
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        map = new int[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                map[r][c] = scan.nextInt();
            }
        }
        visited = new boolean[N][M];
    }
    static void dfs(int row, int col, int cnt ,int sum){
        if (cnt == 4) {
            maxSum = Math.max(maxSum,sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = row + dir[d][0];
            int nc = col + dir[d][1];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            if (visited[nr][nc]) continue;
            visited[nr][nc] = true;
            dfs(nr,nc,cnt+1,sum+map[nr][nc]);
            visited[nr][nc] = false;
        }
    }
    static int getLast(int row, int col) {// 'ㅜ' 구하기
        int base = map[row][col];
        int cnt = 0;        //사방탐색 성공횟수
        int min = Integer.MAX_VALUE;
        // 중심점을 중심으로 사방 탐색해서 제일 작은값을 빼자
        for (int d = 0; d < 4; d++) {
            int nr = row + dir[d][0];
            int nc = col + dir[d][1];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            cnt++;
            base += map[nr][nc];
            min = Math.min(map[nr][nc], min);
        }

        if (cnt == 4) // 4군데 생겅
            return base - min;
        if (cnt == 3)
            return base;
        else
            return -1;
    }
    public static void main(String[] args) {
        //N,M 받기
        input();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                visited[r][c] = true;
                // 'ㅜ'를 제외한 나머지 경우는 DFS로 탐색해보기
                dfs(r,c,1,map[r][c]);
                // 'ㅜ'는 별도로 철;
                maxSum = Math.max(getLast(r,c), maxSum);
                visited[r][c] = false;
            }
        }
        System.out.println(maxSum);
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