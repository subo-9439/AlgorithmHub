import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pos{
    int x;
    int y;
    int time;
    Pos(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}
public class Main {
    static FastrReader scan = new FastrReader();
    static char[][] map;
    static int[][] dist;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static int row, col , min = Integer.MAX_VALUE, ans;
    static Pos startPos;
    static Queue<Pos> fires;
    static Queue<Pos> queue;
    static boolean[][] visited;
    public static void main(String[] args) {
        int testCase = scan.nextInt();
        for (int i = 0; i < testCase; i++){
            input();
            //불이 옮겨진칸엔 못가니까 불부터 체크
            ans=0;
            bfs();
            if (ans == 0) System.out.println("IMPOSSIBLE");
            else System.out.println(ans);
        }
    }

    private static void bfs() {
        queue.add(startPos);
        dist[startPos.x][startPos.y] = 0;

        while (!queue.isEmpty()){
            //불부터 퍼뜨려야한다.
            int fireSize = fires.size();
            for (int i = 0; i < fireSize; i++){
                Pos fire = fires.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = fire.x + dir[k][0];
                    int ny = fire.y + dir[k][1];
                    if (isOutSide(nx,ny)) continue;
                    if (map[nx][ny] == '.' || map[nx][ny] == '@'){
                        map[nx][ny] = '*';
                        fires.add(new Pos(nx,ny,0));
                    }
                }
            }

            //상근이 옮기기
            int humanSize = queue.size();
            for (int i = 0; i < humanSize; i++) {
                Pos human = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = human.x + dir[k][0];
                    int ny = human.y + dir[k][1];
                    if (isOutSide(nx,ny)){
                        ans = dist[human.x][human.y] + 1;
                        ans = human.time+1;
                        return;
                    }
                    if (map[nx][ny] == '.') {
                        map[nx][ny] = '@';
                        dist[nx][ny] = dist[human.x][human.y] + 1;
                        queue.add(new Pos(nx,ny,human.time+1));
                    }
                }
            }
        }
    }

    private static boolean isOutSide(int nr, int nc) {
        return nr < 0 || nc < 0 || nr >= row || nc >= col;
    }


    private static void input() {
        col = scan.nextInt();
        row = scan.nextInt();
        map = new char[row][col];
        dist = new int[row][col];
        fires = new LinkedList<>();
        queue = new LinkedList<>();
        for (int r = 0; r < row; r++) {
            String roomInfo = scan.nextLine();
            for (int c = 0; c < col; c++){
                map[r][c] = roomInfo.charAt(c);
                if (map[r][c] == '@') startPos = new Pos(r,c,0);
                if (map[r][c] == '*') fires.add(new Pos(r,c,0));
            }
        }
    }

    static class FastrReader{
        BufferedReader br;
        StringTokenizer st;
        FastrReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st==null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}