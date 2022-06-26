import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list = new ArrayList<>();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = "";
        while ((a = br.readLine()) != null){
            list.add(Integer.parseInt(a));
        }
    }
    static void traverse(int L, int R){
        if (L > R )return;
        int mid = R; //왼쪽과 오른쪽 subtree를 가르는 기준 위치를 나타냄
        for (int i = L + 1; i <= R; i++){
            if(list.get(i) > list.get(L)){
                mid = i - 1;
                break;
            }
        }
        traverse(L+1,mid);
        traverse(mid+1,R);
        sb.append(list.get(L)).append("\n");
    }
    static void pro(){
        traverse(0,list.size()-1);
        System.out.println(sb.toString());
    }
    public static void main(String[] args) throws IOException {
        input();
        pro();
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