import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static int N;
    static Integer[] arr;

    public static void main(String[] args) {
        input();
        long sum = 0;
        for (int i = 0; i < N; i++) {
            int sub = arr[i] - i;
            if (sub < 0) break;
            sum += sub;
        }
        System.out.println(sum);
    }
    private static void input() {
        N = scan.nextInt();
        arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null || !st.hasMoreTokens()) {
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