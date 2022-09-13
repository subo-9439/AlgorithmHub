import javax.swing.*;
import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        int[][] arr = new int[4][3];
        //info 1~50000
        //개발언어(3) 직군(2) 경력(2) 소울푸드(2) 점수(1~100000)
        //javabackendjuniorpizza, List(150,220);
        //4*3*3*3 108개
        HashMap<String,ArrayList<Integer>> map = new HashMap<>();
        String[] set1 = new String[]{"cpp","java","python","-"};
        String[] set2 = new String[]{"backend", "frontend","-"};
        String[] set3 = new String[]{"junior", "senior","-"};
        String[] set4 = new String[]{"chicken","pizza","-"};
        for (int i = 0 ; i < set1.length; i++){
            for (int i1 = 0; i1 < set2.length; i1++) {
                for (int i2 = 0; i2 < set3.length; i2++) {
                    for (int i3 = 0; i3 < set4.length; i3++) {
                        map.put(set1[i]+set2[i1]+set3[i2]+set4[i3],new ArrayList<>());
                    }
                }
            }
        }


        for (int i = 0; i < info.length; i++){
            String[] set = info[i].split(" ");
            String lang = set[0];
            String field = set[1];
            String career = set[2];
            String food = set[3];
            Integer score = Integer.parseInt(set[4]);
            String name = lang+field+career+food;
            if (map.containsKey(name)){
                map.get(name).add(score);
            }   else {
                map.put(name,new ArrayList<>(){{add(score);}});
            }
        }
        for (String key: map.keySet()){
            Collections.sort(map.get(key));
        }
        for (int i = 0; i < query.length; i++){
            String[] set = query[i].split(" ");
            ArrayList<String> names1 = new ArrayList<>();
            ArrayList<String> names2 = new ArrayList<>();
            ArrayList<String> names3 = new ArrayList<>();
            ArrayList<String> names4 = new ArrayList<>();
            String lang = set[0].equals("-") ? "" : set[0];
            if(set[0].equals("-")) {
                names1.add(("cpp"));
                names1.add(("java"));
                names1.add(("python"));
            }else {
                names1.add((set[0]));
            }
            String field = set[2].equals("-") ? "" : set[2];
            if (set[2].equals("-")) {
                for (int j = 0; j < names1.size();j++){
                    names2.add( (names1.get(j) + ("backend")));
                    names2.add( (names1.get(j) + ("frontend")));
                }
            }else {
                for (int j = 0; j < names1.size(); j++){
                    names2.add( (names1.get(j) + (field)));
                }
            }
            String career = set[4].equals("-") ? "" : set[4];
            if (set[4].equals("-")) {
                for (int j = 0; j < names2.size();j++){
                    names3.add(names2.get(j)+("senior"));
                    names3.add(names2.get(j)+("junior"));
                }
            }else {
                for (int j = 0; j < names2.size(); j++){
                    names3.add(names2.get(j)+(career));
                }
            }
            String food = set[6].equals("-") ? "" : set[6];
            if (set[6].equals("-")) {
                for (int j = 0; j < names3.size();j++){
                    names4.add(names3.get(j)+("chicken"));
                    names4.add(names3.get(j)+("pizza"));
                }
            }else {
                for (int j = 0; j < names3.size(); j++){
                    names4.add(names3.get(j)+(food));
                }
            }
            Integer score = Integer.parseInt(set[7]);
            String name = lang+field+career+food;
            int cnt = 0;
            for (String key : names4){
                if (!map.containsKey(key.toString())) continue;
                if (map.get(key).isEmpty())continue;
                ArrayList<Integer> scores = map.get(key);     //점수들의 집합
                    int L = 0, R = map.get(key).size()-1;
                    while (L<=R){
                        int mid = (L+R)/2;
                        if (scores.get(mid) < score){
                            L = mid+1;
                            cnt = mid;
                        }else {
                            R = mid-1;
                            cnt = mid;
                        }
                    }
//                for (Integer num : map.get(key.toString())){
//                    if (num >= score){
//                        cnt++;
//                    }
//                }
                answer[i] += scores.size() - L;
//                System.out.println("key = " + key + " answer = " +answer[i]);
            }
//            System.out.println("===============");
//            names4.forEach(System.out::println);
//            System.out.println("====================");
        }
        return answer;
    }

}