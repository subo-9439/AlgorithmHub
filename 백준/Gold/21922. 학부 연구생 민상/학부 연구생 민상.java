import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N,M;
    static int[][] map, answer;
    static int[][] nDir = {{-1, 0}, {1,0}, {0,-1}, {0,1} }; //상 하 좌 우
    static List<Position> startPoint = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N+1][M+1];
        answer = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 9) {//에어컨위치
                    startPoint.add(new Position(i, j));
                } 
            }
        }

        for(Position position : startPoint){
            int x = position.x, y = position.y;
            for(int k = 0; k < 4; k++){
                answer[x][y] = 1;
                recursion(x, y, k);
            }
        }
        // print();
        printCnt();

    }
    static void recursion(int x, int y, int dir) {
        int nx = x + nDir[dir][0];
        int ny = y + nDir[dir][1];
        if(nx < 1 || ny <1 || nx > N || ny > M) return;
        answer[nx][ny] = 1;
        if(map[nx][ny] == 1) {
            if(dir == 0 || dir == 1) recursion(nx, ny, dir); //그대로
            else if(dir == 2 || dir == 3) return; 
        }else if(map[nx][ny] == 2) {
            if(dir == 2 || dir == 3) recursion(nx, ny, dir); //그대로
            else if(dir == 0 || dir == 1) return;
        }else if(map[nx][ny] == 3) {                        
            if(dir == 0) recursion(nx, ny, 3);       //dir 0 아래에서 위로온경우  우
            else if(dir == 1) recursion(nx, ny, 2);  //dir 1 위에서 아래로온경우  좌
            else if(dir == 2) recursion(nx, ny, 1);  //dir 2 우에서 좌로온경우 하
            else if(dir == 3) recursion(nx, ny, 0);  //dir 3 좌에서 우로온경우 상
        }else if(map[nx][ny] == 4) {
            if(dir == 0) recursion(nx, ny, 2);       //좌
            else if(dir == 1) recursion(nx, ny, 3);  //우
            else if(dir == 2) recursion(nx, ny, 0);  //상
            else if(dir == 3) recursion(nx, ny, 1);  //하
        }else if(map[nx][ny] == 9) {
            return;
        }else {
            recursion(nx, ny, dir);
        }
            //1 번일떄 상하로들어오면 y축이다르고 x축이 같으면 그대로 통과
            //1 번일때 좌 -> 우 y그대로 x 감소방향
            //1 번일때 우 -> 좌 y그대로 x 증가방향
            

            //2번일떄, 상하로 들어오면 x그대로 y왔던거에서 반대방햐으로
            //2번일때, 상 -> 하 x그대로 y 감소
            //2번일때, 하 -> 상 x그대로 y 증가

            //3번일때, 좌 -> 우 해당지점에서 x그대로 y 감소방향으로
            //3번일떄, 상 -> 하 해당지점에서 y그대로 x 감소방향으로
            //3번일때, 우 -> 좌 해당지점에서 x그대로 y 증가방향으로
            //3번일때, 하 -> 상 해당지점에서 y그대로 x 증가방향으로
            
            //4번일때, 좌 -> 우 해당지점에서 x그대로 y 증가방향으로
            //4번일떄, 상 -> 하 해당지점에서 y그대로 x 증가방향으로
            //4번일때, 우 -> 좌 해당지점에서 x그대로 y 감소방향으로
            //4번일때, 하 -> 상 해당지점에서 y그대로 x 감소방향으로
    }
    private static void printCnt() {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(answer[i][j] == 1) cnt++;
            }
        }
        System.out.println(cnt);
    }
    static void print(){
        System.out.println("======================================================");
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sb.append(answer[i][j]);
                if(j != M) {
                    sb.append(" ");
                }
            }
            if(i != N) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    static class Position {
        int x;
        int y;
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
