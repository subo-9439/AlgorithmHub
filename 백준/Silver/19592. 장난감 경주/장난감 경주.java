import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    public static void main(String[] args) {
        int testCase = scan.nextInt();
        StringBuilder sb = new StringBuilder();
        while (testCase-- > 0) {
            int N = scan.nextInt();
            int X = scan.nextInt();
            int Y = scan.nextInt();
            //가장빠른사람을 찾아서 그녀석이랑만 비교하자
            int MAX_SPEED = Integer.MIN_VALUE;
            for (int i = 0; i < N-1; i++) {
                int V = scan.nextInt();
                MAX_SPEED = Math.max(V,MAX_SPEED);
            }
            int myVector = scan.nextInt();
            double competitor = X*1.0/MAX_SPEED;
            //부스틀르 안쓰고도 이긴다.
            if (myVector > MAX_SPEED){
                sb.append(0).append("\n");
            }else if(1 + 1.0*(X-Y)/myVector>= competitor){
                sb.append(-1).append("\n");
            }else {
                int L = 0,R = Y;
                int ans = Y;
                while (L<=R){
                    int mid = (L+R)/2;
                    double tempTime = 1 + 1.0*(X-mid)/myVector;
                    if (tempTime < competitor){
                        R = mid-1;
                        ans = mid;
                    }else {
                        L = mid+1;
                    }
                }
                sb.append(ans).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st==null|| !st.hasMoreTokens()){
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