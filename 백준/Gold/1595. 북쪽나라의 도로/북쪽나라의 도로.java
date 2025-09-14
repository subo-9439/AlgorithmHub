/*
 * BOJ 1595 - 북쪽나라의 도로
 * https://www.acmicpc.net/problem/1595
 *
 * 풀이 방식:
 * - 입력을 EOF까지 읽어 무향 그래프(가중치) 구성
 * - 트리 지름 알고리즘 사용 (DFS 2번):
 *   1) 임의의 노드에서 가장 먼 노드를 찾는다
 *   2) 그 노드에서 다시 DFS하여 최대 거리(지름)를 구한다
 */

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
    static int farthestNode = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringTokenizer st;

        int MAX = 10000;
        adj = new ArrayList[MAX + 1];
        for (int i = 1; i <= MAX; i++) {
            adj[i] = new ArrayList<>();
        }

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
        int startNode = -1;
        for (int i = 1; i <= MAX; i++) {
            if (!adj[i].isEmpty()) {
                startNode = i;
                break;
            }
        }

        if (startNode == -1) {
            System.out.println(0);
            return;
        }

        maxDist = 0;
        dfs(startNode, 0);

        Arrays.fill(visited, false);
        maxDist = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDist);
    }

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
