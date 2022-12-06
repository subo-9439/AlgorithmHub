
/* *
//TODO(x) 회의실 배정 알고리즘
*  소모 피로도 오름차순(1), 최소 필요 피로도 내림차순(2)
// 이렇게 하면 안되네
//Todo(o) 완전탐색으로 ㄱㄱ -> 순열

* */
class Solution {
    int ans = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] isVisited = new boolean[dungeons.length];
        permutation(k,dungeons,isVisited,0,0);
        return ans;
    }

    public void permutation(int hp, int[][] dungeons, boolean[] isVisited,int count, int idx){
        if (idx == dungeons.length) {
            ans = Math.max(count,ans);
        }else {
            for (int i = 0 ; i < dungeons.length; i++) {
                if (isVisited[i]) continue;
                if (hp >= dungeons[i][0]){
                    isVisited[i] = true;
                    permutation(hp- dungeons[i][1], dungeons, isVisited, count+1, idx+1);
                    isVisited[i] = false;
                }else {
                    permutation(hp, dungeons, isVisited, count, idx + 1);
                }
            }
        }
    }
}