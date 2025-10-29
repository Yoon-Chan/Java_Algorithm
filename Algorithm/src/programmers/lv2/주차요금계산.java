package programmers.lv2;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/92341
public class 주차요금계산 {
    Map<Integer, Integer> parkInOut;
    Map<Integer, Integer> parkFee;
    public int[] solution(int[] fees, String[] records) {
        parkInOut = new HashMap<>();
        parkFee = new HashMap<>();
        int lastTime = stringToInt("23:59");

        for(String record: records) {
            String[] info = record.split(" ");
            String type = info[2];
            int time = stringToInt(info[0]);
            int number = Integer.parseInt(info[1]);

            if(type.equals("IN")) {
                parkInOut.put(number, time);
            } else {
                int inTime = parkInOut.get(number);
                parkFee.put(number, parkFee.getOrDefault(number, 0) + (time - inTime));
                parkInOut.remove(number);
            }
        }

        for(int key: parkInOut.keySet()) {
            int inTime = parkInOut.get(key);
            parkFee.put(key, parkFee.getOrDefault(key, 0) + (lastTime - inTime));
        }

        List<int[]> res = new ArrayList<>();
        for(int key: parkFee.keySet()) {
            int time = parkFee.get(key);
            int c = (int)Math.ceil((double)(time - fees[0]) / fees[2]);

            int count = (time - fees[0]) <= 0 ? fees[1] : fees[1] + (c) * fees[3];
            res.add(new int[] { key, count});
        }

        Collections.sort(res, (o1, o2) -> o1[0] - o2[0]);

        int[] answer = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i)[1];
        }
        return answer;
    }

    public int stringToInt(String time) {
        String[] hm = time.split(":");
        return Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
    }
}
