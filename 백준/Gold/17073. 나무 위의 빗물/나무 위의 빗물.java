import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static FastReader scan = new FastReader();
  static ArrayList<Integer>[] edgeLists;

  public static void main(String[] args) {
    int n = scan.nextInt();
    int w = scan.nextInt();
    edgeLists = new ArrayList[n + 1];

    for (int i = 1; i <= n; i++) {
      edgeLists[i] = new ArrayList<>();
    }

    for (int i = 1; i <= n-1; i++) {
      int node1 = scan.nextInt();
      int node2 = scan.nextInt();
      edgeLists[node1].add(node2);
      edgeLists[node2].add(node1);
    }

    int leafNodeCnt = 0;
    for (int i = 2; i <= n; i++) {
      if (edgeLists[i].size() == 1) {
        leafNodeCnt++;
      }
    }
    System.out.println((double) w / leafNodeCnt);

  }

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreTokens()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (Exception e) {
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
