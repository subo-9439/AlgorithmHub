import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static void pro() {
        double x1 = scan.nextInt() ,y1 = scan.nextInt(), r1 = scan.nextInt(), x2 = scan.nextInt() ,y2 = scan.nextInt() ,r2 = scan.nextInt();

        int result;
        //원위 중심이 안에 있는지
        double dist = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        if (x1==x2 && y1==y2 && r1==r2){
            result = -1;
        }else if ( dist == r1+r2 || Math.abs(r1-r2) == dist){
            result = 1;
        }else if (Math.abs(r1-r2) > dist ||x1==x2 && y1==y2 && r1!=r2|| dist > r1+r2  ){
            result = 0;
        }else {
            result = 2;
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int i = 0 ; i < T ; i++) {
            pro();
        }
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null || !st.hasMoreTokens()){
                try{
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