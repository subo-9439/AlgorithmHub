import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static ArrayList<Node>[] list;
    static void input() {
        N = scan.nextInt();
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < N; i++){
            int par = scan.next().charAt(0)-'A';
            int left = scan.next().charAt(0)-'A';
            int right = scan.next().charAt(0)-'A';
            list[par].add(new Node(left,right));
        }
    }
    static void preOrder(int par){
        sb.append(Character.toString(par+'A'));
        for(Node node : list[par]){
            if(node.left!= -19){
                preOrder(node.left);
            }
            if(node.right!=-19){
                preOrder(node.right);
            }
        }
    }
    static void inOrder(int par){
//        sb.append(Character.toString(list[par].+'A'));
        for(Node node: list[par]){
            if(node.left != -19){
                inOrder(node.left);
            }
            sb.append(Character.toString(par+'A'));
            if(node.right != -19){
                inOrder(node.right);
            }
        }
    }
    static void postOrder(int par){
        for(Node node:list[par]){
            if(node.left != -19){
                postOrder(node.left);
            }
            if(node.right != -19){
                postOrder(node.right);
            }
            sb.append(Character.toString(par+'A'));

        }

    }
    public static void main(String[] args) {
        input();
        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);
        System.out.println(sb.toString());
    }


    static class Node{
        int left;
        int right;
        public Node(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
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