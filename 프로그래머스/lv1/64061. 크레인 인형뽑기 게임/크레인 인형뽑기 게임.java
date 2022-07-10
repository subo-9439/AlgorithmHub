import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        //스택에 담아주기
        for (int i = 0; i < moves.length; i++){
            int col = moves[i]-1;
            for (int row = 0; row < board.length; row++){
                if (board[row][col] == 0 ) continue;
                stack.add(board[row][col]); //스택에 넣어주고
                board[row][col] = 0;        //board에서 지워준다.
                break;
            }
        }
        //stack 정리해주기
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()){
            if (!temp.isEmpty() && stack.peek().equals(temp.peek())) {
                //두개 터뜨려주고
                stack.pop();
                temp.pop();
                answer += 2;
                // temp에 마지막을 다시 넣어줌으로써 연속적으로 터질 수 있는지 본다.
                if (!temp.isEmpty()) {
                    stack.add(temp.pop());
                }
            }
            if (!stack.isEmpty()) {
                temp.add(stack.pop());
            }
        }

        return answer;
    }
}