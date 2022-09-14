import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Arrays.sort(arr);

        int l = 1; // 최소로 가질 수 있는 거리
        int r = arr[arr.length - 1] - arr[0]; //최대로 가질 수 있는 거리
        /*
            위 l/r을 기준으로, 가질 수 있는 거리를 이분탐색한다. (탐색위치는 대충 x라 하자)
            좀 더 구체적으로 말해서, 지금 하고 싶은 건, 설치가 가능하면서도 가장 큰 거리 찾기 & 불가능한건 가능한 빠르게 제끼기.
            위의 요구사항을 감안해서 실행 계획을 짜보자.

            탐색위치에서 c개만큼 설치가 가능한지,
                가능하다면 -> l = 가능했던 위치 + 1; //가능한 위치를 하나씩 올릴거야, 불가능할 때까지 / '불가능해지는 위치 - 1' = '가능한 최대 간격')
                불가능하다면 -> r = 불가능했던 위치; //불가능했던 위치는 더 고려할 필요가 없다 && l이 r(불가능해지는 위치)까지 올라오는 시점을 체크할 용도
        */
        int ans = 0;
        while (l <= r) {     //4 5
            int x = (r + l) / 2; //4

            if (canInstall(arr, x, c)) { // 설치가 가능한지 : 가능
                l = x + 1;
                ans = x;
            }
            else { // 설치가 불가능
                r = x-1;
            }
        }

        System.out.println(ans); // (불가능해지는 간격 - 1) => 가능한 최대 간격
    }

    private static boolean canInstall(int[] arr, int x, int c) {
        int count = 1; //처음 한 개는 무조건 설치
        int installed = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (installed + x <= arr[i]) {
                installed = arr[i];
                count++;
            }
            if (count == c) return true;
        }
        return false;
    }

}