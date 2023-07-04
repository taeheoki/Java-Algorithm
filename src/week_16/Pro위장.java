package src.week_16;

import java.util.*;

/**
 * 프로그래머스 - 위장
 * 문제 이해:
 */
public class Pro위장 {
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }

    public static int solution(String[][] clothes) {
        Map<String, Integer> clothCnt = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            clothCnt.put(clothes[i][1], clothCnt.getOrDefault(clothes[i][1], 0) + 1);
        }
        int sum = 1;
        Set<String> categorys = clothCnt.keySet();
        for (String category : categorys) {
            sum *= (clothCnt.get(category) + 1);
        }
        return sum - 1;
    }
}
