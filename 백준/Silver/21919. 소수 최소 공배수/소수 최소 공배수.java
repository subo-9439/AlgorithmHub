import java.util.Scanner;

public class Main {
  static int N;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    long ans = 1;
    for (int i = 0; i < N; i++){
      long a;
      a = sc.nextInt();
      if (isPrimeNumber(a)) {
        ans = lcm(ans, a);
      }
    }
    if (ans == 1) System.out.println(-1);
    else System.out.println(ans);
  }
  
  public static boolean isPrimeNumber(long x) {
    for(long i = 2; i <= Math.sqrt(x); i++) {
      if(x % i == 0) {
        return false;
      }
    }
    return true;
  }

  // public static long gcd(long x, long y) {
  //   while (y!=0){
  //     long temp = x % y;
  //     x = y;
  //     y = temp;
  //   }
  //   return x;
  // }
  public static long gcd(long a, long b) {
    if (b == 0) {
        return a;
    } else {
        return gcd(b, a % b);
    }
}
  public static long lcm(long x, long y) {
    return x / gcd(x,y) * y;
  }    
    
  
}