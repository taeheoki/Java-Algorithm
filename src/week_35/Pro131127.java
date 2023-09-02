package src.week_35;

import java.util.HashMap;

/**
 * 프로그래머스 - 할인 행사
 */
public class Pro131127 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
        System.out.println(solution(new String[]{"apple"}, new int[]{10}, new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}));
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> itemList = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();
        int size = 0;
        for (int i = 0; i < want.length; i++) {
            itemList.put(want[i], number[i]);
            size += number[i];
        }
        for (int i = 0; i < discount.length; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
            if (i >= size) {
                map.put(discount[i - size], map.get(discount[i - size]) - 1);
            }
            if (i >= size - 1) {
                boolean flag = false;
                for (String item : want) {
                    if (itemList.get(item) != map.get(item)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag)
                    answer++;
            }
        }
        return answer;
    }
}
