import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] whanHo = scores[0];

        // 점수 내림차순 정렬: 첫 번째 점수 기준, 같으면 두 번째 점수 오름차순
        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });

        int maxB = -1;
        List<int[]> validList = new ArrayList<>();

        for (int[] score : scores) {
            if (score[1] < maxB) {
                if (score == whanHo) return -1;
                continue;
            } else {
                maxB = Math.max(maxB, score[1]);
                validList.add(score);
            }
        }

        // 총점 기준 내림차순 정렬
        validList.sort((a, b) -> {
            int sumA = a[0] + a[1];
            int sumB = b[0] + b[1];
            return Integer.compare(sumB, sumA);
        });

        int rank = 1;
        int prevSum = -1;
        int sameRankCount = 0;

        for (int i = 0; i < validList.size(); i++) {
            int sum = validList.get(i)[0] + validList.get(i)[1];

            if (sum != prevSum) {
                rank += sameRankCount;
                sameRankCount = 1;
                prevSum = sum;
            } else {
                sameRankCount++;
            }

            if (Arrays.equals(validList.get(i), whanHo)) {
                return rank;
            }
        }

        return -1; // 이론상 도달하지 않음
    }
}
