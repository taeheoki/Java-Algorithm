package src.week_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * BOJ 4358 - 생태학
 */
public class Pro4358 {
    static Map<String, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        while (true) {
            String tmp = br.readLine();
            if (tmp == null || tmp.isEmpty())
                break;
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            cnt++;
        }
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.printf("%s %.4f\n", key, (map.get(key) * 100.0) / cnt);
        }
    }
}
