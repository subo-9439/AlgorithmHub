import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        //가공을 좀해야한다.

        List<String[]> list = Arrays.stream(musicinfos).map(s -> {
            String a[] = s.split(",");
            //a[0] = 시작시간
            //a[1] = 끝나는시간
            //a[2] = 음악제목
            //a[3] = 패턴정보
            String temp = "";
            for (int i = 0; i < a[3].length() ; i++) {
                if (i == a[3].length()-1){
                    temp += a[3].charAt(i);
                    break;
                }
                if (a[3].charAt(i + 1) == '#') {
                    temp += (char) (a[3].charAt(i) + 32);
                    i++;
                } else {
                    temp += a[3].charAt(i);
                }
            }
            a[3] = temp;

            return a;
        }).filter(a -> {
            String newM = "";
            for (int i = 0 ; i < m.length(); i++){
                if (i == m.length()-1){
                    newM += m.charAt(i);
                    break;
                }
                if (m.charAt(i+1) == '#'){
                    newM += (char)(m.charAt(i)+32);
                    i++;
                }else {
                    newM += m.charAt(i);
                }
            }
            String[] start = a[0].split(":");
            String[] end = a[1].split(":");
            String title = a[2];
            String pattern = a[3];

            //1. 패턴 주기 파악
            int hour = Integer.parseInt(end[0]) - Integer.parseInt(start[0]); // 시간
            int minutes = Integer.parseInt(end[1]) - Integer.parseInt(start[1]) + hour * 60; //분
            //2. 패턴과 m 비교
            //어떻게 하면 좋을까 ... 패턴을 우선 플레이 타임만큼 늘려주자
            String music = pattern;
            while (music.length() < minutes) {
                music += pattern.repeat(1);
            }
            music = music.substring(0, minutes); //넘치는 부분은 자르자

            if (music.contains(newM)) return true;
            return false;
        }).collect(Collectors.toList());

        return list.stream().sorted((o1, o2) -> {
            //시간이 긴순서대로
            //
            String[] startA = o1[0].split(":");
            String[] endA = o1[1].split(":");
            String[] startB = o2[0].split(":");
            String[] endB = o2[1].split(":");

            int hourA = Integer.parseInt(endA[0]) - Integer.parseInt(startA[0]); // 시간
            int minutesA = Integer.parseInt(endA[1]) - Integer.parseInt(startA[1]) + hourA * 60; //분
            int hourB = Integer.parseInt(endB[0]) - Integer.parseInt(startB[0]); // 시간
            int minutesB = Integer.parseInt(endB[1]) - Integer.parseInt(startB[1]) + hourB * 60; //분
            return minutesB-minutesA;
        }).map(o -> o[2]).findFirst().orElse("(None)").toString();
    }
}