import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x1,y1,r1,x2,y2,r2;
        int testcase;

        double d;
        testcase = scan.nextInt();

        for(int i =0; i < testcase; i++) {
            int result;
            x1 = scan.nextInt();
            y1 = scan.nextInt();
            r1 = scan.nextInt();
            x2 = scan.nextInt();
            y2 = scan.nextInt();
            r2 = scan.nextInt();
            d = Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2));

            if(x1==x2 && y1 == y2 && r1 == r2) {
                result = -1;
            }else if(d == r1+r2 || Math.abs(r1-r2) == d){
                result = 1;
            }else if(Math.abs(r1-r2) > d || x1 == x2 && y1 == y2 && r1 != r2 || d> r1+ r2 ){
                result = 0;
            }else {
                result = 2;
            }
            System.out.println(result);
        }
    }
}