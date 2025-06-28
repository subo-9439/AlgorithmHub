import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static int N, R;
    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int gigaNode = -1;
    static long pillarLength = 0;
    static long maxBranchLength = 0;

    static class Node {
        int to, weight;
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        N = scan.nextInt();
        R = scan.nextInt();
        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            int w = scan.nextInt();
            tree[u].add(new Node(v, w));
            tree[v].add(new Node(u, w));
        }

        findGigaNodeAndPillar();
        visited[gigaNode] = true;
        findMaxBranch(gigaNode, 0);

        System.out.println(pillarLength + " " + maxBranchLength);
    }

    static void findGigaNodeAndPillar() {
        int now = R;
        visited[now] = true;

        while (true) {
            if ((now == R && tree[now].size() >= 2) || (now != R && tree[now].size() >= 3)) {
                gigaNode = now;
                break;
            }

            boolean moved = false;
            for (Node next : tree[now]) {
                if (!visited[next.to]) {
                    pillarLength += next.weight;
                    visited[next.to] = true;
                    now = next.to;
                    moved = true;
                    break;
                }
            }

            if (!moved) {
                // 더 이상 갈 곳 없음 = 리프노드
                gigaNode = now;
                break;
            }
        }
    }

    static void findMaxBranch(int now, long length) {
        boolean isLeaf = true;
        for (Node next : tree[now]) {
            if (!visited[next.to]) {
                visited[next.to] = true;
                isLeaf = false;
                findMaxBranch(next.to, length + next.weight);
            }
        }
        if (isLeaf) {
            maxBranchLength = Math.max(maxBranchLength, length);
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
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
    }
}
