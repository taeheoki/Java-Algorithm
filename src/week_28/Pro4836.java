package src.week_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 4836 - 춤
 */
public class Pro4836 {
    static StringBuilder sb = new StringBuilder();
    static String str;
    static int max;
    static boolean[] rules = new boolean[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((str = br.readLine()) != null) {
            if (str.isEmpty())
                break;
            String[] st = str.split(" ");
            Arrays.fill(rules, false);
            checkRules(st);
            boolean flag = false;
            sb.append("form ");
            int cnt = 0;
            for (boolean rule : rules) {
                if (rule)
                    cnt++;
            }
            for (int i = 0; i < rules.length; i++) {
                if (rules[i]) {
                    if (flag) {
                        if (cnt > 1 && i == max)
                            sb.append(" and ");
                        else
                            sb.append(", ");
                    } else {
                        if (cnt == 1)
                            sb.append("error ");
                        else
                            sb.append("errors ");
                    }
                    flag = true;
                    sb.append(i + 1);
                }
            }
            if (!flag)
                sb.append("ok: " + str).append('\n');
            else {
                sb.append(": ");
                for (String s : st) {
                    sb.append(s).append(' ');
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }

    private static void checkRules(String[] st) {
        boolean twirlFlag = false;
        boolean hopFlag = false;
        boolean dipFlag = false;
        max = 0;
        for (int i = 0; i < st.length; i++) {
            // 1번 룰
            if (st[i].equals("dip")) {
                if (i - 1 >= 0 && st[i - 1].equals("jiggle")) {}
                else if (i - 2 >= 0 && st[i - 2].equals("jiggle")) {}
                else if (i + 1 < st.length && st[i + 1].equals("twirl")) {}
                else {
                    st[i] = "DIP";
                    rules[0] = true;
                    max = Math.max(max, 0);
                }
            }
            // 2번 룰
            if (st.length < 3 || !st[st.length - 3].equals("clap") || !st[st.length - 2].equals("stomp") || !st[st.length - 1].equals("clap")) {
                rules[1] = true;
                max = Math.max(max, 1);
            }
            // 3번 룰
            if (st[i].equals("twirl"))
                twirlFlag = true;
            else if (st[i].equals("hop"))
                hopFlag = true;
            if (i == st.length - 1 && twirlFlag && !hopFlag) {
                rules[2] = true;
                max = Math.max(max, 2);
            }
            // 4번 룰
            if (st[0].equals("jiggle")) {
                rules[3] = true;
                max = Math.max(max, 3);
            }
            // 5번 룰
            if (st[i].equals("dip") || st[i].equals("DIP"))
                dipFlag = true;
            if (i == st.length - 1 && !dipFlag) {
                rules[4] = true;
                max = Math.max(max, 4);
            }
        }
    }

}
