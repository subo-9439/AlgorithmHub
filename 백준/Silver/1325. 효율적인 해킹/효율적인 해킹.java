import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class Main {
    static FastReader scan = new FastReader();
    static int N, M;
    static ArrayList<Integer>[] nodes;
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) {
        N = scan.nextInt();
        M = scan.nextInt();
        nodes = new ArrayList[N+1];
        answer = new int[N + 1];
        //노드 초기화
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        //간선정보기록
        for (int i = 0; i < M; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            nodes[from].add(to);
        }

        //bfs를 통해 어떤 노드가 젤 깊게 들어가는지 확인.
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            bfs(i);
        }

        int maxVal = 0;
        for (int i = 1; i <= N; i++) {
            maxVal = Math.max(answer[i], maxVal);
        }
        
        //출력
        for (int i = 1; i <= N; i++) {
            if (answer[i] == maxVal) {
                System.out.print(i + " ");
            }
        }
    }
    static void bfs(int idx){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        visited[idx] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : nodes[now]){
                if (visited[i] == false) {
                    visited[i] = true;
                    answer[i]++;
                    queue.add(i);
                }
            }

        }
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null || !st.hasMoreElements()) {
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
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