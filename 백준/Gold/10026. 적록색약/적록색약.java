import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N;
    static String[] map;
    static char[][] redmap;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visited;

    static void input(){
        N = scan.nextInt();
        map = new String[N];
        redmap = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = scan.nextLine();
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {
                if(map[i].charAt(j) == 'G') redmap[i][j] = 'R';
                else redmap[i][j] = map[i].charAt(j);
            }
        }
    }
    static void pro(){
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++){
            for (int j = 0 ; j < N; j++){
                if(visited[i][j]) continue;
                if(map[i].charAt(j) == 'R' ) dfsR(i,j);
                if(map[i].charAt(j) == 'B' ) dfsB(i,j);
                if(map[i].charAt(j) == 'G' ) dfsG(i,j);
                cnt++;
            }
        }
        sb.append(cnt).append(" ");
        visited = new boolean[N][N];
        cnt = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0 ; j < N; j++){
                if(visited[i][j]) continue;
                if(redmap[i][j] == 'R' ) dfsredR(i,j);
                if(redmap[i][j] == 'B' ) dfsredB(i,j);
                cnt++;
            }
        }
        sb.append(cnt);
        System.out.println(sb.toString());
    }
    static void dfsR(int x, int y){
        visited[x][y] = true;

        for (int k = 0 ; k < 4; k++){
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (visited[nx][ny]) continue;
            if (map[nx].charAt(ny) == 'B') continue;
            if (map[nx].charAt(ny) == 'G') continue;
            dfsR(nx,ny);
        }
    }
    static void dfsG(int x, int y){
        visited[x][y] = true;

        for (int k = 0 ; k < 4; k++){
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (visited[nx][ny]) continue;
            if (map[nx].charAt(ny) == 'R') continue;
            if (map[nx].charAt(ny) == 'B') continue;
            dfsG(nx,ny);
        }
    }
    static void dfsB(int x, int y){
        visited[x][y] = true;

        for (int k = 0 ; k < 4; k++){
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (visited[nx][ny]) continue;
            if (map[nx].charAt(ny) == 'R') continue;
            if (map[nx].charAt(ny) == 'G') continue;
            dfsB(nx,ny);
        }
    }
    static void dfsredR(int x,int y){
        visited[x][y] = true;

        for (int k = 0 ; k < 4; k++){
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (visited[nx][ny]) continue;
            if (redmap[nx][ny] == 'B') continue;
            dfsredR(nx,ny);
        }
    }
    static void dfsredB(int x,int y){
        visited[x][y] = true;

        for (int k = 0 ; k < 4; k++){
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (visited[nx][ny]) continue;
            if (redmap[nx][ny] == 'R') continue;
            dfsredB(nx,ny);
        }
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
            while (st == null ||!st.hasMoreTokens()){
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
        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}