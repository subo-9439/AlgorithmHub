import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//답지참조
public class Main {
    static FastReader scan = new FastReader();
    static int N;
    static int[] arr = new int[5000];

    static boolean isEvenPalindrome(int left, int right) {
        for (int i = 0; i <= (right - left) / 2; i++) {
            if(arr[left + i] != arr[right - i]) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        N = scan.nextInt();
        for(int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }
        int answer = 0;
        int j = 0;
        for (int i = 0 ; i < N;) {//펠린드롬 시작점
            boolean found = false;
            for (j = i+1; j < N; j += 2){
                if(isEvenPalindrome(i, j)) { //가장짧은것을찾으면 탈출
                    answer += 1;
                    found = true;
                    break;
                }
            }
            // 하나도 찾지못했으며 해당 위치에서 짝수 펠린드롬을 만들 수 없으면 종료
            if (!found) {
                answer = -1;
                break;
            }
            i = j + 1; //다음시작점
        }
        System.out.println(answer);
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
                }catch(IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}