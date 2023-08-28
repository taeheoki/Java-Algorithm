package src.week_34;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 프로그래머스 - 메뉴 리뉴얼
 */
public class Pro72411 {
    static boolean[] used;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})));
        System.out.println(Arrays.toString(solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5})));
        System.out.println(Arrays.toString(solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4})));
    }

    public static String[] solution(String[] orders, int[] courses) {
        List<String> result = new ArrayList<>();

        for (int course : courses) {
            for (String order : orders) {
                int n = order.length();
                if (n < course)
                    continue;
                char[] cArr = order.toCharArray();
                used = new boolean[n];
                rec_func(cArr, 0, n, course);
            }
            if (map.isEmpty())
                continue;
            List<String> list = map.keySet().stream().sorted((c1, c2) -> Integer.compare(map.get(c2), map.get(c1))).collect(Collectors.toList());
            int max = map.get(list.get(0));
            if (max == 1)
                continue;
            result.add(list.remove(0));
            for (String s : list) {
                if (map.get(s) < max)
                    break;
                result.add(s);
            }
            map.clear();
        }
        return result.stream().sorted().toArray(String[]::new);
    }

    private static void rec_func(char[] charArray, int start, int n, int r) {
        if (r == 0) {
            refactorMap(charArray, n);
            return;
        }

        for (int i = start; i < n; i++) {
            used[i] = true;
            rec_func(charArray, i + 1, n, r - 1);
            used[i] = false;
        }
    }

    private static void refactorMap(char[] charArray, int n) {
        String s = getSortedString(combineString(charArray, n));
        if (map.containsKey(s)) {
            map.replace(s, map.get(s) + 1);
        } else {
            map.put(s, 1);
        }
    }

    private static String combineString(char[] charArray, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (used[i])
                sb.append(charArray[i]);
        }
        return sb.toString();
    }

    private static String getSortedString(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
