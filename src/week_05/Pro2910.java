package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 2910번 빈도 정렬
 */
public class Pro2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        ArrayList<Integer> arr = new ArrayList<>(map.keySet());

        Collections.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                //list.get(b) 와 list.get(a)의 위치가 바뀌면 오름차순이 된다.
                return Integer.compare(map.get(b), map.get(a));
            }
        });
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < map.get(arr.get(i)); j++) {
                sb.append(arr.get(i) + " ");
            }
        }
        System.out.println(sb);
    }
}