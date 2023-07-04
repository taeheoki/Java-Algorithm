package src.week_16;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 프로그래머스 - 전화번호 목록
 */
public class Pro전화번호목록 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution(new String[]{"123","456","789"}));
        System.out.println(solution(new String[]{"12","123","1235","567","88"}));
    }

    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].indexOf(phone_book[i - 1]) == 0)
                return false;
        }
        return true;
    }
}
