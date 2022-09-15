import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N,k;
    static char[][] map;
    static boolean[][] visited;
    static void input(){
        N = scan.nextInt();
        k = scan.nextInt();
        map = new char[2][N];
        visited = new boolean[2][N];
        map[0]=scan.nextLine().toCharArray();
        map[1]=scan.nextLine().toCharArray();
    }
    static boolean pro(){
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info("left",0,0));
        map[0][0] = '0';
        boolean flag = false;
        while (!queue.isEmpty()){
            Info cur = queue.poll();
            int x = cur.dir.equals("left")? 0 : 1;
            if (cur.idx > N-1 && map[x][cur.idx] == '1') {
                flag =  true;
                return flag;
            }
            if (cur.idx +k > N-1) {
                flag = true;
                return flag;
            }


            if (!visited[x][cur.idx+1] && map[x][cur.idx+1] == '1' && cur.idx+1 > cur.time){
                queue.add(new Info(cur.dir, cur.idx+1, cur.time+1 ));
                map[x][cur.time] = '0';
            }
            if (cur.idx-1>=0){
                if (!visited[x][cur.idx-1] && map[x][cur.idx-1] == '1' && cur.idx-1 > cur.time){
                    queue.add(new Info(cur.dir, cur.idx-1, cur.time+1 ));
                    map[x][cur.time] = '0';
                }
            }
            visited[x][cur.idx+1] = true;

            
            String dir = cur.dir.equals("left")? "right" : "left";
            x = x==1? 0:1;
            if (!visited[x][cur.idx+k] && map[x][cur.idx+k] == '1' && cur.idx+k > cur.time){
                queue.add(new Info(dir, cur.idx+k, cur.time+1));
                map[x][cur.time] = '0';
                visited[x][cur.idx+k] = true;
            }
        }
        return flag;
    }
    static class Info{
        String dir;
        int idx;
        int time;
        Info(String dir, int idx, int time){
            this.dir = dir;
            this.idx = idx;
            this.time = time;
        }
    }
    public static void main(String[] args) {
        input();
        if (pro()) {
            System.out.println(1);
        }else System.out.println(0);
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st == null|| !st.hasMoreTokens()){
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