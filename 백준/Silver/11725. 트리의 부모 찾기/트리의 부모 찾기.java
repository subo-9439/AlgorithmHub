import java.io.*;
import java.util.*;

public class Main {
  static FastReader sc = new FastReader();
  static StringBuilder sb = new StringBuilder();

  static int n;
  static ArrayList<Integer>[] adj;
  static int[] parent;
  
  static void input(){
    n = sc.nextInt();
    adj = new ArrayList[n+1];
    parent = new int[n+1];
    for(int i=1; i<=n; i++){
      adj[i] = new ArrayList<>();
    }
    for(int i=1; i<n; i++){
      int x = sc.nextInt(),y=sc.nextInt();
      adj[x].add(y);
      adj[y].add(x);

    }
  }
  static void dfs(int x, int par){
    for(int y: adj[x]){
      if( y == par) continue;
        parent[y] = x;
        dfs(y,x);
    }
  }
  static void pro(){
    dfs(1,-1);
    for(int i=2;i<=n;i++){
      sb.append(parent[i]).append('\n');
    }
    System.out.println(sb);
  }
  public static void main(String[] args) {
    input();
    pro();
  }
  static class FastReader{
    BufferedReader br;
    StringTokenizer st;
    public FastReader(){
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next(){
      while(st==null|| !st.hasMoreElements()){
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
    String nextLine(){
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }

  }
}
