import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isPrime;
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();

        setPrime();

        while (true){
            int num = sc.nextInt();
            int ansL = 0,ansR = 0;
            if (num == 0) break;

            for (int x = 3; x <= num/2; x+=2){
                if (isPrime[x] && isPrime[num-x]) {
                    ansL = x;
                    ansR = num-x;
                    break;
                }
            }
            if (ansL == 0){
                sb.append("Goldbach's conjecture is wrong.").append("\n");
            }else {
                sb.append(num).append(" = ").append(ansL).append(" + ").append(ansR).append("\n");
            }
        }
        System.out.println(sb.toString());


        //3 39
    }

    public static void setPrime(){
        isPrime = new boolean[1000001];
        isPrime[0] = true;
        isPrime[1] = true;
        isPrime[2] = true;
        isPrime[3] = true;
        for (int i = 4; i < 1000001; i++){
            for (int j = 2; j <= Math.sqrt(i); j++){
                isPrime[i] = true;
                if (i % j == 0) {
                    isPrime[i] = false;
                    break;
                }
            }
        }
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