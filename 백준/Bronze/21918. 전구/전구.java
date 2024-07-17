import java.util.*;

public class Main {
    public static int N,M;
    public static int[] arr = new int[4001];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt(); // 명령어
            int b = sc.nextInt(); // 전구번호
            int c = sc.nextInt(); // 키거나 끄기 or 전구번호
            if(a == 1) {//b번에 해당하는 전구 c하기
              arr[b] = c; 
            }else{
              for(int j = b; j <= c; j++) {
                arr[j] = a == 2 ? arr[j] ^ 1 : (a == 3 ? 0 : 1);
              }
            }
        }
        
        for(int i = 1 ; i <= N; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    
}