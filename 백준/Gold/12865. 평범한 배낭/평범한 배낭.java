import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static int N, K;
    static int[] weightArr = new int[101];
    static int[] valueArr = new int[101];

    public static void main(String[] args) {
        input();
        //dp는 무게일 떄 최대가치
        //첫번째 물건을 넣을지 말지 만  을 넣을지 7(3을 포함하는 경우와 아닌 경우) 을 넣을지
        int[] dp = new int[100001];


        for (int i = 1; i <= N; i++){
            for (int k = K; k > 0; k--) {
                if (weightArr[i] <= k){
                    dp[k] = Math.max(dp[k], dp[k-weightArr[i]] + valueArr[i]);
                }
            }
        }
        System.out.println(dp[K]);
        //i = 1 k = 7
    }

    private static void input() {
        N = scan.nextInt(); K = scan.nextInt();
        for (int i = 1; i <= N; i++){
            weightArr[i] = scan.nextInt();
            valueArr[i] = scan.nextInt();
        }
    }




    public static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e) {
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