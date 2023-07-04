package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 백준 3052번 나머지
 */
public class Pro3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            int tmp = Integer.parseInt(br.readLine()) % 42;
            if (!set.contains(tmp)) {
                cnt++;
                set.add(tmp);
            }
        }
        System.out.println(cnt);
    }
}
