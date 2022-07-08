import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int timeTable[][] = new int[N][2];

        for (int i = 0; i < N; i++) {
            timeTable[i][0] = sc.nextInt();
            timeTable[i][1] = sc.nextInt();
        }
        Arrays.sort(timeTable, (a, b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
/*
		System.out.println("종료 시간에 맞춰 정렬");
		for (int i = 0; i < N; i++) {
			System.out.println(timeTable[i][0] + " " + timeTable[i][1]);
		}
*/
        int ans = 0;
        int time = 0;

        for (int i = 0; i < N; i++) {
            // 다음회의시작시각 >= 이전회의종료시각
            if (timeTable[i][0] >= time) {
                time = timeTable[i][1];
                ans++;
            }
        }
        System.out.println(ans);
    }
}