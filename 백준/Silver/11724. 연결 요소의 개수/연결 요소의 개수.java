import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static boolean[] isVistied;
    static List<Integer>[] map;
    static int count = 0;

    public static void main(String[] args) {
        int node = scan.nextInt();
        int edge = scan.nextInt();
        isVistied = new boolean[node + 1];
        map = new ArrayList[node + 1];
        for (int i = 1; i <= node; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            map[from].add(to);
            map[to].add(from);
        }

        for (int i = 1; i <= node; i++) {
            if (isVistied[i]) {
                continue;
            } else {
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    static void dfs(int curNode) {
        isVistied[curNode] = true;

        for (Integer nextNode : map[curNode]) {
            if (isVistied[nextNode]) {
                continue;
            } else {
                dfs(nextNode);
            }
        }

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
                } catch (IOException e) {
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