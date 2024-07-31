import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.TreeSet;

public class Main {
        static int N,M;
        static FastReader scan = new FastReader();
        static TreeSet<Problem> list = new TreeSet<>();
        static HashMap<Integer, Integer> map = new HashMap<>();
        public static void main(String[] args) {
            N = scan.nextInt();
            for (int i = 0; i < N; i++) {
                int number = scan.nextInt();
                int level = scan.nextInt();
                Problem problem = new Problem(number, level);
                list.add(problem);
                map.put(number, level);
            }
            StringBuilder sb = new StringBuilder();
            M = scan.nextInt();
            for (int i = 0; i < M; i++) {
                String query = scan.next();
                if("add".equals(query)){
                    int number = scan.nextInt();
                    int level = scan.nextInt();
                    Problem problem = new Problem(number, level);
                    list.add(problem);
                    map.put(number, level);
                }else if("recommend".equals(query)){
                    int recommendQuery = scan.nextInt();
                    if(recommendQuery == 1) {
                        sb.append(list.last().number).append("\n");
                    }else if(recommendQuery == -1) {
                        sb.append(list.first().number).append("\n");
                    }
                }else if("solved".equals(query)){
                    int number = scan.nextInt();
                    int level = map.get(number);
                    list.remove(new Problem(number, level));
                    map.remove(number);
                }
            }
            System.out.println(sb.toString());
        }
        
        static class Problem implements Comparable<Problem>{
            int number;
            int level;
            Problem(int number, int level) {
                this.number = number;
                this.level = level;
            }
            @Override
            public int compareTo(Problem o) {
                if(this.level == o.level) return this.number - o.number;
                return this.level - o.level;
            }
    
        }
        static class FastReader {
            BufferedReader br;
            StringTokenizer st;
    
            FastReader() {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
    
            String next(){
                while (st == null || !st.hasMoreTokens()) {
                    try {
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
