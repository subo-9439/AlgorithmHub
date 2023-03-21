import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int S, P, totalReq = 4;
    static String DNA;
    static int[] passwordReq = new int[4];

    public static void main(String[] args) {
        S = scan.nextInt();
        P = scan.nextInt();
        DNA = scan.nextLine();
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            passwordReq[i] = scan.nextInt();
            if (passwordReq[i] == 0) 
                totalReq--;
        }

        //미리 슬라이딩 윈도우로 짜놓으면 for문 두번 돌 필요 없음.
        for (int i = 0; i < P; i++) {
            addChar(DNA.charAt(i));
        }
        if (totalReq == 0) ans++;

        for (int i = 0; i < DNA.length()-P; i++) {
            //0부터 P까지
            int j = i+P;
            addChar(DNA.charAt(j));
            removeChar(DNA.charAt(i));
            if (totalReq == 0) ans++;
        }
        System.out.println(ans);

    }
    static void addChar(char c){
        if(c == 'A'){
            passwordReq[0]--;
            if (passwordReq[0] == 0) totalReq--;
        }else if (c == 'C'){
            passwordReq[1]--;
            if (passwordReq[1] == 0) totalReq--;;
        }else if (c == 'G'){
            passwordReq[2]--;
            if (passwordReq[2] == 0) totalReq--;
        }else if (c == 'T'){
            passwordReq[3]--;
            if (passwordReq[3] == 0) totalReq--;
        }
    }
    static void removeChar(char c){
        if(c == 'A'){
            if (passwordReq[0] == 0) totalReq++;
            passwordReq[0]++;
        }else if (c == 'C'){
            if (passwordReq[1] == 0) totalReq++;;
            passwordReq[1]++;
        }else if (c == 'G'){
            if (passwordReq[2] == 0) totalReq++;
            passwordReq[2]++;
        }else if (c == 'T'){
            if (passwordReq[3] == 0) totalReq++;
            passwordReq[3]++;
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
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
        Integer nextInt() {
            return Integer.parseInt(next());
        }

    }
}