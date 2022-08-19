import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int INF = Integer.MAX_VALUE;
    static FastReader scan = new FastReader();
    static int N,M,W;
    static int[] dist;
    static ArrayList<Road>[] a;

    public static void main(String[] args) throws IOException {
        int TC = scan.nextInt();
        while (TC-- > 0){
            N = scan.nextInt();
            M = scan.nextInt();
            W = scan.nextInt();
            dist = new int[N+1];
            a = new ArrayList[N+1];
            for (int i = 0; i <= N; i++) a[i] = new ArrayList<>();
            for (int i = 0; i < M+W; i++){
                int start = scan.nextInt();
                int end = scan.nextInt();
                int weight = scan.nextInt();
                if (i < M) {//도로
                    a[start].add(new Road(end,weight));
                    a[end].add(new Road(start,weight));
                }else {//웜홀
                    a[start].add(new Road(end,-weight));
                }
            }
            boolean isCycle = false;
            for (int i = 1; i <= N; i++){//모든 정점에 대해서 벨만포드
                if (bellmanFord(i)) {
                    isCycle = true;
                    System.out.println("YES");
                    break;
                }
            }
            if (!isCycle){
                System.out.println("NO");
            }
        }
    }
    static boolean bellmanFord(int start){
        Arrays.fill(dist,INF);
        dist[start] = 0; //시작점 0
        boolean update = false; //벨만포드 확인차
        //정점의 개수 -1 번동안 최단거리 초기화
        for (int i = 1 ; i < N; i++){
            update = false;

            //각 지점에 대해 최단 거리 초기화
            for (int x = 1; x <= N; x++){
                for (Road road : a[x]){
                    if (dist[x] != INF && dist[road.end] > dist[x] + road.weight){
                        dist[road.end] = dist[x] + road.weight;
                        update = true;
                    }
                }
            }

            //더이상 최단거리 초기화가 일어나지 않았음
            if (!update) break;
        }

        //한번더 진행을 해서 업데이트가 발생하면 음수사이클이 일어났음
        if (update) {
            for (int i = 1; i<= N; i++){
                for (Road road: a[i]){
                    if (dist[i] != INF && dist[road.end] > dist[i] + road.weight){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st == null || !st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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

class Road{
    int end;
    int weight;

    Road(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

}