import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static int N, M, X;
    static ArrayList<Node>[] list;
    static int[] dp;
    static int[] dpFromX;
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        X = scan.nextInt();
        list = new ArrayList[N+1];
        dp = new int[N+1];
        dpFromX = new int[N+1];

        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int x = scan.nextInt(), y = scan.nextInt(), t = scan.nextInt();
            list[x].add(new Node(y,t));
        }
    }
    static void pro(){
        int max = 0;
        fromXtoOthers();
        for (int i = 1; i <= N; i++){
            dijkstra(i);
            max = Integer.max( max, dp[X]+ dpFromX[i]);
//            for (int j= 1;j <= N; j++) System.out.print(dp[i]);

        }
//        for (int i = 1; i <= N; i++) System.out.println(dp[i]);
        System.out.println(max);
    }
    static void dijkstra(int start){
        Arrays.fill(dp,Integer.MAX_VALUE);
        Queue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist-o2.dist);
        pq.add(new Info(start,0));
        dp[start] = 0;

        while (!pq.isEmpty()){
            Info from = pq.poll();
            if (from.dist != dp[from.idx]) continue;

            for (Node to : list[from.idx]){
                if (dp[to.idx] > to.w + dp[from.idx]){
                    dp[to.idx] = to.w + dp[from.idx];
                    pq.add(new Info(to.idx ,  to.w + dp[from.idx]));
                }
            }
        }
    }
    static void fromXtoOthers(){
        //모든 지점에서 x로 가는 최단거리 + x에서 모든 지점으로 가는 최단거리 구하기
        Arrays.fill(dpFromX,Integer.MAX_VALUE);
        Queue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist-o2.dist);
        pq.add(new Info(X,0));
        dpFromX[X] = 0;

        while (!pq.isEmpty()){

            Info from = pq.poll();
            if (from.dist != dpFromX[from.idx]) continue;

            for (Node to : list[from.idx]){
                if (dpFromX[to.idx] > to.w + dpFromX[from.idx]){
                    dpFromX[to.idx] = to.w+ dpFromX[from.idx];
                    pq.add(new Info(to.idx , to.w+ dpFromX[from.idx]));
                }
            }
        }
    }
    public static void main(String[] args) {
        input();
        pro();
    }
    static class Info {
        int idx;
        int dist;
        Info(int x, int dist){
            this.idx = x;
            this.dist = dist;
        }
    }
    static class Node {
        int idx;
        int w;
        Node(int y, int w) {
            this.idx = y;
            this.w = w;
        }
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e){
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