import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int x1,y1,x2,y2;
    static int a1,b1,a2,b2;
    static FastReader scan = new FastReader();
    static void input(){
        x1 = scan.nextInt();y1 = scan.nextInt();
        x2 = scan.nextInt();y2 = scan.nextInt();
        a1 = scan.nextInt();b1 = scan.nextInt();
        a2 = scan.nextInt();b2 = scan.nextInt();
    }
    static void pro(){
        int res = 0;
        if(ccw(x1,y1,x2,y2,a1,b1) * ccw(x1,y1,x2,y2,a2,b2) < 0 && ccw(a1, b1, a2, b2, x1, y1) * ccw(a1, b1, a2, b2, x2, y2) < 0)
            res = 1;

        System.out.println(res);
    }
    public static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        // CCW 공식 (x1y2+x2y3+x3y1)−(y1x2+y2x3+y3x1)
        return x1 * y2 + x2 * y3 + x3 * y1 - y1 * x2 - y2 * x3 - y3 * x1 < 0 ? 1 : -1;
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
            while (st==null||!st.hasMoreTokens()){
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