import java.util.Collections;
import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        //R ,T
        //C, F
        //J, M
        //A, N
        HashMap<Character,Integer> hashMap = new HashMap<>(){{
            put('R',0);            put('T',0);
            put('C',0);            put('F',0);
            put('J',0);            put('M',0);
            put('A',0);            put('N',0);
        }};

        for (int i = 0; i < choices.length ;i++){
            char a = survey[i].charAt(0);
            char b = survey[i].charAt(1);
            if (choices[i] < 4) {   //a점수가 올라가야함
                hashMap.put(a,hashMap.get(a)+Math.abs(choices[i]-4));
            }else {
                hashMap.put(b,hashMap.get(b)+Math.abs(choices[i]-4));
            }
        }

        answer += hashMap.get('R') >= hashMap.get('T') ? "R" : "T";
        answer += hashMap.get('C') >= hashMap.get('F') ? "C" : "F";
        answer += hashMap.get('J') >= hashMap.get('M') ? "J" : "M";
        answer += hashMap.get('A') >= hashMap.get('N') ? "A" : "N";
        return answer;
    }
}