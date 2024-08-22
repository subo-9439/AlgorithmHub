import java.util.*;

public class Main {
    public static int N, M;
    public static int[] arr = new int[4001];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        for (int i = 1; i <= N; i++) arr[i] = sc.nextInt();
        
        while (M-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            if (a == 1) arr[b] = c;
            //2일경우에는 xor 이용하여 변경, 3일경우:전부끄기(0), 4일경우:전부켜기(1)
            else for (int j = b; j <= c; j++) arr[j] = (a == 2) ? arr[j] ^ 1 : (a == 3) ? 0 : 1;
        }
        
        for (int i = 1; i <= N; i++) System.out.print(arr[i] + " ");
    }
}