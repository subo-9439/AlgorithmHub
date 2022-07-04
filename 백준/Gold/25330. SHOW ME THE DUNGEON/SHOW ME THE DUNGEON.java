import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static int N, K;
    static int MAX = Integer.MIN_VALUE;
    static boolean[] visited;
    static List<Integer> keySet;
    static Map<Integer,ArrayList<Integer>> map;
    static void input(){
        N = scan.nextInt();
        K = scan.nextInt();
        map = new HashMap<>();
        visited = new boolean[N];
        String[] monsters = scan.nextLine().split(" ");
        String[] citizens = scan.nextLine().split(" ");

        for (int i = 0; i < N; i++)  {
            ArrayList<Integer> info = new ArrayList<>();
            info.add(Integer.parseInt(monsters[i]));
            info.add(Integer.parseInt(citizens[i]));
            map.put(i,info);
        }

    }
    static void pro(){
        keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, (key1,key2) -> map.get(key1).get(0).compareTo(map.get(key2).get(0)));
        dfs(-1,0,0, 0);
        System.out.println(MAX);
    }
    static void dfs(int idx, int t, int sumt,int temp){
        MAX = Math.max(MAX,temp);
        for (Integer x : keySet){
            if(visited[x]) continue;
            t += map.get(x).get(0);
            sumt += t;
            if (sumt > K){
               sumt -= t;
               t -= map.get(x).get(0);
               continue;
            }
            visited[x] = true;
            dfs(x, t, sumt,temp + map.get(x).get(1));
            visited[x] = false;
            sumt -= t;
            t -= map.get(x).get(0);

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
        String nextLine(){
            String str = "";
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