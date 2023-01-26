import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static int N;
    static String[] arr;
    public static void main(String[] args){
        input();
        pro();
    }

    private static void pro() {
        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            boolean isTrue = true;
            for (int j = 0; j < arr[i].length(); j++) {
                if (arr[i].charAt(j) == '('){
                    stack.push('(');//사실 스택개념만 이용해도됨 뭐 일단
                }else {
                    if (!stack.isEmpty()){
                        stack.pop();
                    }else {
                        System.out.println("NO");
                        isTrue = false;
                        break;
                    }
                }
            }
            if (!isTrue) continue;
            if (stack.isEmpty()){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    private static void input() {
        N = scan.nextInt();
        arr = new String[N];
        for (int i = 0; i < N; i++) arr[i] = scan.next();
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