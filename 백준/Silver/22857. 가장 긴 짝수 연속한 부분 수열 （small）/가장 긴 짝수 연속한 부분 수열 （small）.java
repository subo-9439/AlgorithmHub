import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        int N = scan.nextInt();
        int K = scan.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }

        //K만큼뺴고 작수로 이루어져 있는 연속한 부분 찾기 -> 홀수가 K번만큼 포함돼도 괜찮다.
        int L = 0, R = 0, maxEvenCnt = 0;
        int evenCnt =  arr[R] % 2 == 0? 1 : 0,   oddCnt = 1 -evenCnt;
        maxEvenCnt = evenCnt;
        R++;
        while (L <= R) {
            if(R == N) break;
            if(arr[R] % 2 == 0) {
                evenCnt++;
            }
            else {
                // System.err.println("\n| " + "개수세기전 oddCnt" + oddCnt + "|");
                if(oddCnt >= K) {
                    if(arr[L] % 2 == 0) evenCnt--;
                    else oddCnt--;
                    L++;
                    continue;
                }
                oddCnt++;
            }
            // System.err.println("왼쪽" + arr[L] +"오른쪽" + arr[R] + "  짝스 :" + evenCnt + " 홀수 : " + oddCnt);
            maxEvenCnt = Math.max(maxEvenCnt, evenCnt);
            R++;
        }
        System.out.println(maxEvenCnt);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st==null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
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