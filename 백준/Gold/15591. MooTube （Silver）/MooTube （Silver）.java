import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static int N, M;

    static ArrayList<Integer>[] map;
    static int[][] dist;
    static boolean[] visited;
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        map = new ArrayList[N+1];
        dist = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) map[i] = new ArrayList<>();

        for (int i = 1; i <= N-1; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int h = scan.nextInt();
            map[x].add(y);
            map[y].add(x);
            dist[x][y] = h;
            dist[y][x] = h;
        }
    }
    static void pro(){

        for (int i = 1; i <= N; i++){
            visited = new boolean[N+1];
            bfs(i);
        }
        for (int i = 1; i <= M; i++){
            int k = scan.nextInt();
            int v = scan.nextInt();
            int cnt = 0;
            for (int j = 1; j <= N; j++){
                if(dist[v][j] >= k) {
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
    static void bfs(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        while (!queue.isEmpty()){
            int nx = queue.poll();
            visited[nx] = true;
            for (int y: map[nx]){
                if(visited[y]) continue;
                if(nx!=x){
                    dist[x][y] = Math.min(dist[nx][y], dist[x][nx]);
                    dist[y][x] = dist[x][y];
                }
                queue.add(y);
            }

        }
    }
    public static void main(String[] args) {
        input();
        pro();

    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
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