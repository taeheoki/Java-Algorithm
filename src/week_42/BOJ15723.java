package src.week_42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 15723 - n단 논법
 */
public class BOJ15723 {
    static int n, m;
    static boolean flag;
    static boolean[] visit;
    static ArrayList<Character>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char from = st.nextToken().charAt(0);
            st.nextToken();
            char to = st.nextToken().charAt(0);
            arr[from - 'a'].add(to);
        }
        visit = new boolean[26];
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char from = st.nextToken().charAt(0);
            st.nextToken();
            char to = st.nextToken().charAt(0);
            flag = false;
            Arrays.fill(visit, false);
            dfs(from, to);
            System.out.println(flag ? "T" : "F");
        }
    }

    private static void dfs(char from, char to) {
        if (from == to)
            flag = true;
        visit[from - 'a'] = true;

        for (Character ch : arr[from - 'a']) {
            if (visit[ch - 'a'])
                continue;
            dfs(ch, to);
        }
    }
}
