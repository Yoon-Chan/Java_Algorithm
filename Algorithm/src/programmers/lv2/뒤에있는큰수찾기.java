package programmers.lv2;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/154539
public class 뒤에있는큰수찾기 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stk = new Stack<>();

        for(int i = 0 ; i < numbers.length; i++) {
            if(stk.isEmpty()) {
                stk.push(i);
            }  else {
                while(!stk.isEmpty() && numbers[i] > numbers[stk.peek()]) {
                    int idx = stk.pop();
                    answer[idx] = numbers[i];
                }
                stk.push(i);
            }
        }

        while(!stk.isEmpty()) {
            int idx = stk.pop();
            answer[idx] = -1;
        }

        return answer;
    }
}
