package src.week_15;

import java.util.*;

/**
 * 프로그래머스 - 압축
 */
public class Pro압축 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("KAKAO")));
        System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println(Arrays.toString(solution("ABABABABABABABAB")));
    }

    public static int[] solution(String msg) {
        List<Integer> arr = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            String tmp = String.valueOf((char) ('A' + i - 1));
            map.put(tmp, i);
        }
        pro(map, msg, arr);
        return arr.stream().mapToInt(i -> i).toArray();
    }

    private static void pro(Map<String, Integer> map, String msg, List<Integer> arr) {
        for (int i = 0; i < msg.length(); i++) {
            int j = 1;
            int index = 0;
            while (i + j <= msg.length() && map.containsKey(msg.substring(i, i + j))) {
                index = map.get(msg.substring(i, i + j));
                j++;
            }
            arr.add(index);
            if (i + j <= msg.length() && !map.containsValue(msg.substring(i, i + j))) {
                map.put(msg.substring(i, i + j), map.size() + 1);
            }
            i += j - 2;
        }
    }
}
