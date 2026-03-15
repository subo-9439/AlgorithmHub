import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/* BOJ 13271 스파이 */
/**
 * 입력 조건을 모두 difference constraints(차분 제약식) 형태로 바꿔
 * Bellman-Ford로 모순 여부(음수 사이클)와 최소 점수 폭을 구한다.
 *
 * [type 1]
 * 1 a b c : score[a] - score[b] >= c
 * : score[b] - score[a] <= -c
 * : score[b] <= score[a] + (-c)
 * : 간선 a -> b, cost = -c
 *
 * [type 2]
 * 2 a b c : score[a] - score[b] <= c
 * : score[a] <= score[b] + c
 * : 간선 b -> a, cost = c
 *
 * [type 3]
 * 3 a b c : score[a] - score[b] = c
 * : score[a] - score[b] <= c
 * : score[a] - score[b] >= c
 * : 간선 b -> a, cost = c
 * : 간선 a -> b, cost = -c
 *
 * [score 범위]
 * 각 제품 평점은 0 <= score[i] <= 100
 * 가상 정점 0을 두고 score[0] = 0 으로 보면
 *
 * score[i] <= 100 -> score[i] - score[0] <= 100 -> 간선 0 -> i, cost = 100
 * score[i] >= 0 -> score[0] - score[i] <= 0 -> 간선 i -> 0, cost = 0
 */
public class Main {
  static FastReader scan = new FastReader();

  public static void main(String[] args) {
    int n = scan.nextInt();
    int k = scan.nextInt();

    ArrayList<Edge> edges = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      edges.add(new Edge(0, i, 100));
      edges.add(new Edge(i, 0, 0));
    }

    for (int i = 0; i < k; i++) {
      int type = scan.nextInt();
      int a = scan.nextInt();
      int b = scan.nextInt();
      int cost = scan.nextInt();

      if (type == 1) {
        edges.add(new Edge(a, b, -cost));
      } else if (type == 2) {
        edges.add(new Edge(b, a, cost));
      } else {
        edges.add(new Edge(b, a, cost));
        edges.add(new Edge(a, b, -cost));
      }
    }

    long INF = 1_000_000_000L;
    long[] dist = new long[n + 1];
    Arrays.fill(dist, INF);
    dist[0] = 0;

    for (int i = 0; i < n; i++) {
      boolean updated = false;

      for (Edge edge : edges) {
        if (dist[edge.from] == INF)
          continue;

        long next = dist[edge.from] + edge.cost;
        if (dist[edge.to] > next) {
          dist[edge.to] = next;
          updated = true;
        }
      }

      if (!updated)
        break;
    }

    for (Edge edge : edges) {
      if (dist[edge.from] == INF)
        continue;

      long next = dist[edge.from] + edge.cost;
      if (dist[edge.to] > next) {
        System.out.println(-1);
        return;
      }
    }

    long minValue = 100;
    for (int i = 1; i <= n; i++) {
      minValue = Math.min(minValue, dist[i]);
    }

    System.out.println(100 - minValue);
  } // main 끝

  static class Edge {
    int from;
    int to;
    int cost;

    Edge(int from, int to, int cost) {
      this.from = from;
      this.to = to;
      this.cost = cost;
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
          throw new RuntimeException(e);
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }
  }
}