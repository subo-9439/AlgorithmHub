import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
//이게 왜 브론즈냐
    //말그대로 for문 세번 돌려서 하는거네 ㄷㄷ 멀었다 아직
    static FastReader scan = new FastReader();
    static int N;
    static int[] stand;
    static int[] triangle;
    public static void main(String[] args){
        input();
        pro();
    }

    private static void pro() {
        //삼각수는 1,3,6 10,15, 21
        //점화식이 T1 = 1 ,T2 = T1 + 2 , T3 = T2 +3 이네
        //Tn = Tn-1 + n; => 계차 수열
        // 1 3 6 10 15 21
        //  2 3 4  5  6
        //bn = 2 + (n-1)*1  => bn = an+1 - an => an+1 = bn + an
        //즉 an = a1 + 시그마(1부터 n-1까지)bk
        //a44 = 대략 1000이되므로 44까지
        for (int i = 2; i < triangle.length; i++) {
            triangle[i] = triangle[i-1] + i;
        }
        for (int t = 0; t < N; t++) {
            int num = stand[t];
            if (isTriNum(num)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }

    private static boolean isTriNum(int num) {
        for (int i = 1; i < triangle.length; i++){
            for (int j = 1; j < triangle.length; j++) {
                for (int k = 1; k < triangle.length; k++) {
                    if (triangle[i] + triangle[j] +triangle[k] == num) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void input() {
        N = scan.nextInt();
        stand = new int[N];
        for (int i = 0; i < N; i++) stand[i] = scan.nextInt();

        triangle = new int[45];
        triangle[1] = 1;
    }


    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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