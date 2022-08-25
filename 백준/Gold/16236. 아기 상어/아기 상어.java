import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
     static FastRedaer scan = new FastRedaer();
     static int N;
     static int[][] map;
     static int[][] dir = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
     static int[] sharkPos;
     static void input(){
          N = scan.nextInt();
          map = new int[N][N];
          sharkPos = new int[2];
          for (int i = 0; i < N; i++){
               for (int j = 0; j < N; j++){
                    map[i][j] = scan.nextInt();
                    if (map[i][j] == 9){
                         sharkPos[0] = i;
                         sharkPos[1] = j;
                         map[i][j] = 0;
                    }
               }
          }
     }
     static void pro(){
          int size = 2;
          int eat = 0;
          int move = 0;
          Info info = new Info(sharkPos[0],sharkPos[1],move);
          while (true){
               PriorityQueue<Info> pq = new PriorityQueue<>((o1,o2)-> o1.move!=o2.move?
                       o1.move-o2.move : (o1.x != o2.x ? o1.x-o2.x : o1.y-o2.y));
               boolean[][] visited = new boolean[N][N];
               info.move = 0;
               pq.add(info);
               visited[info.x][info.y] = true;
               boolean flag = false; // 상어가 먹이를 먹었는지 체크

               while (!pq.isEmpty()){
                    info = pq.poll();

                    if (map[info.x][info.y] != 0 && map[info.x][info.y] < size) {
                         map[info.x][info.y] = 0;
                         eat++;//먹은양 증가
                         move += info.move;
                         flag = true;
                         break;
                    }

                    for (int k = 0; k < 4; k++){
                         int nx = info.x + dir[k][0];
                         int ny = info.y + dir[k][1];
                         if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || map[nx][ny] > size)continue;
                         pq.add(new Info(nx,ny, info.move+1));
                         visited[nx][ny] = true;
                    }
               }



               if (!flag) break;

               if (size == eat){
                    size++;
                    eat = 0;
               }
          }
          System.out.println(move);

     }

     public static void main(String[] args) {
          input();
          pro();

     }

     static class Info{
          int x;
          int y;
          int move;
          Info(int x, int y, int move){
               this.x = x;
               this.y = y;
               this.move = move;
          }
     }
     static class FastRedaer{
          BufferedReader br;
          StringTokenizer st;

          FastRedaer() {
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

 