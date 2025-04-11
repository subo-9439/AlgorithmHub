import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        int cardCount = n/3;
        Set<Integer> cardSet = new HashSet();
        Set<Integer> canUseCardSet = new HashSet();
        //1. cardCount만큼 카드뽑기
        for (int i = 0; i < cardCount; i++) {
            int num = cards[i];
            cardSet.add(num);
        }

        // 라운드 시작
        int round = 0;
        boolean haveToIncreaseRound = false;

        for (int i = n/3; i < cards.length; i+=2) {
            boolean canPass = false; //라운드통과 여부    
            haveToIncreaseRound = false;
            round++; //다음라운드로

            //라운드별로 카드뽑기
            int card1 = cards[i];
            int card2 = cards[i+1];
            int pairCard1 = n + 1 - card1;
            int pairCard2 = n + 1 - card2;

            //2-. 뽑은카드 1장과 들고있는 카드 1장 비교
            if(cardSet.contains(pairCard1)) {
                if(coin > 0) {
                    coin--;
                    cardSet.remove(pairCard1);
                    canPass = true;
                    
                }
            } else {
                canUseCardSet.add(card1);
            }
            if(cardSet.contains(pairCard2)) {
                if(canPass && coin > 0) {
                             
                    coin--;
                    cardSet.add(card2);


                    
                }
                if(!canPass && coin > 0){
                    coin--;
                    cardSet.remove(pairCard2);
                    canPass = true;
                }
            }else {
              canUseCardSet.add(card2);
            }


            //4. 여기까지왔는데, 없는경우. 내 카드 뭉치에서 꺼내기 , 사용가능한 카드뭉치에서 꺼내기로 또 비교
            if(!canPass) {
                int spentAmount = canPassUsingCardSet(cardSet,canUseCardSet, n);    

                if(spentAmount != -99 && coin - spentAmount >= 0) {
                    coin -= spentAmount;
                    canPass = true;
                }         
            }
 
            //1. 뽑은카드 2장 비교
                      
            if(!canPass && card1 + card2 == n + 1) {
                if(coin >= 2){
                    canPass = true;
                    coin -= 2;
                    haveToIncreaseRound = true;
                    continue;
                }                 
            }

            if(!canPass) break;



            haveToIncreaseRound = true;
        }
                                
        return haveToIncreaseRound ? round+1 : round;
    }
 
        
    public int canPassUsingCardSet(Set<Integer> cardSet, Set<Integer> canUseCardSet, int n) {
        for (int card : cardSet) {
            int pairCard =  n + 1 - card;
            if (cardSet.contains(pairCard)) {
                cardSet.remove(card);
                cardSet.remove(pairCard);
                return 0;    
            }
            
            if (canUseCardSet.contains(pairCard)) {
                cardSet.remove(card);
                canUseCardSet.remove(pairCard);
                return 1;
            }
        }
        
        for (int card : canUseCardSet) {
            int pairCard =  n + 1 - card;
            if (cardSet.contains(pairCard)) {
                canUseCardSet.remove(card);
                cardSet.remove(pairCard);
                return 1;    
            }
            
            if (canUseCardSet.contains(pairCard)) {
                canUseCardSet.remove(card);
                canUseCardSet.remove(pairCard);
                return 2;
            }
        }
        
        return -99;
    }
}