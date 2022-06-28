import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static int N,M;
    static int[] parent;
    static PriorityQueue<Info> pq ;
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        pq = new PriorityQueue<>();
        parent = new int[N+1];
        for (int i = 1; i <= N ; i++) parent[i] = i;
        for (int i = 0; i < M; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int h = scan.nextInt();
            pq.add(new Info(x,y,h));
        }
    }
    static void pro(){
//        System.out.println("================");
        int dist = 0;
        while (!pq.isEmpty()){

            Info info = pq.poll();
            //둘다 방문한적있으면 제외
            if(canUse(info.start,info.end)){
//                System.out.println(info.start+" " + info.end + " " + info.weight);
                union(info.start, info.end);
                dist+=info.weight;
            }
        }
        System.out.println(dist);
    }
    static boolean canUse(int x, int y){
        return find(x) != find(y);
    }
    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            if(x < y) parent[y] = x;
            else parent[x] = y;
        }
    }

    public static void main(String[] args) {
        input();
        pro();

    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
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
    static class Info implements Comparable<Info> {
        int start;
        int end;
        int weight;
        Info(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }


        @Override
        public int compareTo(Info o) {

            if (this.weight > o.weight)
                return 1;
            else if (this.weight < o.weight)
                return -1;
            return 0;
        }
    }
}