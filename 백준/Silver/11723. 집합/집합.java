import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Set<Integer> set = new HashSet<>();

    static void input(){
        N = scan.nextInt();
        for (int i = 0; i < N; i++){
            String s = scan.nextLine();
            order(s);
        }
    }
    static void order(String s){
        String[] arr = s.split(" ");
        if (arr.length == 1){
            if (arr[0].equals("all")){
                set = new HashSet<Integer>(){
                    {
                        for (int i = 1; i<= 20; i++)add(i);
                    }  
                };
            }
            if (arr[0].equals("empty")){
                set = new HashSet<>();
            }
            return;
        }
        if (arr[0].equals("add")){
            set.add(Integer.parseInt(arr[1]));
        }
        if (arr[0].equals("remove")){
            set.remove(Integer.parseInt(arr[1]));
        }
        if (arr[0].equals("toggle")){
            if (set.contains(Integer.parseInt(arr[1]))){
                set.remove(Integer.parseInt(arr[1]));
            }else {
                set.add(Integer.parseInt(arr[1]));
            }
        }
        if (arr[0].equals("check")){
            if (set.contains(Integer.parseInt(arr[1]))){
                sb.append("1").append("\n");
            }else {
                sb.append("0").append("\n");
            }
        }
    }
    public static void main(String[] args) {
        input();
        System.out.println(sb.toString());
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
        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}