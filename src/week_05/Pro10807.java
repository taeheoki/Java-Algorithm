package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 백준 10807번 개수 세기
 */
public class Pro10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        int v = Integer.parseInt(br.readLine());
        if (map.containsKey(v))
            System.out.println(map.get(v));
        else
            System.out.println(0);
    }
}
