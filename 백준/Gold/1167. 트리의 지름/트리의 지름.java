import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int idx;
    int weight;
    Node(int idx, int weight) {
        this.idx = idx;
        this.weight = weight;
    }
}
class Info implements Comparable<Info>{
    int idx;
    int dist;
    Info(int idx, int dist) {
        this.idx = idx;
        this.dist = dist;
    }

    @Override
    public int compareTo(Info o) {
        return this.dist-o.dist;
    }
}
public class Main {
    static FastReader scan = new FastReader();
    static int V;
    static ArrayList<Node>[] nodes;
    static void input() {
        V = scan.nextInt();
        nodes = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) nodes[i] = new ArrayList<>();
        for (int i = 1; i <= V; i++){
            int nodeNum = scan.nextInt();
            while (true) {
                int idx = scan.nextInt();
                if (idx == -1) break;
                int dist = scan.nextInt();

                nodes[nodeNum].add(new Node(idx,dist));
            }
        }
    }
    static void pro() {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V+1];
        int[] dist = new int[V+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        int idx = dijkstra(1);
        pq.add(new Info(idx,0));
        visited[idx] = true;
        dist[idx] = 0;
        while (!pq.isEmpty()){
            Info info = pq.poll();
            if (dist[info.idx] != info.dist) continue;
            for (Node next : nodes[info.idx]) {
                if (visited[next.idx]) continue;
                if (info.dist + next.weight < dist[next.idx]) {
                    dist[next.idx] = info.dist + next.weight;
                    visited[next.idx] = true;
                    pq.add(new Info(next.idx, dist[next.idx]));
                }
            }
        }
        int max = 0;
        for (int i =1; i <= V; i++) {
            max = Math.max(dist[i],max);
        }
        System.out.println(max);

    }
    static int dijkstra(int idx) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V+1];
        int[] dist = new int[V+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        pq.add(new Info(idx,0));
        visited[idx] = true;
        dist[idx] = 0;
        while (!pq.isEmpty()){
            Info info = pq.poll();
            if (dist[info.idx] != info.dist) continue;
            for (Node next : nodes[info.idx]) {
                if (visited[next.idx]) continue;
                if (info.dist + next.weight < dist[next.idx]) {
                    dist[next.idx] = info.dist + next.weight;
                    visited[next.idx] = true;
                    pq.add(new Info(next.idx, dist[next.idx]));
                }
            }
        }
        int max = 0;
        int node = 0;
        for (int i = 1; i <= V; i++){
            if (dist[i] > max) {
                node = i;
                max = dist[i];
            }
        }
        return node;
    }
    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
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