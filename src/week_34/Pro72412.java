package src.week_34;

import java.util.*;

/**
 * 프로그래머스 - 순위 검색
 */
public class Pro72412 {
    static HashMap<String, List<Integer>> map;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"}, new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"})));

    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();

        for (int i = 0; i < info.length; i++) {
            String[] p = info[i].split(" ");
            makeCandidate(p, "", 0);
        }

        for (String key : map.keySet())
            Collections.sort(map.get(key));

        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replace(" and ", "");
            String[] q = query[i].split(" ");
            answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }

        return answer;
    }

    private static int binarySearch(String key, int num) {
        List<Integer> list = map.get(key);
        int start = 0, end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < num)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return list.size() - start;
    }

    private static void makeCandidate(String[] p, String str, int cnt) {
        if (cnt == 4) {
            if (!map.containsKey(str)) {
                List<Integer> list = new ArrayList<>();
                map.put(str, list);
            }
            map.get(str).add(Integer.parseInt(p[4]));
            return;
        }
        makeCandidate(p, str + "-", cnt + 1);
        makeCandidate(p, str + p[cnt], cnt + 1);
    }
}
