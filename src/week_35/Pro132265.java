package src.week_35;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 프로그래머스 - 롤케이크 자르기
 */
public class Pro132265 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
        System.out.println(solution(new int[]{1, 2, 3, 1, 4}));
    }

    public static int solution(int[] topping) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int toppingType : topping) {
            map.put(toppingType, map.getOrDefault(toppingType, 0) + 1);
        }
        // 철수 동생
        for (int toppingType : topping) {
            set.add(toppingType);
            map.put(toppingType, map.get(toppingType) - 1);
            if (map.get(toppingType) == 0)
                map.remove(toppingType);
            if (map.size() == set.size())
                answer++;
        }
        return answer;
    }
}
