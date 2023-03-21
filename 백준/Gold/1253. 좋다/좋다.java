import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N;
    static int[] arr;

    public static void main(String[] args) {
        N = scan.nextInt();
        arr = new int[N];


        for (int i = 0; i < N; i++)
            arr[i] = scan.nextInt();

        Arrays.sort(arr);

        int count = 0;

        for (int k = 0; k < N; k++) {
            int find = arr[k];
            int leftIdx = 0;
            int rightIdx = N-1;

            while (leftIdx < rightIdx) {
                int sum = arr[leftIdx] + arr[rightIdx];
                if (sum == find) {
                    if (leftIdx != k && rightIdx != k){
                        count++;
                        break;
                    }else if(leftIdx == k) {
                        leftIdx++;
                    }else {
                        rightIdx--;
                    }
                }else if (sum > find) {
                    rightIdx--;
                }else {
                    leftIdx++;
                }
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