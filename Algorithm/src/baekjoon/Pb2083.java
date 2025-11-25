package baekjoon;

import java.util.*;
import java.io.*;

public class Pb2083 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> res = new ArrayList<>();
        while(true) {
            String input = br.readLine();

            if(input.equals("# 0 0")) break;

            String[] value = input.split(" ");
            String name = value[0];
            int age = Integer.parseInt(value[1]);
            int weight = Integer.parseInt(value[2]);

            if(age > 17 || weight >= 80) {
                res.add(name + " Senior");
            } else {
                res.add(name + " Junior");
            }
        }

        for(String r: res) {
            System.out.println(r);
        }
    }
}
