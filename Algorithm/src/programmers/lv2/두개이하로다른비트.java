package programmers.lv2;

//https://school.programmers.co.kr/learn/courses/30/lessons/77885#
public class 두개이하로다른비트 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];


        // String s = "11111111111";
        // int index = s.lastIndexOf("01");
        // System.out.println(index);

        for(int i = 0; i < numbers.length; i++) {
            String count = Long.toBinaryString(numbers[i]);

            if(count.charAt(count.length() - 1) == '0') {
                answer[i] = numbers[i] + 1;
            } else if(count.lastIndexOf("01") != -1) {
                // System.out.println("2");
                int index = count.lastIndexOf("01");
                String next = count.substring(0, index) + "10";
                if(index + 2 < count.length()) {
                    next += count.substring(index + 2);
                }

                answer[i] = Long.parseLong(next, 2);
            } else {
                // System.out.println("3");
                long a = 1L << (count.length());
                long b = 1L << (count.length() - 1);

                answer[i] = a + numbers[i] - b;
            }
        }
        return answer;
    }

    //내가 시도했다가 10,11번 시간초과나는 코드
    public long[] solution2(long[] numbers) {
        long[] answer = new long[numbers.length];

        // long num = 50 ^ 56;
        // String count = Long.toBinaryString(num).replace("0", "");
        // System.out.println(count);

        for(int i = 0; i < numbers.length; i++) {
            long start = numbers[i] + 1;

            while(true) {
                String count = Long.toBinaryString(numbers[i] ^ start).replace("0", "");
                if(count.length() <= 2) {
                    break;
                }

                start++;
            }

            answer[i] = start;
        }
        return answer;
    }
}
