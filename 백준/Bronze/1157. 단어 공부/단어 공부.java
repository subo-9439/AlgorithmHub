import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        String str = scan.next().toUpperCase();
        int[] words = new int[26];

        // 1) 빈도수 계산
        for (int i = 0; i < str.length(); i++) {
            words[str.charAt(i) - 'A']++;
        }

        // 2) 최대빈도 찾기
        int maxCount = -1;
        char answer = '?';
        for (int i = 0; i < 26; i++) {
            if (words[i] > maxCount) {
                maxCount = words[i];
                answer = (char) ('A' + i);
            }
        }

        // 3) 최대빈도를 갖는 알파벳이 여러 개인지 확인
        int countMaxAlphabet = 0;
        for (int i = 0; i < 26; i++) {
            if (words[i] == maxCount) {
                countMaxAlphabet++;
                if (countMaxAlphabet > 1) {
                    answer = '?';
                    break;
                }
            }
        }
        
        System.out.println(answer);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public String next(){
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st= new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }
}
