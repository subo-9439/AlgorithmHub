import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static int N,X;
    static int[] arr;
    static int[] dp;

    static void input(){
        N = scan.nextInt();
        X = scan.nextInt();
        arr = new int[N+1];
        dp = new int[N+1];
        for (int i = 1; i <= N; i++) { //누적합
            arr[i] = scan.nextInt();
            dp[i] += dp[i-1] + arr[i];
        }


    }
    static void pro(){
        int max = 0;
        int day = 0;
        for (int i = X; i <= N; i++)// 최대 방문자 수 구하기
            max = Math.max(max, dp[i] - dp[i-X]);

        for (int i = X; i <= N; i++) if(max == dp[i] - dp[i-X]) day++;
        if(max == 0) {
            System.out.println("SAD");
            System.exit(0);
        }
        System.out.println(max);
        System.out.println(day);
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
            while (st == null ||!st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine(){
            String str="";
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