package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 백준 5597번 과제 안 내신분..?
 */
public class Pro5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 28; i++)
            set.add(Integer.parseInt(br.readLine()));
        for (int i = 0; i < 30; i++) {
            if (!set.contains(i + 1))
                sb.append(i + 1 + "\n");
        }
        System.out.println(sb);
    }
}
