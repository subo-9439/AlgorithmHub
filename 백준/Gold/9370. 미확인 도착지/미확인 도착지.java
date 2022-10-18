import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Graph {
    int idx;
    int weight;
    Graph(int idx, int weight) {
        this.idx = idx;
        this.weight = weight;
    }
}
class Info {
    int idx;
    int weight;
    Info(int idx, int weight) {
        this.idx = idx;
        this.weight = weight;
    }
}
public class Main {
    static FastReader scan = new FastReader();
    static int n, m, t; //교차로, 도로 목적지 후보의 개수
    static int s, g, h; //출발지, 흔적 vertex
    static ArrayList<Graph>[] nodes;  //노드 간선정보 저장
    static int[] dist;
    static int[] endPoints; //목적지 후보
    static StringBuilder sb;

    public static void main(String[] args) {
        int T = scan.nextInt();
        sb = new StringBuilder();
        while (T-- > 0 ){
            input();
            dijkstra(s);     //시작지점부터 다익스트라 ㄱㄱ
            output();
        }
        System.out.println(sb);
    }
    static void output(){

        for (int a : endPoints) {
            if (dist[a] == Integer.MAX_VALUE||dist[a]%2 != 1)continue;//짝수라면 그 거리는 원했던 최단거리가 아니다
            sb.append(a).append(" ");
        }
        sb.append("\n");
    }

    static void dijkstra(int start) {
        //다익스트라로 풀면될듯
        dist = new int[n+1];
//        boolean[] visited = new boolean[n+1];

        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.weight- o2.weight);
        //초기설정
        Arrays.fill(dist,Integer.MAX_VALUE);        //가중치 최대값
        pq.add(new Info(start,0)); //시작지점 넣어주고
        dist[start] = 0;                    //시작지점 초기화

        while (!pq.isEmpty()){
            Info cur = pq.poll();
//            if (visited[cur.idx]) {
//                continue;
//            }
            if (cur.weight != dist[cur.idx]) continue;

//            visited[cur.idx] = true;
            for (Graph next : nodes[cur.idx]){
                if (dist[next.idx] > cur.weight + next.weight){  //최단거리가 갱신이 된다면 ..
                    dist[next.idx] = cur.weight + next.weight;
                    pq.add(new Info(next.idx, dist[next.idx]));
                }
            }
        }
    }


    static void input() {
        n = scan.nextInt(); m = scan.nextInt(); t = scan.nextInt();
        s = scan.nextInt(); g = scan.nextInt(); h = scan.nextInt();

        nodes = new ArrayList[n+1];       //노드는 n개
        endPoints = new int[t];         //도착지는 t개

        for (int i = 1; i <= n; i++) nodes[i] = new ArrayList();

        for (int i = 1; i <= m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int d = scan.nextInt()*2;
            if (a==g && b==h || a==h && b==g) d-=1;
            nodes[a].add(new Graph(b,d));
            nodes[b].add(new Graph(a,d));
        }

        for (int i = 0; i < t; i++) {
            int x = scan.nextInt();
            endPoints[i] = x;
        }
        Arrays.sort(endPoints); //sort해주기
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