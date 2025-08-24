import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int n, q;
    static int[] arr;

    public static void main(String[] args) {
        n = sc.nextInt();
        q = sc.nextInt();
        arr = new int[n + 1];

        // 가고 싶은 땅 정리
        for (int i = 1; i <= q; i++) {
            int val = sc.nextInt(); // 2
            if (arr[val] == 0) {
                sb.append(0).append("\n");

                dfs(val, val);
            } else {
                sb.append(arr[val]).append("\n");
            }
        }

        System.out.print(sb.toString());
    }

    static void dfs(int start, int val) {
        arr[start] = val;

        int left = 2 * start;
        int right = 2 * start + 1;

        if (left <= n) {
            arr[left] = val;
            dfs(left, val);
        }

        if (right <= n) {
            arr[right] = val;
            dfs(right, val);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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