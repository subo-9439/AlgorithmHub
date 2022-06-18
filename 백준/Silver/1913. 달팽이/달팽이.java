import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, pos;
    static int[][] map;
    static void input(){
        N = scan.nextInt();
        pos = scan.nextInt();
        map = new int[N+1][N+1];
    }
    //위 오른 (횟수증가) 아래 왼 (횟수증가)
    static void pro(){
        int x = (N+1)/2, y = (N+1)/2;

        int cnt = 1, val = 0; // cnt(횟수), val(값)
        boolean flag = true;

        map[x][y] = ++val;
        while (flag){
            //위쪽 x방향 감소
            for (int i = 0 ; i < cnt; i++){
                map[--x][y] = ++val;
                if(x == 1 && y == 1) flag= false;   //탈출조건
            }
            if(!flag)break; //탈출

            //오른쪽 y방향 증가
            for (int i = 0 ; i < cnt; i++){
                map[x][++y] = ++val;
            }
            cnt++;
            // 아래쪽 x방향 증가
            for (int i = 0; i < cnt; i++){
                map[++x][y] = ++val;
            }
            //왼쪽 y방향 감소
            for (int i = 0; i < cnt; i++){
                map[x][--y] = ++val;
            }
            cnt++;
        }

        //출력
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= N; j++){
                int res = map[i][j];
                sb.append(res).append(" ");
                if(res == pos) {
                    x = i;
                    y = j;
                }
            }
            sb.append("\n");
        }
        sb.append(x).append(" ").append(y);
        System.out.println(sb.toString());
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