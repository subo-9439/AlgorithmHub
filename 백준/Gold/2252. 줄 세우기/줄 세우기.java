import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
  static FastReader sc = new FastReader();
  public static void main(String[] args) {
    int N = sc.nextInt(), M = sc.nextInt();
    ArrayList<Integer>[] adj = new ArrayList[N+1];
    int[] indeg = new int[N+1];
    StringBuilder sb = new StringBuilder();
    for(int i = 1; i<= N; i++){
      adj[i] = new ArrayList<>();
    }

    for(int i = 1; i <= M; i++){
      int x = sc.nextInt(), y = sc.nextInt();
      adj[x].add(y);
      indeg[y]++;
    }

    Queue<Integer> q = new LinkedList<>();
    for(int i = 1; i <= N; i++){
      if(indeg[i] == 0){
        q.add(i);
      }
    }

    while(!q.isEmpty()){
      int x = q.poll();
      sb.append(x).append(' ');
      for(int y: adj[x]){
        indeg[y]--;
        if(indeg[y] == 0) q.add(y);
      }
    }

    System.out.println(sb);
  }
  static class FastReader{
    BufferedReader br;
    StringTokenizer st;
    public FastReader(){
      br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next(){
      while(st== null || !st.hasMoreTokens()){
        try{
          st = new StringTokenizer(br.readLine());
        }catch(IOException e){
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