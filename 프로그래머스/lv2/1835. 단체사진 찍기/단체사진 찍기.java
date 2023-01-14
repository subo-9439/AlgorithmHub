import java.util.Arrays;

//
class Solution {
    private int answer = 0;
    private String[] friends = {"A","C","F","J","M","N","R","T"};

    public int solution(int n, String[] data) {
        boolean[] isVisited = new boolean[8];
        dfs("",isVisited,data);
        System.out.println(answer);
        return answer;
    }

    private void dfs(String name, boolean[] isVisited, String[] data) {
        if (name.length() == 8) {
            if (check(name,data)) answer++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(name + friends[i], isVisited, data);
                isVisited[i] = false;
            }
        }
    }
    //사진찍을 때 프렌즈들 간격이 주어진 조건에 충당하지 않으면 false
    private boolean check(String name, String[] data) {
        for (String str : data) {
            int pos1 = name.indexOf(str.charAt(0)); // 프렌즈 포지션 1번째자리
            int pos2 = name.indexOf(str.charAt(2)); // 프렌즈 포지션 3번째자리

            char operator = str.charAt(3);   // 등호 부등호
            int dist = str.charAt(4)-'0'; // 간격
            if (operator == '=' && !(Math.abs(pos1 - pos2) == dist+1)) return false;
            if (operator == '>' && !(Math.abs(pos1 - pos2) > dist+1)) return false;
            if (operator == '<' && !(Math.abs(pos1 - pos2) < dist+1)) return false;
        }
        return true;
    }
}