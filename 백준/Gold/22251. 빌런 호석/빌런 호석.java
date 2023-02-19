import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N, K, P, X;
    static int[][] led = { //led세팅하기 |부터 시작해서시계방향으로 기록 on = 1 off = 0 가운데는 6번인덱스
            {1, 1, 1, 1, 1, 1, 0},//0
            {1, 1, 0, 0, 0, 0, 0},//1
            {1, 0, 1, 1, 0, 1, 1},//2
            {1, 1, 1, 0, 0, 1, 1},//3
            {1, 1, 0, 0, 1, 0, 1},//4
            {0, 1, 1, 0, 1, 1, 1},//5
            {0, 1, 1, 1, 1, 1, 1},//6
            {1, 1, 0, 0, 0, 1, 0},//7
            {1, 1, 1, 1, 1, 1, 1},//8
            {1, 1, 1, 0, 1, 1, 1},//9
    };
    static int ans = 0;
    public static void main(String[] args) {
        input();
        int[] stopDigit = numToDigit(X);
        for (int i = 1; i <= N; i++) {
            if(i==X) continue;
            int[] curDigit = numToDigit(i);
            if (canChange(curDigit,stopDigit)){
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static boolean canChange(int[] curDigit,int[] stopDigit) {
        int cnt = 0;
        for (int i = 0; i < K; i++){
            for (int j = 0; j < 7; j++) {
                if (led[curDigit[i]][j] != led[stopDigit[i]][j]){
                    cnt++;
                }
                if (cnt > P) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] numToDigit(int num) {
        int[] result = new int[K];
        for (int i = K-1; i >= 0; i--) {
            result[i] = num%10;
            num/=10;
        }
        return result;
    }

    private static void input() {
        N = scan.nextInt(); //1부터 N층까지 이용가능 1 <= X <= N < 10^K
        K = scan.nextInt(); //자리수 1<= K <= 6
        P = scan.nextInt(); //최대 반전 시킬 LED 개수 1<= P <= 42
        X = scan.nextInt(); //멈춘 층

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