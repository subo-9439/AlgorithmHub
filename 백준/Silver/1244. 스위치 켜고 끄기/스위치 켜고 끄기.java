import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Student{
    int gender;
    int num;
    Student(int gender, int num) {
        this.gender = gender;
        this.num = num;
    }
}
public class Main {
    static FastReader scan = new FastReader();
    static int piece;
    static int[] switches;
    static int studentCount;
    static List<Student> students;
    static Student studentA, studentB;

    static void input() {
        piece = scan.nextInt();
        switches = new int[piece+1];
        for (int i = 1; i <= piece; i++){
            switches[i] = scan.nextInt();
        }
        studentCount = scan.nextInt();
        students = new ArrayList<>();
        for (int i = 0 ; i < studentCount; i++){
            students.add(new Student(scan.nextInt(), scan.nextInt()));
        }
    }

    public static void main(String[] args) {
        input();
        for (Student student : students){
            if (student.gender == 1) {
                for (int i = 1; i <= piece; i++) {
                    if (i % student.num == 0) {
                        switches[i] = (switches[i]+1) %2;
                    }
                }
            }else {
                switches[student.num] = (switches[student.num]+1) % 2;
                int numM = student.num;
                int numP = student.num;
                while (numM > 1 && numP < piece && switches[--numM] == switches[++numP]) {
                    switches[numM] = (switches[numM]+1) % 2;
                    switches[numP] = (switches[numP]+1) % 2;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= piece; i++){
            sb.append(switches[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
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