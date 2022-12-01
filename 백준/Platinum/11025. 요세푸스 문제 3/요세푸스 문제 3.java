import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] dp = new int[500001];
        int r = 1;
        for (int i = 2; i <= n; i++){
            r = (r+k-1)% i+ 1;
        }
        System.out.println(r);
    }
}