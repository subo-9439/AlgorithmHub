import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    int to;
    int weight;
    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.to- o.to;
    }
}
class Info{
    int idx;
    int dist;
    Info(int idx, int dist) {
        this.idx = idx;
        this.dist = dist;
    }
}
public class Main {
    static FastReader scan = new FastReader();
    static int N,E;
    static ArrayList<Edge>[] edges;
    static final int MAX = 200000000;
    static int[] point = new int[2];
    static int[] dist;
    static void input(){
        N = scan.nextInt();
        E = scan.nextInt();
        edges = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<>();
        for (int i = 0; i < E; i++){
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();
            edges[from].add(new Edge(to,weight));
            edges[to].add(new Edge(from,weight));
        }
        point[0] = scan.nextInt();
        point[1] = scan.nextInt();
    }
    static int dijkstra(int start, int to) {
        dist = new int[N+1];
        for (int i = 1; i <= N; i++) dist[i] = 200000000;

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        pq.add(new Info(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();
            if (dist[info.idx] != info.dist) continue;

            for (Edge e : edges[info.idx]) {
                if (dist[info.idx] + e.weight >= dist[e.to]) continue;
                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }
        return dist[to];
    }
    public static void main(String[] args) {
        input();
        int a = dijkstra(1,point[0]);
        int b = dijkstra(point[0],point[1]);
        int c = dijkstra(point[1],N);
        int routeA = a+b+c;

        int a2 = dijkstra(1,point[1]);
        int b2 = dijkstra(point[1],point[0]);
        int c2 = dijkstra(point[0],N);
        int routeB = a2+b2+c2;
        if (routeA >= 200000000 && routeB >= 200000000) System.out.println(-1);
        else System.out.println(Math.min(routeA,routeB));
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
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

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}