import jdk.jshell.execution.FailOverExecutionControlProvider;

import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        //신고 기록 초기화
        HashMap<String, Integer> reportMap = new HashMap<>();
        HashMap<String, Integer> answerMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            reportMap.put(id_list[i],0);
            answerMap.put(id_list[i],0);
        }
        
        //리포트 기록 담기
        for (int i = 0 ; i < report.length; i++){
            StringTokenizer st = new StringTokenizer(report[i] , " ");
            String from = st.nextToken();
            String to = st.nextToken();

            reportMap.put(to, reportMap.get(to) + 1);
            if(reportMap.get(to) >= k){
                answerMap.put(from,answerMap.get(from) + 1);
            }
        }
        for (int i = 0; i < id_list.length; i++){
            answer[i] = answerMap.get(id_list[i]);
        }
        return answer;
    }

}