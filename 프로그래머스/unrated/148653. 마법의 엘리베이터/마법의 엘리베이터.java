class Solution {
    public int solution(int storey) {
        int answer = 0;
        int m = 10;

        while (storey>0 ) {
            int mod = storey%m;
            //5이상일 때 앞의 자리수에 1을 더해주고(자리수 올림),
            // answer은 그 자리수 - 나머지만큼 더해준다.
            // 올림을 해줬기 때문에 현재 자리는 0으로 초기화
            if (mod > 5 ) {
                answer += (m-mod);
                storey = (storey+mod)/m;
            }else if(mod < 5){
                answer += mod;
                storey /= m;
            }else { //5일 때는 앞의 자리에 따라 달라짐
                if (storey % 100 > 50){
                    answer += (m-mod);
                    storey = (storey+mod)/m;
                }else {
                    answer += mod;
                    storey /= m;
                }
            }
//            System.out.println("storey = " + storey + " answer = " + answer);
        }

        return answer;
    }
}