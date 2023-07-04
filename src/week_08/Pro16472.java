package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 16472 - 고냥이
 */
public class Pro16472 {
    static int N, kind;
    static String arr;
    static int[] cnt = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = br.readLine();
        pro();
    }

    static void add(char x) { // x 라는 알파벳 추가
        cnt[x - 'a']++;
    }

    static void erase(char x) { // x 라는 알파벳 제거
        cnt[x - 'a']--;
    }

    private static void pro() {
       int len = arr.length(), ans = 0;
       for (int R = 0, L = 0; R < len; R++) {
            // R 번째 문자를 오른쪽에 추가
            add(arr.charAt(R));

            // 불가능하면, 가능할 때까지 L을 이동
            while (true) {
                kind = 0;
                for (int i = 0; i < 26; i++) {
                    if (cnt[i] != 0) kind++;
                }
                if (kind <= N) break;
                erase(arr.charAt(L));
                L++;
            }

            // 정답 갱신
            ans = Math.max(ans, R - L + 1);
       }
       System.out.println(ans);
    }

//    private static void pro() {
//        int len = arr.length(), ans = 0;
//        int possible = 0;
//        for (int R = 0, L = 0; R < len; R++) {
//            // R 번째 문자를 오른쪽에 추가
//            cnt[arr.charAt(R) - 'a']++;
//
//            // 불가능하면, 가능할 때까지 L을 이동
//            if (cnt[arr.charAt(R) - 'a'] == 1)
//                possible++;
//            while (possible == N + 1 && L < R) {
//                cnt[arr.charAt(L) - 'a']--;
//                if (cnt[arr.charAt(L) - 'a'] == 0)
//                    possible--;
//                L++;
//            }
//
//            // 정답 갱신
//            ans = Math.max(ans, R - L + 1);
//        }
//        System.out.println(ans);
//    }
}
