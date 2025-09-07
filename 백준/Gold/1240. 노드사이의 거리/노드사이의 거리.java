import java.io.*;
import java.util.*;

/**
 * BOJ 1240 - 노드사이의 거리
 * 풀이: 트리이므로 임의 두 정점 사이 경로가 유일 -> 질의마다 BFS/DFS로 가중치 합 계산
 * 시간복잡도: O((N + Q) * 평균도수) ~ 실질적으로 O(Q * N) 이하 (N<=~1000 에서 충분)
 */
public class Main {
static List<Edge>[] g;
  static int N, M;

  public static void main(String[] args) throws Exception {
    FastReader scan = new FastReader();
    StringBuilder out = new StringBuilder();

    N = scan.nextInt();
    M = scan.nextInt();

    g = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++)
      g[i] = new ArrayList<>();

    for (int i = 0; i < N - 1; i++) {
      int a = scan.nextInt();
      int b = scan.nextInt();
      int d = scan.nextInt();
      g[a].add(new Edge(b, d));
      g[b].add(new Edge(a, d));
    }

    for (int i = 0; i < M; i++) {
      int u = scan.nextInt();
      int v = scan.nextInt();
      out.append(distBfs(u, v)).append('\n');
    }
    System.out.print(out.toString());
  }

  /** u -> v 까지의 트리 경로 거리 합 (BFS) */
  static int distBfs(int start, int target) {
    boolean[] vis = new boolean[N + 1];
    ArrayDeque<int[]> q = new ArrayDeque<>();
    q.add(new int[] { start, 0 });
    vis[start] = true;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int x = cur[0], acc = cur[1];
      if (x == target)
        return acc;

      for (Edge e : g[x]) {
        if (!vis[e.to]) {
          vis[e.to] = true;
          q.add(new int[] { e.to, acc + e.w });
        }
      }
    }
    return -1;
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
          throw new RuntimeException(e);
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

  static class Edge {
    final int to, w;

    Edge(int to, int w) {
      this.to = to;
      this.w = w;
    }
  }

}
