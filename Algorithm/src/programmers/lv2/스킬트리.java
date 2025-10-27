package programmers.lv2;

import java.util.*;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        int[] trees = new int[26];
        char[] chars = skill.toCharArray();

        List<Character>[] arr = new ArrayList[26];
        for(int i = 0; i < 26; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < chars.length - 1; i++) {
            char a = chars[i];
            char next = chars[i + 1];
            arr[a - 'A'].add(next);
            trees[next - 'A']++;
        }

        for(String sTrees: skill_trees) {
            int[] treeClone = trees.clone();

            char[] skills = sTrees.toCharArray();

            // System.out.println(sTrees);
            boolean check = true;
            for(int i = 0; i < skills.length; i++) {
                int index = skills[i] - 'A';
                // System.out.println("index : " + index);
                if(treeClone[index] != 0) {
                    check = false;
                    break;
                }

                for(char c: arr[index]) {
                    // System.out.println("char : " + index);
                    // System.out.println("c : " + c);
                    treeClone[c - 'A']--;
                }
            }

            if(check) answer++;
        }

        return answer;
    }
}
