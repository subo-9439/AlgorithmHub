import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    static FastReader scan = new FastReader();
    static ArrayList<Integer>[] tree;
    static boolean[] isVisited;
    static int answer, N;
    static int deleteNode = 0;
    public static void main(String[] args) {
        scan = new FastReader();
        N = scan.nextInt();
        tree = new ArrayList[N];
        isVisited = new boolean[N];
        int root = 0;

        for(int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++) {
            int parentIdx = scan.nextInt();
            if(parentIdx != -1) {
                tree[i].add(parentIdx);
                tree[parentIdx].add(i);
            }else {
                root = i;
            }
        }

        deleteNode = scan.nextInt();
        if(deleteNode == root) {
            System.out.println(0);
        }else{
            dfs(root);
            System.out.println(answer);
        }
    }
    static void dfs(int node){
        isVisited[node] = true;
        int childNode = 0;
        for(int i : tree[node]){
            if(isVisited[i] == false && i != deleteNode) {
                childNode++;
                dfs(i);
            }
        }
        if(childNode == 0) {
            answer++;
        }
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null || !st.hasMoreTokens()) {
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        };
    }
}