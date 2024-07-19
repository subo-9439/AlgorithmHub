import java.util.Scanner;

public class Main {
  static int N, X;
  static int[] arr;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    arr = new int[N];
    for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

    X = sc.nextInt();
    long sum = 0;
    int count = 0;
    for (int i = 0; i < N; i++) {
      if (gcd(X, arr[i])  == 1) {
        sum += arr[i];
        count++;
      }
    }
    System.out.printf("%.6f", (double) sum / count);
  }
  //16 6
  //6 4
  static long gcd(long x, long y) {
    while (y != 0) {
      long temp = x % y;
      x = y;
      y = temp;
    }
    return x;
  }
}