import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static int N,M,start,end;
    static ArrayList<State>[] nodes;
    static boolean[] visited;
    static int[] dp;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        nodes = new ArrayList[N+1];
        dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            int x = scan.nextInt(), y = scan.nextInt(), w = scan.nextInt();
            nodes[x].add(new State(y,w));
        }
        start = scan.nextInt();
        end = scan.nextInt();
    }
    static void pro(){
        //시작점과 끝점이 정해져 있다.
        //시작점부터 각 노드에 대해 얼마나 적은값으로 갈 수 있는지 갱신을 해주면서 가면된다.
        Arrays.fill(dp,Integer.MAX_VALUE);
        Queue<Dist> queue = new PriorityQueue<>((o1,o2) -> o1.value - o2.value);
        queue.add(new Dist(start,0));
        dp[start] = 0;

        while (!queue.isEmpty()){
            Dist x = queue.poll();
            if (x.value != dp[x.node]) continue;

            for (State y : nodes[x.node]){
                if (dp[y.node] > dp[x.node] + y.weight){
                    dp[y.node] = dp[x.node] + y.weight;
                    queue.add(new Dist(y.node,dp[y.node]));
                }
            }
        }

    }

    static class Dist{
        int node;
        int value;
        Dist(int node, int value){
            this.node = node;
            this.value = value;
        }

    }
    static class State{
        int node;
        int weight;
        State(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        input();
        pro();
        System.out.println(dp[end]);
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