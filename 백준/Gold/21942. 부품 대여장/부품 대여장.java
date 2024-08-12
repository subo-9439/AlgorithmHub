import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static FastReader scan = new FastReader();
    static HashMap<String, HashMap<String, Integer>> userInfo = new HashMap<>();
    static TreeMap<String, Long> answer = new TreeMap<>();  // int -> long으로 변경
    static int days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        int N = scan.nextInt();
        String rentPeriod = scan.next();
        String[] rentPeriodArr = rentPeriod.split("/");
        String[] dayPeriod = rentPeriodArr[1].split(":");
        int rentCostTime = Integer.parseInt(rentPeriodArr[0]) * 24 * 60 + Integer.parseInt(dayPeriod[0]) * 60 + Integer.parseInt(dayPeriod[1]);
        int rentCost = scan.nextInt();

        for (int i = 0; i < N; i++) {
            // 시간을 분으로 쪼개서 계산하기 쉽게
            int total = 0;
            // 년월일
            String temp = scan.next();
            String[] tempArr = temp.split("-");

            int month = Integer.parseInt(tempArr[1]);
            int day = Integer.parseInt(tempArr[2]);

            // 1월부터 현재 월 이전까지의 일수를 합산
            int monthTime = 0;
            for (int j = 1; j < month; j++) {
                monthTime += days[j] * 24 * 60;
            }

            // 현재 월의 일 수를 계산하여 총 분으로 변환
            int dayTime = (day - 1) * 24 * 60;

            // 시각
            temp = scan.next();
            tempArr = temp.split(":");
            int hourTime = Integer.parseInt(tempArr[0]) * 60;
            int minuteTime = Integer.parseInt(tempArr[1]);
            total = monthTime + dayTime + hourTime + minuteTime;

            // 물건, 유저
            String product = scan.next();
            String user = scan.next();

            // 유저의 물건 정보 꺼내기
            HashMap<String, Integer> productInfo = userInfo.getOrDefault(user, new HashMap<>());
            boolean isRented = productInfo.containsKey(product);
            if (isRented) {
                int rentedTime = productInfo.get(product);
                int gapTime = total - rentedTime;
                int fineTime = gapTime - rentCostTime;
                if (fineTime > 0) {
                    long fine = (long) fineTime * rentCost;  // int -> long으로 변경
                    answer.put(user, answer.getOrDefault(user, 0L) + fine);  // long 사용
                }
                productInfo.remove(product);
            } else {
                productInfo.put(product, total);
            }
            userInfo.put(user, productInfo);
        }
        if (answer.size() > 0) {
            for (Map.Entry<String, Long> entry : answer.entrySet()) {  // int -> long으로 변경
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } else {
            System.out.println(-1);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
