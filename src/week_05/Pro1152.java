package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1152번 단어의 개수
 */
public class Pro1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        while (st.hasMoreTokens()) {
            st.nextToken();
            cnt++;
        }
        System.out.println(cnt);
    }
}
