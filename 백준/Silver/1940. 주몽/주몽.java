import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N, M;
    static int[] arr;
    public static void main(String[] args) {
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = scan.nextInt();

        Arrays.sort(arr);

        //M이 되어야 한다.
        int leftIdx = 0, rightIdx = N-1;
        int count = 0;

        while (leftIdx < rightIdx) {

            int sum = arr[leftIdx] + arr[rightIdx];

            if (sum == M) {
                leftIdx++;
                rightIdx--;
                count++;
            }else if(sum < M) {
                leftIdx++;
            }else {
                rightIdx--;
            }

        }
        System.out.println(count);
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
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

    }
}