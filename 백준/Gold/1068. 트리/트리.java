import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static FastReader scan;
  static ArrayList<Integer>[] childOf;
  static boolean[] isVisited;

  // 부모의 자식들을 기록하는 배열생성.
  // 이후 제거해야할 노드를 선택하면, 그 노드의 부모의 자식들을 돌면서 리프노트갯수 세기.
  public static void main(String[] args) {
    scan = new FastReader();
    int n = scan.nextInt();
    childOf = new ArrayList[n];
    isVisited = new boolean[n];

    // 초기화
    for (int i = 0; i < n; i++) {
      childOf[i] = new ArrayList<>();
    }
    // root 및 기록
    int root = -1;
    for (int i = 0; i < n; i++) {
      int parent = scan.nextInt();
      if (parent == -1) {
        root = i;
      } else {
        childOf[parent].add(i);
      }
    }

    int removeNode = scan.nextInt();
    Queue<Integer> queue = new LinkedList<>();
    if (root == removeNode) {
      System.out.println(0);
      return;
    }
    queue.add(root);
    int answer = 0;
    isVisited[removeNode] = true;

    while (!queue.isEmpty()) {
      int node = queue.poll();
      ArrayList<Integer> children = childOf[node];

      boolean hasLiveChild = false;
      for (int child : children) {
        if (!isVisited[child]) {
          queue.add(child);
          hasLiveChild = true;
        }
      }

      if (!hasLiveChild) {
        answer++; // 모든 자식이 제거된 경우도 리프 노드처럼 간주
      }
    }
    System.out.println(answer);

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
