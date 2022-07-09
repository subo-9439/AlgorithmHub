import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N,M,start,end;
    static int[] dist;      //각 도시로 갈 수 있는 최단거리
    static ArrayList<Edge>[] edges;
    static class Edge {// start에서 해당 도시로 갈 때의 가중치
        int to;
        int weight;
        Edge(int to ,int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    static class Info {
        int idx;
        int dist;
        Info(){
        }
        Info(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }

    }
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        edges = new ArrayList[N+1];
        dist = new int[N+1];
        for (int i = 1 ; i <= N; i++){//초기화
            edges[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 1 ; i <= M; i++){
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();
            edges[from].add(new Edge(to,weight));
        }
        start = scan.nextInt();
        end = scan.nextInt();
    }
    static void dijkstra(int start){
//        PriorityQueue<Info> pq = new PriorityQueue<Info>(Comparator.comparing(o -> o.dist));
        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist-o2.dist);

        // 시작지점에 대한 정보 넣어주기
        pq.add(new Info(start,0));
        dist[start] = 0;

        //거리 정보들이 모두 소진 될 때까지 거리 갱신 반복
        while (!pq.isEmpty()){
            Info info = pq.poll();

            //꺼낸 정보가 최신 정보랑 다르면, 낡은 정보이므로 폐기한다.
            if (dist[info.idx] != info.dist)continue;

            // 연결된 모든 간선들을 통해서 다른 정점들에 대한 정보를 갱신한다.
            for (Edge e: edges[info.idx]){
                //새롭게 구한 거리가 기존거리보다 크다면 정보 폐기
                if(dist[info.idx] + e.weight >= dist[e.to]) continue;
                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to,dist[e.to]));
            }
        }
        System.out.println(dist[end]);
    }
    public static void main(String[] args) {
        input();
        dijkstra(start);
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
             br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
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