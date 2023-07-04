package src.week_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * BOJ 1484 - 다이어트
 */
public class Pro1484 {
    static int G;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        ArrayList<Long> list = new ArrayList<>();
        for (long i = 1; i <= 100000; i++) {
            for (long j = i + 1; j <= 100000; j++) {
                long tmp = j * j - i * i;
                if (tmp == G)
                    list.add(j);
                else if (tmp > G)
                    break;
            }
        }
        if (list.isEmpty())
            System.out.println(-1);
        else {
            Collections.sort(list);
            for (Long num : list) {
                System.out.println(num);
            }
        }
    }
}
