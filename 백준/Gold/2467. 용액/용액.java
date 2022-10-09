import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static int N;
    static int[] arr;

    static void input(){
        N = scan.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = scan.nextInt();
    }
    static void pro(){
        int leftIdx = 0, rightIdx = N-1;
        int diff = Integer.MAX_VALUE;
        //10억, -1 -10억,
        //이분탐색으로 풀어야한다.
        //첫idx와 끝 idx서 서로를 향해
        //arr[첫idx]와 끝[idx] 중 큰숫자가 담긴 idx를 서로를 향해움직임
        //0이되면 종료

        int ansL = 0, ansR = 0;
        while (leftIdx < rightIdx) {
            //arr[L] + arr[R-1]
            //arr[R] + arr[L+1] 중 큰값이 나오면
            if (Math.abs(arr[leftIdx] + arr[rightIdx]) < diff) {
                diff = Math.abs(arr[leftIdx] + arr[rightIdx]);
                ansL = arr[leftIdx];
                ansR = arr[rightIdx];
            }

            if (diff == 0){
                break;
            }
            if (Math.abs(arr[leftIdx] + arr[rightIdx - 1]) > Math.abs(arr[rightIdx] + arr[leftIdx + 1])) {
                leftIdx++;
            }else {
                rightIdx--;
            }

        }
        System.out.println(ansL + " " + ansR);
    }
    public static void main(String[] args) {
        input();
        pro();


    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        int nextInt(){
            return Integer.parseInt(next());
        }


        FastReader() {
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
    }
}