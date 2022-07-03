import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//중위순회 문제
public class Main {
    static FastReader scan = new FastReader();
    static int K,size;
    static int[] arr;
    static ArrayList<Integer> answerList = new ArrayList<>();

    static void input(){
        K = scan.nextInt();
        size = (int)Math.pow(2,K) - 1;
        arr = new int[size];
        for (int i = 0; i < arr.length; i++)arr[i] = scan.nextInt();
    }
    static void pro(){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(arr);
        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            if (temp.length == 0) continue;
            int[] left = new int[temp.length/2];
            int[] right = new int[temp.length/2];
            answerList.add(temp[temp.length/2]);
            System.arraycopy(temp,0,left,0,temp.length/2);
            System.arraycopy(temp,temp.length/2+1,right,0,temp.length/2);
            queue.add(left);
            queue.add(right);
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int i = 0 ; i < K; i++){
            for (int j = 0; j < Math.pow(2,i); j++){
                sb.append(answerList.get(idx++)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
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