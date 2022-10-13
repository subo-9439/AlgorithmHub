import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//    1번 한쪽 방향만
//    2번 감시방향 서로 반대 (두방향),
//    3번 감시방향 지각 (두방향),
//    4번 세방향
//    5번 네방향
//    0은 빈칸 의미,
//    6은 벽,
//    CCTV는 서로 통과할 수 있다.
//    사각지대의 최소 크기를 구하라
public class Main {
    static FastReader scan = new FastReader();
    static int N,M;  //가로, 세로
    static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    static int[][] map;
    static int ans;
    static int[] robotPos;
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        robotPos = new int[3];
        for (int i = 0; i < 3; i++) {
            robotPos[i] = scan.nextInt();
        }
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scan.nextInt();
            }
        }

    }
    public static void main(String[] args) {
        //입력값을 받고
        input();
        //현재 위치를 청소한다.
        clean(robotPos[0],robotPos[1],robotPos[2]);
        //현재위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
        // 왼쪽방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
        // 왼쪽방향에 청소할 공간이 없다면 그방향으로 회전하고 ,(2번으로 돌아간ㄷ) 현재 방향을 기준으로 왼쪽 방향부터 차례대로 탐색을 진행한다.
        // 네방향 모두 청소가 이미되어 있거나 벽인 경우에는
        System.out.println(ans);
    }
    public static void clean(int x, int y, int k){
        if (map[x][y] == 0) {
            map[x][y] = 2; //청소하기
            ans++;
        }
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            int nk = (k+3) % 4;
            int nx = x + dir[nk][0];
            int ny = y +dir[nk][1];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] ==0) {
                flag = true;
                clean(nx,ny,nk);
                break;
            }
            k = nk; // 방향 바꿔주기
        }

        if (!flag){
            int nk = (k +2) % 4;
            int nx = x + dir[nk][0];
            int ny = y + dir[nk][1];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] != 1) {
                clean(nx,ny,k);//방향 유지
            }
        }
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
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