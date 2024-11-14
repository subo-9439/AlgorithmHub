import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pLength = p.length();
        Long stdNum = Long.parseLong(p); 
        
        for (int i = 0 ; i < t.length() - pLength+1; i++){
            String s = "";
            
            for(int j = i; j < i + pLength; j++){
                s+= t.charAt(j);
            }
            Long num = Long.parseLong(s);
            if(num <= stdNum) answer++;
            // System.out.println(num);
        }

        return answer;
    }
}
