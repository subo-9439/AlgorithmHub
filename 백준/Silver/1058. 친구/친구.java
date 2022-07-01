import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static int N;

    static ArrayList<Integer>[] list;
    static int[][] map;
    static int[][] ans;

    static void input(){
        N = scan.nextInt();
        map = new int[N][N];
        ans = new int[N][N];
        for (int i = 0; i < N; i++){
            String s = scan.nextLine();
            for (int j = 0; j < s.length(); j++){
                if(s.charAt(j) == 'Y') {
                    map[i][j] = 1;
                    ans[i][j] = 1;
                }else {
                    map[i][j] = 0;
                    ans[i][j] = 0;
                }
            }
        }
    }
    static void pro(){
        for (int k = 0; k < N; k++){//거쳐가는 노드
            for(int i = 0; i < N; i++){//시작 노드
                if(i==k)continue;
                for (int j = 0; j < N; j++){// 종점 노드
                    if(j==k || j== i) continue;
                    if(map[i][j] == 0 && map[i][k] == 1 && map[k][j] == 1){
                        ans[i][j] = 1;
                    }
                }
            }
        }

        int max = 0;
        for(int i = 0; i< N; i++){
            int cnt = 0;
            for (int j = 0; j < N; j++){
                if(ans[i][j] == 1) cnt++;
            }
            max = Math.max(max,cnt);
        }
        System.out.println(max);
    }
    public static void main(String[] args) {
        input();
        pro();
    }
    static class FastReader{
        StringTokenizer st;
        BufferedReader br;

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
        String nextLine(){
            String st = "";
            try {
                st = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return st;
        }
    }
}
