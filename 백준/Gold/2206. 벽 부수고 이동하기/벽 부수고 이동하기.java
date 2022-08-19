import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N,M;
    static String[] map;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static boolean[][][] isVisit;
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        map = new String[N];
        isVisit = new boolean[N][M][2];
        for (int i = 0; i < map.length; i++) {
            map[i] = scan.nextLine();
        }
    }
    public static void main(String[] args) {
        input();
        pro();
    }
    static void pro(){
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0,0,1,false));
        int ans = 1000;
        while (!queue.isEmpty()){
            Pos cur = queue.poll();
            if (cur.x == N-1 && cur.y == M-1){
                ans = cur.dist;
                break;
            }

            for (int k = 0; k < 4; k++){
                int nx = cur.x + dir[k][0];

                int ny = cur.y + dir[k][1];
                int root = cur.isBroken ? 1: 0;

                if (nx < 0 || ny <0 || nx>= N || ny >= M) continue;
                if (isVisit[nx][ny][root]) continue;
                if (map[nx].charAt(ny) == '1'){
                    if (!cur.isBroken){//벽부수기 사용한적이 없으면 갈 수 있다.
                        queue.add(new Pos(nx,ny, cur.dist+1,true));//벽부순거 표시
                        isVisit[nx][ny][root] = true;

                    }
                }else {
                    queue.add(new Pos(nx,ny, cur.dist+1, cur.isBroken));//그대로 상태 들고가기
                    isVisit[nx][ny][root] = true;

                }

            }

        }
        if (ans == 1000) System.out.println(-1);
        else System.out.println(ans);
    }
    static class Pos{
        int x;
        int y;
        int dist;
        boolean isBroken;
        public Pos(int x,int y,int dist,boolean isBroekn){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.isBroken = isBroekn;
        }
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st == null || !st.hasMoreElements()){
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