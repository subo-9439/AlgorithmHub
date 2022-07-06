import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N,M,B;
    static int[][] map;

    static int max = 0;
    static int min = 257;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        B = scan.nextInt();
        map = new int[N][M];
        for (int i = 0 ; i < N; i++){
            for (int j = 0; j < M; j++){
                map[i][j] = scan.nextInt();
                max = Math.max(max,map[i][j]);
                min = Math.min(min,map[i][j]);
            }
        }
    }
    static void pro(){
        int timeAns = Integer.MAX_VALUE;
        int height = 0;
        for (int h = min; h <= max; h++){
            int blocks = B; //인벤토리에 있는 블록의 개수
            int time = 0;   //블록의 높이가 h일 때 소요되는 시간
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    if(map[i][j] > h){      //블록 제거는 2초
                        time += (map[i][j] - h) * 2;
                        blocks += (map[i][j] - h);
                    }else  if (map[i][j] < h) {//블록 생성은 1초
                        time += (h - map[i][j] );
                        blocks -= (h - map[i][j]);
                    }
                }
            }
            if (time <= timeAns && blocks >= 0){    //시간이 같을땐 높이가 높은 애들이 저장된다.
                timeAns = time;
                height = h;
            }

        }
        System.out.println(timeAns+" "+ height);
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