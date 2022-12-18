import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N, L, R;
    static int population;
    static ArrayList<Position> positions;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] map;
    static boolean[][] isVisited;
    static class Position{
        int r;
        int c;
        Position(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static void input() {
        N = scan.nextInt();
        L = scan.nextInt();
        R = scan.nextInt();

        map = new int[N][N];
        for (int r = 0; r < N; r++)
            for (int c = 0; c < N; c++)
                map[r][c] = scan.nextInt();
    }
    static void dfs(int r, int c) {
        //방문하면서 합도 더하고포지션기록
        isVisited[r][c] = true;
        population += map[r][c];
        positions.add(new Position(r,c));

        for (int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if (canVisit(nr,nc) && isIn(r,c,nr,nc)) {
                dfs(nr,nc);
            }
        }


    }
    static boolean isIn(int r, int c, int nr, int nc) {
       return Math.abs(map[nr][nc] - map[r][c] ) >= L && Math.abs(map[nr][nc] - map[r][c] ) <= R;
    }
    static boolean canVisit(int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= N) return false;
        return !isVisited[r][c];
    }
    public static void main(String[] args) {
        input();

        boolean canMove = true;
        int day = 0;
        //인구이동이 가능할 때
        while (canMove) {
            canMove = false;
            isVisited = new boolean[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c< N; c++) {
                    population = 0;
                    positions = new ArrayList<>();
                    if (isVisited[r][c]) continue;
                    dfs(r,c);
                    //여기서 생각을 못했네
                    //canMove true조건은 move가 될 수 있을 때 판단
                    // move는 positions에 2개이상 들어가면 움직일 수 있음(자기자신이 카운트 1로 들어감)
                    if (positions.size() >= 2){
                        move();
                        canMove = true; // 한번이라도 인구 이동 발생하면 true
                    }
                }
            }
            if (canMove)
                day++;
        }
        System.out.println(day);
    }
    static void move(){
        //인구수 분배 소수점 버림 -> int형 사용
        for (Position pos : positions) {
            map[pos.r][pos.c] = population / positions.size();
        }
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
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