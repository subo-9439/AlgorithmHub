import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N;
    static int[][] info;
    static void input(){
        N = scan.nextInt();
        info = new int[N][2];
        for (int i = 0; i < N; i++){
            int start = scan.nextInt();
            int end = scan.nextInt();
            info[i][0] = start;
            info[i][1] = end;
        }
    }
    static void pro() {
        //회의실 배정을 하기 위해선
        //회의가 가장 빨리 끝나는 순으로 배열을 해야한다.
        //끝나는 시점이 같다면 가장 먼저 시작하는 순으로
        // start , end -> 둘다 오름차순
        Arrays.sort(info, (o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        int cur = 0;
        int cnt = 0;
        for (int i = 0 ; i < info.length; i++){
            if (info[i][0] >= cur){
                cnt++;
                cur = info[i][1] ;
            }
        }
        System.out.println(cnt);
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
            while (st==null || !st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        Integer nextInt(){
            return Integer.parseInt(next());
        }
    }
}