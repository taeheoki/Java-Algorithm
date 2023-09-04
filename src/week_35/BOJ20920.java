package src.week_35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * BOJ 20920 - 영단어 암기는 어려워
 */
public class BOJ20920 {
    static int N, M;
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        List<String> words = map.keySet().stream().collect(Collectors.toList());

        Collections.sort(words, (a, b) -> {
            int num1 = map.get(a);
            int num2 = map.get(b);

            if (num1 == num2) {
                if (b.length() == a.length())
                    return a.compareTo(b);
                return b.length() - a.length();
            }
            return num2 - num1;
        });

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append('\n');
        }
        System.out.println(sb);
    }
}
