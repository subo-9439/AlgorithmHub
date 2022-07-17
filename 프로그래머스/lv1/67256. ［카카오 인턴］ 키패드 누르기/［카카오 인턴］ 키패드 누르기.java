import java.util.ArrayList;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        //어느 손잡이냐에 따라 출력이 바뀐다.
        //우선 핸드폰 번호를 좌표화하자
        // * -> 10 0 -> 11 # -> 12
        PhonePos[] phoneNum = new PhonePos[13];
        for (int i = 0; i < 4; i++) {
            for (int j = 0 ; j < 3; j++){
                phoneNum[3*i + j+1] = new PhonePos(i,j);
            }
        }

        PhonePos left = phoneNum[10];
        PhonePos right = phoneNum[12];

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i] == 0 ? 11 : numbers[i];

            if (num == 1 || num == 4 || num == 7) {
                answer = answer.concat("L");
            } else if (num == 3 || num == 6 || num == 9) {
                answer = answer.concat("R");
            } else {
                //두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
                int leftDist = Math.abs((left.x - phoneNum[num].x)) + Math.abs((left.y - phoneNum[num].y));
                int rightDist = Math.abs((right.x - phoneNum[num].x)) + Math.abs((right.y - phoneNum[num].y));
                if (leftDist == rightDist) { //같을 때
                    if (hand.equals("right")){
                        answer = answer.concat("R");
                    }else {
                        answer = answer.concat("L");
                    }
                }else {
                    answer = answer.concat(leftDist < rightDist ? "L":"R");
                }
            }
            //이제 손가락 위치를 갱신해주자
            if (answer.charAt(answer.length()-1) == 'L'){
                left = phoneNum[num];
            }else {
                right = phoneNum[num];
            }
        }

        return answer;
    }
    public class PhonePos {
        int x;
        int y;
        public PhonePos(int x , int y){
            this.x = x;
            this.y = y;
        }
    }
}