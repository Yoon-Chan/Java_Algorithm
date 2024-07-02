package programmers;
import java.util.*;

public class pb03 {
    //두 개 뽑아서 더하기
    //https://school.programmers.co.kr/learn/courses/30/lessons/68644
    class Solution {
        public int[] solution(int[] numbers) {
            Set<Integer> set = new HashSet<>();

            for(int i = 0; i < numbers.length; i++) {
                for(int j = i + 1; j < numbers.length; j++) {
                    set.add(numbers[i] + numbers[j]);
                }
            }

            return set.stream().sorted().mapToInt(Integer::intValue).toArray();
        }
    }
}
