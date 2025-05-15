import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {   
         if (cacheSize == 0) return cities.length * 5; 
        
        int answer = 0;
        LinkedHashSet<String> cache = new LinkedHashSet<>(cacheSize);

        for (String name : cities) {
            String city = name.toUpperCase();

            if (cache.contains(city)) {
                answer += 1;
                cache.remove(city);
                cache.add(city);
            } else {
                answer += 5;
                if (cache.size() >= cacheSize && !cache.isEmpty()) {
                    Iterator<String> it = cache.iterator();
                    if (it.hasNext()) {
                        it.next();
                        it.remove();
                    }
                }
                cache.add(city);
            }
        }
        
        return answer;
    }
}