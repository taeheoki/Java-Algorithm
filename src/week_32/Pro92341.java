package src.week_32;

import java.util.*;

/**
 * 프로그래머스 - 주차 요금 계산
 */
public class Pro92341 {

    static int[] res;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}));
    }

    public static int[] solution(int[] fees, String[] records) {
        // 차 번호, 입차 시간
        HashMap<String, Integer> hashMap = new HashMap<>();
        // 차 번호, 총 시간
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        for (String record : records) {
            String[] arr = record.split(" ");
            if (arr[2].equals("IN")) {
                String[] split = arr[0].split(":");
                int inTime = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
                hashMap.put(arr[1], inTime);
            } else {
                String[] split = arr[0].split(":");
                int outTime = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
                treeMap.put(arr[1], treeMap.getOrDefault(arr[1], 0) + outTime - hashMap.get(arr[1]));
                hashMap.remove(arr[1]);
            }
        }

        // 출차하지 않은 차량 고려
        for (String s : hashMap.keySet())
            treeMap.put(s, treeMap.getOrDefault(s, 0) + 23 * 60 + 59 - hashMap.get(s));
        res = new int[treeMap.size()];
        int i = 0;
        for (String key : treeMap.keySet()) {
            res[i] = treeMap.get(key) - fees[0] > 0 ? (int) (fees[1] + Math.ceil(((double) treeMap.get(key) - fees[0]) / fees[2]) * fees[3]) :
                    fees[1];
            i++;
        }
        return res;
    }
}
