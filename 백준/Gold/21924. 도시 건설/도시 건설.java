import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static FastReader scan;
    static ArrayList<Edge> edges;
    static int[] parent;
    static long result;
    static int count;
    public static void main(String[] args) {
        scan = new FastReader();
        edges = new ArrayList<>();
        N = scan.nextInt();
        M = scan.nextInt();
     
        setParent();
        for (int i = 1; i <= M; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            long c = scan.nextInt();
            edges.add(new Edge(a, b, c));
            result += c;
        }
        Collections.sort(edges);
        for(Edge edge : edges) {
            long cost = edge.cost;
            if(findParent(edge.nodeA) != findParent(edge.nodeB)) {
                unionParent(edge.nodeA, edge.nodeB);
                result -= cost;
                count ++;

            }
        }
        if(count == N-1) {
            System.out.println(result);
        }else {
            System.out.println(-1);
        }
    }
    static void setParent() {
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) parent[i] = i;
    }
    //3 -> 2 -> 1
    static int findParent(int idx){
        if(parent[idx] == idx) return idx;
        return parent[idx] = findParent(parent[idx]);   //경로압축
    }

    static void unionParent(int x, int y) {
        int parentX = findParent(x);
        int parentY = findParent(y);
        parent[parentX >= parentY ? parentX : parentY]  = parentX >= parentY ? parentY: parentX;
    }
    static class Edge implements Comparable<Edge>{
        int nodeA, nodeB;
        long cost;
        Edge(int nodeA, int nodeB, long cost) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge other) {
            if(this.cost < other.cost) return -1;
            return 1;
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
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