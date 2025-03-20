import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        // int[] answer = {};
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> termMap = new HashMap<>();
        
        //약관의 유효기관 정리
        for(int i = 0 ; i < terms.length; i++){
            String[] temp = terms[i].split(" ");
            termMap.put(temp[0],Integer.parseInt(temp[1]));
        }
        String[] todaySplit = today.split("\\.");
        int todayValue = Integer.parseInt(todaySplit[0]) * 12 * 28 + Integer.parseInt(todaySplit[1]) * 28 + Integer.parseInt(todaySplit[2]);
        for(int i = 0; i < privacies.length; i++) {
            String[] temp = privacies[i].split(" ");
            String[] date = temp[0].split("\\.");
            String term = temp[1];
            
            int year = Integer.parseInt(date[0]) * 12 * 28;
            int month = Integer.parseInt(date[1]) * 28;
            int day = Integer.parseInt(date[2]);
            
            if(todayValue >= year + month + day + termMap.get(term)*28) answer.add(i+1);
        }
        return answer;
    }
}