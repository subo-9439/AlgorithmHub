// 금토일 월화 수목
// 5 6 7 1 2 3 4
// 0 1 2 3 4 5 6 idx+startday로 요일을 구할 수 있다.

//
// 7        
// 0 1 2 3 4 5 6
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int count = 0;
        for (int i = 0; i < timelogs.length; i++) {
            int hour = schedules[i]/100 * 100;
            int minute = schedules[i] % 100 + 10;
            int schedule = hour;
            schedule += (minute >= 60 ? 100 + minute % 60  : minute);
            for (int j = 0; j < timelogs[i].length; j++) {
                int day = j+startday;
                if(day % 7 == 6 || day % 7 == 0) {
                    continue;
                }
                if(timelogs[i][j] > schedule) {
                    count++;
                    break;
                }
            }
        }
        return schedules.length-count;
    }
}