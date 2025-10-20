package programmers.lv2;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/17684
/*
    문제가 꽤 직관적이라 쉽게 풀었던 것 같다(한 20분?)

    먼저 map에 알파벳 대문자 정보를 키로, index를 값으로 저장
    이후 새로운 값 넣는 시작이 27번 부터이며 addIndex를 27로 저장

    이후 Queue에 msg의 각 문자열을 하나씩 저장 후
    첫 단어를 poll() 받은 이후 peek()를 더했을 때 map에 존재하지 않을 때까지 반복 -> map에 있는 가장 긴 문자열 가져오기
    이후 해당 값을 res에 저장 후 다음 queue.peek()가 있으면 해당 문자열을 포함한 map에 저장하기(addIndex++)
*
**/
public class 압축 {
    public int[] solution(String msg) {
        int[] answer = {};

        Map<String, Integer> map = new HashMap<>();

        //기본 영문 넣기
        for(int i = 0; i < 26; i++) {
            map.put(String.valueOf((char)('A' + i)), (i + 1));
        }

        // for(String key: map.keySet()) {
        //     System.out.println("key : " + key +", value : " + map.get(key));
        // }

        //기본 정보가 추가될 때마다 인덱스 값 넣기
        int addIndex = 27;

        Queue<String> queue = new LinkedList<>();
        for(String value: msg.split("")) {
            queue.add(value);
        }

        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            StringBuilder sb = new StringBuilder();

            sb.append(queue.poll());

            while(!queue.isEmpty() && map.containsKey(sb.toString() + queue.peek())) {
                sb.append(queue.poll());
            }

            //값 저장하기
            res.add(map.get(sb.toString()));

            //다음 글자 포함한 값이 있으면 추가하기
            // String info = queue.isEmpty() ? sb.toString() : sb.toString() + queue.peek();
            if(!queue.isEmpty() && !map.containsKey(sb.toString() + queue.peek())) {
                map.put(sb.toString() + queue.peek(), addIndex++);
            }
        }

        answer = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }
}
