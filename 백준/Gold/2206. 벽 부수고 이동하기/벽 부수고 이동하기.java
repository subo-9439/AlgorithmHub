import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static int N,M;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] map;
    static boolean[][][] visited;
    //N과M을 받고
    //N번 만큼 map 받기
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            String s = scan.nextLine();
            for (int j = 0; j < M; j++){
                map[i][j] = s.charAt(j)-'0';

            }
        }

    }
    static void pro(){
        Queue<Pos> queue = new LinkedList<>();//포지션의 상태를 넣을 큐 생성
        queue.add(new Pos(0,0,1,false));//시작지점상태 넣기
        int ans = 1000;
        visited[0][0][0] = true;
        while (!queue.isEmpty()){
            Pos cur = queue.poll();
            int root = cur.isBroken? 1:0;

            if (cur.x == N-1 && cur.y == M-1) {
                ans = cur.d;
                break;
            }

            for (int k = 0; k < 4; k++){
                int nx = cur.x + dir[k][0];
                int ny = cur.y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M ) continue;//앞으로 갈방향이 범위를 초과하나
                if (visited[nx][ny][root]) continue;//왔던 지점 확인이니까

                if (map[nx][ny] == 1 ){
                    if (!cur.isBroken){

                        queue.add(new Pos(nx,ny, cur.d +1, true));
                        visited[nx][ny][root] = true;
                    }
                }
//                if (map[nx][ny] == 0){
                else {
                    queue.add(new Pos(nx,ny, cur.d+1, cur.isBroken));
                    visited[nx][ny][root] = true;
                }




            }

        }
        if (ans == 1000) System.out.println(-1);
        else System.out.println(ans);
    }
    public static void main(String[] args) {
        input();
        pro();
    }
    static class Pos{ // 포지션을 담고 있는 정보
        int x;
        int y;
        int d;
        boolean isBroken;
        public Pos(int x,int y, int d,boolean isBroken){
            this.x = x;
            this.y = y;
            this.d = d;
            this.isBroken = isBroken;
        }
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st==null ||!st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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

        int nextInt(){
            return Integer.parseInt(next());
        }

    }
}