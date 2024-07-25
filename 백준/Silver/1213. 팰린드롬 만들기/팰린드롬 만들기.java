import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        String str = scan.next();
        int[] alp = new int[26];
        char oddAlpChr = 0;
        int oddCnt = 0;
        String answer = "";
        for(int i = 0; i < str.length(); i++) {
            alp[str.charAt(i)-'A']++;
        }
        ArrayList<Alphabet> list = new ArrayList<>();
        for(int i = 0; i< alp.length; i++) {
            if(alp[i] % 2 == 1) {
                oddAlpChr = (char)( i + 'A');
                oddCnt++;
                if(oddCnt == 2) {
                    answer = "I'm Sorry Hansoo";
                    System.out.println(answer);
                    System.exit(0);
                }
            }
            if(alp[i] > 0 ){
                list.add(new Alphabet((char)(i+'A'), alp[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        String textMid = "";
        for(int i = 0; i < list.size(); i++) {
            sb.setLength(0);
            Alphabet bet = list.get(i);
            for(int j = 0; j < bet.cnt/2; j++) {
                sb.append(bet.chr);
            }
            if(bet.cnt % 2 == 1) {
                textMid = Character.toString(bet.chr);
            }
            String text1 = sb.toString();
            String text2 = sb.toString();
            int len = answer.length();
            String first = answer.substring(0, len/2);
            String last = answer.substring(len/2);
            sb.setLength(0);
            if(i != list.size()-1) {
                answer = sb.append(first).append(text1).append(text2).append(last).toString();
            }else {
                answer = sb.append(first).append(text1).append(textMid).append(text2).append(last).toString();
            }
        }
        System.out.println(answer);
    }
    static class Alphabet {
        char chr;
        int cnt;
        Alphabet(char chr, int cnt) {
            this.chr = chr;
            this.cnt = cnt;
        }
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