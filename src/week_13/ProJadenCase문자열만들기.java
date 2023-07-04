package src.week_13;

public class ProJadenCase문자열만들기 {
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution("for the last week"));
    }

    public static String solution(String s) {
        char[] tmp = s.toLowerCase().toCharArray();
        for (int i = 0; i < tmp.length; i++) {
            if ((i == 0 || tmp[i - 1] == ' ') && (tmp[i] >= 'a' && tmp[i] <= 'z')) {
                tmp[i] -= 32;
            }
        }
        return String.valueOf(tmp);
    }
}
