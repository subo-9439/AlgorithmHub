import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] todayArr = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();
        HashMap<String,Integer> paper = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] temp = terms[i].split(" ");
            String alp = temp[0];
            int month = Integer.parseInt(temp[1]);
            paper.put(alp,month);
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] temp = privacies[i].split(" ");
            int[] date = Arrays.stream(temp[0].split("\\.")).mapToInt(Integer::parseInt).toArray();
            int alpMonth = paper.get(temp[1]);
            //privacy의 월에 달 더하기
            date[0] += alpMonth/12;
            date[1] += alpMonth%12;
            if (date[1] > 12) {
                date[1] -= 12;
                date[0]+=1;
            }
//            데이트: 2021.05 + 05.02  오늘: 2021.10.03 파기해야함
//            2022.05.02 2022.05.02
            //데이트는 오늘 날짜보다 커야함. 작으면 파기
            if (date[0] < todayArr[0]){
                answer.add(i+1);
            }else if(date[0] == todayArr[0]) {
                if (date[1] < todayArr[1]) {
                    answer.add(i+1);
                }else if(date[1] == todayArr[1]) {
                    if (date[2] <= todayArr[2]) {
                        answer.add(i+1);
                    }
                }
            }

        }
        return answer.stream().mapToInt(num -> num).toArray();
    }
}