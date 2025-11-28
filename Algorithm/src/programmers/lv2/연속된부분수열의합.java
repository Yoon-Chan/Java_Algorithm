package programmers.lv2;

//https://school.programmers.co.kr/learn/courses/30/lessons/178870
public class 연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[] {0, 0};

        int startIndex = 0;
        int endIndex = 0;
        int sum = sequence[0];
        int size = Integer.MAX_VALUE;
        while(true) {
            // System.out.println("startIndex : " + startIndex + ", endIndex : " + endIndex + ", sum : " + sum);
            if(sum == k) {
                int res = endIndex - startIndex;

                if(size > res) {
                    answer = new int[] { startIndex, endIndex};
                    size = res;
                }
                endIndex++;
                if(endIndex >= sequence.length) break;
                sum += sequence[endIndex];
                continue;
            } else if(sum < k) {
                endIndex++;
                if(endIndex >= sequence.length) break;

                sum += sequence[endIndex];
            } else {
                if(startIndex == endIndex) {
                    endIndex++;
                    if(endIndex >= sequence.length) break;
                    sum += sequence[endIndex];
                } else {
                    sum -= sequence[startIndex];
                    startIndex++;
                }
            }
        }

        return answer;
    }
}
