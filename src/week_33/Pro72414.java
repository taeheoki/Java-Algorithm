package src.week_33;

import java.util.StringTokenizer;

/**
 * 머스 - 광고 삽입
 */
public class Pro72414 {
    static int res;

    public static void main(String[] args) {
        System.out.println(solution("02:03:55", "00:14:15", new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"}));
        res = 0;
        System.out.println(solution("99:59:59", "25:00:00", new String[]{"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"}));
        res = 0;
        System.out.println(solution("50:00:00", "50:00:00", new String[]{"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"}));
    }

    public static String solution(String play_time, String adv_time, String[] logs) {
        int playTime = getTime(play_time);
        int advTime = getTime(adv_time);
        int[] sum = new int[playTime + 1];
        for (int i = 0; i < logs.length; i++) {
            StringTokenizer st = new StringTokenizer(logs[i], "-");
            int start = getTime(st.nextToken());
            int end = getTime(st.nextToken());

            for (int j = start; j < end; j++) {
                sum[j]++;
            }
        }
        pro(playTime, advTime, sum);
        return getStrTime();
    }

    private static void pro(int playTime, int advTime, int[] sum) {
        long prev = 0;
        for (int i = 0; i < advTime; i++) {
            prev += sum[i];
        }

        long cur = prev;
        for (int i = advTime; i <= playTime; i++) {
            cur += - sum[i - advTime] + sum[i];
            if (cur > prev) {
                prev = cur;
                res = i - advTime + 1;
            }
        }
    }

    private static String getStrTime() {
        String hh, mm, ss;
        StringBuilder sb = new StringBuilder();
        hh = res / 3600 >= 10 ? String.valueOf(res / 3600) : "0" + res / 3600;
        res %= 3600;
        mm = res / 60 >= 10 ? String.valueOf(res / 60) : "0" + res / 60;
        res %= 60;
        ss = res >= 10 ? String.valueOf(res) : "0" + res;
        return sb.append(hh).append(':').append(mm).append(':').append(ss).toString();
    }

    private static int getTime(String strTime) {
        int time = 0;
        StringTokenizer st = new StringTokenizer(strTime, ":");
        time += Integer.parseInt(st.nextToken()) * 60 * 60;
        time += Integer.parseInt(st.nextToken()) * 60;
        time += Integer.parseInt(st.nextToken());
        return time;
    }
}
