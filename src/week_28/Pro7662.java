package src.week_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 7662 - 이중 우선순위 큐
 */
public class Pro7662 {
    static StringBuilder sb = new StringBuilder();
    static int T, k;
    static TreeMap<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char op = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());
                switch (op) {
                    case 'I':
                        map.put(n, map.getOrDefault(n, 0) + 1);
                        break;
                    case 'D':
                        if (map.isEmpty())
                            break;
                        int tmp = n == 1 ? map.lastKey() : map.firstKey();
                        if (map.get(tmp) == 1) {
                            map.remove(tmp);
                        } else {
                            map.put(tmp, map.get(tmp) - 1);
                        }
                        break;
                }
            }
            if (map.isEmpty())
                sb.append("EMPTY");
            else {
                sb.append(map.lastKey()).append(' ').append(map.firstKey());
            }
            if (T != 0)
                sb.append('\n');
            map.clear();
        }
        System.out.println(sb);
    }
}
