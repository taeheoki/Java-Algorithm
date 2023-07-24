package src.week_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * BOJ 19583 - 싸이버개강총회
 */
public class Pro19583 {
    static int cnt;
    static String S, E, Q;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = st.nextToken();
        E = st.nextToken();
        Q = st.nextToken();
        while (true) {
            String tmp = br.readLine();
            if (tmp == null || tmp.isEmpty())
                break;
            st = new StringTokenizer(tmp);
            String time = st.nextToken();
            String nickname = st.nextToken();
            if (time.compareTo(S) <= 0)
                set.add(nickname);
            else if (time.compareTo(E) >= 0 && time.compareTo(Q) <= 0) {
                if (set.contains(nickname)) {
                    set.remove(nickname);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
