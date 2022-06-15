import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N;
    static int[][] map;

    //1,2,7,10,5, a
    static int[][] west = {{-1,1},{1,1},{-2,0},{2,0},{-1,0},{1,0},{-1,-1},{1,-1},{0,-2},{0, -1}};
    static int[][] east = {{-1,-1},{1,-1},{-2,0},{2,0},{-1,0},{1,0},{-1,1},{1,1},{0,2},{0,1}};
    static int[][] north ={{1,-1},{1,1},{0,-2},{0,2},{0,1},{0,-1},{-1,-1},{-1,1},{-2,0},{-1,0}};
    static int[][] south ={{-1,-1},{-1,1},{0,-2},{0,2},{0,-1},{0,1},{1,-1},{1,1},{2,0},{1,0}};
    static double[] ratio = {0.01,0.01,0.02,0.02,0.07,0.07,0.1,0.1,0.05,0.55};
    static int sum;
    static void input(){
        N = scan.nextInt();
        map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= N; j++){
                map[i][j] = scan.nextInt();
                sum+=map[i][j];
            }
        }
    }
    static void pro(){
        //격자 가운데
        int x = (N+1)/2, y = (N+1)/2;
        int cnt = 0 ;
        boolean flag = true;
        while (flag){
            cnt++;
            for (int i = 0; i < cnt; i++){
                y -=1;
                sandWind( x, y,'L');
                if(x == 1 && y == 1) {
                    flag = false;
                    break;
                }
            }
            if(!flag) break;
            for (int i = 0; i < cnt; i++){
                x += 1;
                sandWind(x,y,'D');
            }
            cnt++;
            for (int i = 0; i < cnt; i++){
                y += 1;
                sandWind(x,y,'R');
            }
            for (int i = 0; i < cnt; i++){
                x -= 1;
                sandWind(x,y,'U');
            }
        }
//        for (int k = 1; k <= N; k++){
//            for (int j = 1; j <= N; j++){
//                System.out.print(map[k][j]+" ");
//            }
//            System.out.println();
//        }
        int s = 0;
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= N; j++){
                s+= map[i][j];
            }
        }
        System.out.println(sum-s);
    }
    static void sandWind(int x, int y, char dir){
        //이동한 지점과 방향이 나옴

        if (dir == 'L'){
            int s = 0;
            for (int k = 0 ; k < 10; k++){
                int nx = x +west[k][0];
                int ny = y +west[k][1];
                if(nx <= 0 || ny <= 0 || nx > N || ny > N) {
                    s += (int)(map[x][y]*ratio[k]);
                    continue;
                }
                if(k==9){
                    map[nx][ny] += map[x][y] - s;
                }else {
                    s += (int)(map[x][y]*ratio[k]);
                    map[nx][ny] += (int)(map[x][y]*ratio[k]);
                }
            }
        }
        if (dir == 'D'){
            int s = 0;
            for (int k = 0 ; k < 10; k++){
                int nx = x +south[k][0];
                int ny = y +south[k][1];
                if(nx <= 0 || ny <= 0 || nx > N || ny > N) {
                    s += (int)(map[x][y]*ratio[k]);
                    continue;
                }
                if(k==9){
                    map[nx][ny] += map[x][y] - s;
                }else {
                    s += (int)(map[x][y]*ratio[k]);
                    map[nx][ny] += (int)(map[x][y]*ratio[k]);
                }
            }
        }
        if (dir == 'R'){
            int s = 0;
            for (int k = 0 ; k < 10; k++){
                int nx = x +east[k][0];
                int ny = y +east[k][1];
                if(nx <= 0 || ny <= 0 || nx > N || ny > N) {
                    s += (int)(map[x][y]*ratio[k]);
                    continue;
                }
                if(k==9){
                    map[nx][ny] += map[x][y] - s;
                }else {
                    s += (int)(map[x][y]*ratio[k]);
                    map[nx][ny] += (int)(map[x][y]*ratio[k]);
                }
            }
        }
        if (dir == 'U'){
            int s = 0;
            for (int k = 0 ; k < 10; k++){
                int nx = x +north[k][0];
                int ny = y +north[k][1];
                if(nx <= 0 || ny <= 0 || nx > N || ny > N) {
                    s += (int)(map[x][y]*ratio[k]);
                    continue;
                }
                if(k==9){
                    map[nx][ny] += map[x][y] - s;
                }else {
                    s += (int)(map[x][y]*ratio[k]);
                    map[nx][ny] += (int)(map[x][y]*ratio[k]);
                }
            }
        }
        map[x][y] = 0;
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
        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
