import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge{
    int to, weight;
    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}
public class Main {
    static FastReader scan = new FastReader();
    static PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2) -> o1.weight - o2.weight);

    static int N, D;
    static int[] dist;
    static List<Edge>[] edges;


    public static void main(String[] args) {
        N = scan.nextInt();
        D = scan.nextInt();
        dist = new int[10001]; //거리는 10000이하만 들어온다
        edges = new ArrayList[10001];
        Arrays.fill(dist,10001);

        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
            dist[i] = i;
        }
        for (int i = 0; i < N; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();
            //초과하는 to에 대해선 굳이 추가하지 말자
            if (to <= D) {
                Edge edge = new Edge(to,weight);
                edges[from].add(edge);
                pq.add(edge);
            }
        }
        dijkstra();
        System.out.println(dist[D]);

    }

    private static void dijkstra() {
        for (int i = 0; i <= D; i++) {
            for (Edge edge : edges[i]) {
               int nextIdx =  edge.to;
               int weight = edge.weight;
               if (dist[i] + weight < dist[nextIdx]){
                   dist[nextIdx] = dist[i] + weight;
               }
            }
            dist[i + 1] = Math.min(dist[i] + 1,dist[i+1]);
        }
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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