package src.week_33;

import java.util.HashMap;

/**
 * 프로그래머스 - 스킬트리
 */
public class Pro49993 {

    static int res;

    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

    public static int solution(String skill, String[] skill_trees) {
        HashMap<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < skill.length(); i++) {
            char tmp = skill.charAt(i);
            orderMap.put(tmp, i);
        }
        for (String skillTree : skill_trees) {
            int index = 0;
            boolean flag = false;
            for (int i = 0; i < skillTree.length(); i++) {
                char cmp = skillTree.charAt(i);
                if (orderMap.containsKey(cmp)) {
                    if (orderMap.get(cmp) == index) {
                        index++;
                    } else {
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag)
                res++;
        }
        return res;
    }
}
