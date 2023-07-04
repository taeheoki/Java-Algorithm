package src.week_10;
/**
 * 문제 이해:
 */

class Prog1_3 {
    public static int solution(String s) {
        int res = 0;
        char pre;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i = 0;
            for (; i < s.length(); i++) {
                char cur = s.charAt(i);
                sb.append(cur);
                for (int j = sb.length() - 1; j >= 1 && sb.length() > 1; j--) {
                    boolean flag = true;
                    if (sb.charAt(j - 1) == sb.charAt(j)) {
                        sb.delete(j - 1, j + 1);
                        j--;
                        flag = false;
                    }
                    if (flag)
                        break;
                }
            }
            if (i == s.length()) {
                if (sb.length() == 0)
                    res = 1;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
        System.out.println(solution(""));
    }
}