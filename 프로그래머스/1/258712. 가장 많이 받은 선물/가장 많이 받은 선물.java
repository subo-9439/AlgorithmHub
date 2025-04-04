import java.util.*;

class Solution {
    static HashMap<String,Integer> friendsIdxMap = new HashMap<>();
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        for (int i = 0; i < friends.length; i++) {
            friendsIdxMap.put(friends[i], i);
        }
        // 1. 주고받은 선물 지수를 표로 나타내기
        int[][] giftTable = new int[friends.length][friends.length];   
        for (int i = 0; i < gifts.length; i++) {
            String[] giftArr= gifts[i].split(" ");
            int from = friendsIdxMap.get(giftArr[0]);
            int to = friendsIdxMap.get(giftArr[1]);
            giftTable[from][to]++;
        }
        
        // 2. 선물지수 구하기
        HashMap<String, Integer> giftIndexMap = new HashMap<>();
        for (String name : friendsIdxMap.keySet()) {
            int idx = friendsIdxMap.get(name);
            int giveTotal = 0;
            for (int to = 0; to < friends.length; to++) {
                giveTotal += giftTable[idx][to];
            }
            
            int receiveTotal = 0;
            for (int from = 0; from < friends.length; from++) {
                receiveTotal += giftTable[from][idx];
            }
            giftIndexMap.put(name, giveTotal - receiveTotal);
        }
        
        //3. 다음달 선물받을 사람 구하기
        HashMap<String, Integer> answerMap = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            int count = 0;
            int from = friendsIdxMap.get(friends[i]);
            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;
                int to = friendsIdxMap.get(friends[j]);

                int givenCnt = giftTable[from][to]; //준거
                int receivedCnt = giftTable[to][from]; //받은거
                if (givenCnt > receivedCnt) {
                    count++;
                    continue;
                }
                if (givenCnt == receivedCnt) {
                    int fromGiftIndex = giftIndexMap.get(friends[i]); //받은사람의 선물지수
                    int toGiftIndex = giftIndexMap.get(friends[j]); //준사람의 선물지수
                    if (fromGiftIndex > toGiftIndex) count++;
                    continue;
                }
            }
            answerMap.put(friends[i], count);
        }

        return Collections.max(answerMap.values());
    }
}