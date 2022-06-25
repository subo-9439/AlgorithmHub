import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static int N,M; // N 도시의 수, M 여행계획에 속한 도시들의 수
    static int[] parent;

    //x의 부모를 찾는 메서드
    static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);

    }
    //y의 부모를 x의 부모로 치환하는 연산
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            if(x < y) parent[y] = x;//부모는 자기보다 작아야한ㄷ.
            else parent[x] = y;
        }
    }
    public static void main(String[] args) {
        N = scan.nextInt();
        M = scan.nextInt();
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) parent[i] = i;// 각자 부모노드 각자로
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= N; j++){
                if(scan.nextInt() == 1){
                    union(i,j);
                }
            }
        }
        int start = find(scan.nextInt());
        boolean flag = false;
        for (int i = 1; i < M; i++){
            int now = scan.nextInt();

            if(start != find(now)){
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null ||!st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine(){
            String str="";
            try {
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}