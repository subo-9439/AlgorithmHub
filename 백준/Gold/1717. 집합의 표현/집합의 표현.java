import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N,M;
    static int[] parent;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        parent = new int[N+1];
        for (int i = 0; i <= N; i++) parent[i] = i;
    }

    static void pro(){
        for (int i = 0; i < M; i++){
            int order = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();


            if (order == 0){
                union(x,y);
            }else {
                if(isSame(x,y)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x,int y){
        x = find(x);
        y = find(y);

        if(x!=y){
            if(x<y)parent[y] = x;
            else parent[x] = y;
        }
    }

    static boolean isSame(int x, int y){
        x = find(x);
        y = find(y);
        return x == y;
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
}