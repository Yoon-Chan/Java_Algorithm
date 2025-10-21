package programmers.lv3;

import java.util.*;


//https://school.programmers.co.kr/learn/courses/30/lessons/43163
/*
    bfs를 이용해 각 단어의 차이가 1일 때만 add하는 방식 사용(한 번 방문한 단어는 접근 못하도록 변경)
    그리고 target과 같을 때 answer에 count를 적용해 답을 도출했다.
* **/
public class 단어변환 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        boolean[] visited = new boolean[words.length];
        Queue<WordInfo> queue = new LinkedList<>();

        queue.add(new WordInfo(begin, 0));

        while(!queue.isEmpty()) {
            WordInfo word = queue.poll();

            if(word.word.equals(target)) {
                answer = word.count;
                break;
            }

            for(int i = 0; i < words.length; i++) {
                if(!visited[i]) {
                    int cnt = 0;
                    String[] t = word.word.split("");
                    String[] n = words[i].split("");

                    for(int j = 0; j < t.length; j++) {
                        if(!t[j].equals(n[j])) {
                            cnt++;
                        }
                    }

                    if(cnt == 1) {
                        visited[i] = true;
                        queue.add(new WordInfo(words[i], word.count + 1));
                    }
                }
            }
        }


        return answer;
    }

    class WordInfo {
        String word;
        int count;

        public WordInfo(String word, int count) {
            this.word = word;;
            this.count = count;
        }
    }
}
