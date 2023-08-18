package src.week_33;

/**
 * 프로그래머스 - 문자열 압축
 */
public class Pro60057 {

    static int res;

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));
    }

    public static int solution(String s) {
        res = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            String compressStr = getCompress(s, i);
            res = Math.min(res, compressStr.length());
        }
        return res;
    }

    private static String getCompress(String s, int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int cnt = 1;
            String cmp = null;
            if (i + num < s.length())
                cmp = s.substring(i, i + num);
            else {
                sb.append(s.substring(i));
                break;
            }
            int startIndex = i + num;
            while (true) {
                if (s.substring(startIndex).startsWith(cmp)) {
                    cnt++;
                    startIndex += num;
                } else
                    break;
            }
            if (cnt == 1)
                sb.append(cmp);
            else
                sb.append(cnt).append(cmp);
            i += cnt * num - 1;
        }
        return sb.toString();
    }
}
