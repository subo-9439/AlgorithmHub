import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to;
        int weight;
        Edge(int t, int w) { to = t; weight = w; }
    }

    static ArrayList<Edge>[] adj;
    static boolean[] visited;
    static long maxDist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringTokenizer st;

        // 최대 도시 번호 알기 위해 10000 + 여유 준 배열
        int MAX = 10000;
        adj = new ArrayList[MAX + 1];
        for (int i = 1; i <= MAX; i++) {
            adj[i] = new ArrayList<>();
        }

        // 입력: 여러 줄, EOF까지
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[a].add(new Edge(b, w));
            adj[b].add(new Edge(a, w));
        }

        visited = new boolean[MAX + 1];
        // 임의의 노드 하나에서 가장 먼 노드 찾기 -- 시작점은 입력 중 하나가 있는 노드여야 함
        // 여기서는 1부터 MAX까지 탐색하면서 연결이 있는 노드로 시작
        int startNode = -1;
        for (int i = 1; i <= MAX; i++) {
            if (adj[i].size() > 0) {
                startNode = i;
                break;
            }
        }

        if (startNode == -1) {
            System.out.println(0);
            return;
        }

        // 첫 번째 DFS: startNode에서 가장 먼 노드 s 찾기
        // 여기서 maxDist 저장 + 노드 위치 기억
        long distSoFar;
        int farthest = startNode;

        // 내부 DFS 메서드를 여기선 메서드 제거하자는 네 말이니까 익명 호출 방식 + class-level dfs 유지
        maxDist = 0;
        dfs(startNode, 0);
        // visited 상태 배열에서 가장 멀리 간 노드 찾기 via 별도로 추적
        // 하지만 여기선 dfs가 "maxDist"만 저장하므로 dfs 내에 farthest 노드도 추적해야 함
        // 그래서 전역 변수로 farthestNode 추가

        // --- 수정: farthestNode 추가
        // 아래로 코드 좀 수정

        // 리셋 visited
        for (int i = 1; i <= MAX; i++) visited[i] = false;

        // 다음, farthestNode에서 다시 DFS 하여 가장 큰 거리 구함
        // maxDist 초기화
        maxDist = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDist);
    }

    static int farthestNode = -1;

    static void dfs(int node, long dist) {
        visited[node] = true;
        if (dist > maxDist) {
            maxDist = dist;
            farthestNode = node;
        }
        for (Edge e : adj[node]) {
            if (!visited[e.to]) {
                dfs(e.to, dist + e.weight);
            }
        }
    }
}
