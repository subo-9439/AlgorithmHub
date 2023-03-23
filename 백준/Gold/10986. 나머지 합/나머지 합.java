import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N, M;
    static long[] arr , nums;
    static long answer;
    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new long[N];
        nums = new long[M]; //idx 나머지 크기, val 개수
        arr[0] = scan.nextInt() % M;
        if (arr[0] == 0) {
            answer++;
        }
        nums[(int) arr[0]]++;

        for (int i = 1; i < N; i++) {
            arr[i] = (arr[i-1]  + (scan.nextInt() % M) ) % M;
            if (arr[i] == 0) answer++;
            nums[(int) arr[i]]++;
        }
    }
    public static void main(String[] args) {
        input();

        //나머지가 있던 숫자들에 대해서 조합찾기
        for (int i = 0; i < M; i++) {
//            System.out.println("idx = " + i + " nums" + nums[i]);
            if (nums[i] != 0) {
//                System.out.println(nums[i]);
                answer += nums[i] * (nums[i]-1)/2;
            }
        }
        System.out.println(answer);
    }
    static class FastReader {
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
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}