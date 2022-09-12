import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static int N,M;
    static ArrayList<Node>[] edges;
    static int start,end;
    static int[] dp;

    static void input(){
        N = scan.nextInt(); M = scan.nextInt();
        edges = new ArrayList[N+1];
        dp = new int[N+1];
        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) edges[scan.nextInt()].add(new Node(scan.nextInt(), scan.nextInt()));

        start = scan.nextInt(); end = scan.nextInt();
    }
    static void pro(){
        Arrays.fill(dp,Integer.MAX_VALUE);
        Queue<Info> queue = new PriorityQueue<>(((o1, o2) -> o1.dist-o2.dist));
        queue.add(new Info(start,0));
        dp[start] = 0;

        while (!queue.isEmpty()){
            Info cur = queue.poll();
            if (dp[cur.idx] != cur.dist) continue;

            for (Node next : edges[cur.idx]){

                if (dp[next.idx] > cur.dist + next.weight){
                    dp[next.idx] = cur.dist + next.weight;
                    queue.add(new Info(next.idx, cur.dist + next.weight));
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(dp[end]);
    }

    static class Node {
        int idx;
        int weight;
        Node(int idx, int weight){
            this.idx = idx;
            this.weight = weight;
        }

    }
    static class Info {
        int idx;
        int dist;
        Info(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st == null || !st.hasMoreElements()){
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