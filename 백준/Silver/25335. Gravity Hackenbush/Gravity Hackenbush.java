import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N,M;
    static ArrayList<Pos> list = new ArrayList<>();
    static ArrayList<Edge>[] from;
    static boolean[] checked;
    static int[] arr;
    static class Pos {
        int x;
        int y;
        Pos(int x, int y ){
            this.x = x;
            this.y = y;
        }
    }
    static class Edge{
        int to;
        String color;
        Edge(int to, String color){
            this.to = to;
            this.color = color;
        }
    }

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        checked = new boolean[N+1];
        from = new ArrayList[N+1];
        arr = new int[3];
        for (int i = 1; i<= N; i++) from[i] = new ArrayList<>();
        for (int i = 0 ; i < N; i++){
            Pos pos = new Pos(scan.nextInt(), scan.nextInt());
            list.add(pos);
        }
        for (int i = 0 ; i < M; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            String z = scan.next();
            if (z.equals("R")){
                arr[0]++;
            }else if(z.equals("B")){
                arr[1]++;
            }else {
                arr[2]++;
            }
            from[x].add(new Edge(y,z));
            from[y].add(new Edge(x,z));
        }
    }
    static void pro(){
        //다필요없고 그냥 R,G,B 개수 세자
        int red = arr[0];
        int blue = arr[1];
        int green = arr[2]%2;
        red = green== 1? red+1 : red;
        if (red > blue){
            System.out.println("jhnah917");
        }else {
            System.out.println("jhnan917");
        }
    }
    public static void main(String[] args) {
        input();
        pro();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
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