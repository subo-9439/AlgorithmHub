import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] sumA = new int[n + 1], sumB = new int[n + 1];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        long result = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            sumA[i] = Integer.parseInt(st1.nextToken()) + sumA[i - 1];
            sumB[i] = Integer.parseInt(st2.nextToken()) + sumB[i - 1];

            if (sumA[i] == sumB[i]) {
                result++;
            }

            result += map.getOrDefault(sumA[i] - sumB[i], 0);

            map.put(sumA[i] - sumB[i], map.getOrDefault(sumA[i] - sumB[i], 0) + 1);
        }

        System.out.println(result);
    }
}