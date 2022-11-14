import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Info{
    int time;
    String dir;
    Info(int time, String dir) {
        this.time = time;
        this.dir = dir;
    }
}
class Position{
    int x;
    int y;
    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Snake{
    int x;
    int y;
    int dir;//L2 ,N0 ,R1 ,S3
    Queue<Position> positions = new LinkedList<>();
    Snake(int x,int y) {
        this.x = x;
        this.y = y;
        this.dir = 1;
        positions.add(new Position(1,1));
    }
}
public class Main {
    static FastReader scan = new FastReader();
    static int N,K,L,time;
    static int[][] map;
    static boolean flag = true;
    static Snake snake = new Snake(1,1);
    static HashMap<Integer,String> moveInfo = new HashMap<>();
    static void input(){
        N = scan.nextInt();//보드 크기
        K = scan.nextInt();//사과 개수
        map = new int[N+1][N+1];
        map[1][1] = 2;
        for (int k = 0; k < K; k++) {
            //다음 K개의 줄에 사과의 위치가 주어진다. 행 열 (맨위 맨좌측에는 사과가 없다.
            int x = scan.nextInt();
            int y = scan.nextInt();
            map[x][y] = 1;//사과

        }
        //다음 줄에는 뱀의 방향 변환 횟수 L
        L = scan.nextInt();
        for (int l = 0; l < L; l++) {
            //L개의 줄에는 정수 X와 C로 X초뒤에 왼쪽L 오른족 D로 90도 회전 시킨다. X가 오름차순으로 주어진다.
            moveInfo.put(scan.nextInt(),scan.next());
        }
    }
    static void printss(){
        System.out.println(snake.positions.size());
        for (int r = 1; r <= N; r++){
            for (int c = 1; c <= N; c++) {

                System.out.print(map[r][c]);
            }
            System.out.println();
        }
    }
    static void pro() {
        time++;
        if(snake.dir==1){//오
            snake.y+=1;
        }else if(snake.dir==2){//아
            snake.x+=1;
        }else if (snake.dir==3){//왼
            snake.y-=1;
        }else {//왼
            snake.x-=1;
        }
        if (isFinished()){
            flag = false;
        }else {
            appleMove(snake.x, snake.y);
        }
        if (flag){
            changeDir(time);
        }
//        printss();

    }
    static boolean isFinished(){
        if (snake.x < 1|| snake.y <1 || snake.x>N || snake.y > N){
            return true;
        }
        return map[snake.x][snake.y] == 2;
    }
    private static void appleMove(int x, int y) {

        if (map[x][y] == 0) {//사과가 없다면
            Position tail = snake.positions.poll();//꼬리삭제
            map[tail.x][tail.y] = 0;
        }
            map[x][y] = 2;//뱀이동
            snake.positions.add(new Position(x, y));

    }
    private static void changeDir(int curTime) {
//        System.out.println(curTime);
        if(moveInfo.containsKey(curTime)){
            String dir = moveInfo.get(curTime);
            if (dir.equals("D")) {
                snake.dir = (snake.dir+1)%4;
            }else {
                snake.dir = (snake.dir-1+4)%4;
//                System.out.println("왼족일때" +snake.dir);
            }
        }
    }

    public static void main(String[] args) {
        input();
        while (flag){
            pro();
        }
        int[] a = new int[5];
        System.out.println(time);
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
        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}