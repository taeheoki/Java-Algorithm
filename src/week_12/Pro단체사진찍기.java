package src.week_12;

import java.util.Arrays;

/**
 * 프로그래머스 - 단체사진 찍기
 */
public class Pro단체사진찍기 {
    static int cnt;
    static boolean[] used, place_fried;
    static Character[] place, friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

    public static void main(String[] args) {
        System.out.println(solution(2, new String[]{"N~F=0", "N~F=0"}));
        System.out.println(solution(2, new String[]{"N~F=0", "F~N=0"}));
        System.out.println(solution(1, new String[]{"N~F=0"}));
        System.out.println(solution(1, new String[]{"F~N=0"}));
        System.out.println(solution(2, new String[]{"N~F=0", "R~T>2"}));
        System.out.println(solution(2, new String[]{"R~T>2", "N~F=0"}));
        System.out.println(solution(2, new String[]{"M~C<2", "C~M>1"}));
    }

    public static int solution(int n, String[] data) {
        place = new Character[8];
        used = new boolean[8];
        place_fried = new boolean[26];
        cnt = 0;
        rec_func(0, data);
        return cnt;
    }

    private static void rec_func(int depth, String[] data) {
        if (depth == data.length) {
            int num = (int) Arrays.stream(place).filter(s -> s == null).count();
            int res = 1;
            while (num >= 2) {
                res *= num;
                num--;
            }
            cnt += res;
            return;
        }

        char x = data[depth].charAt(0);
        char y = data[depth].charAt(2);
        char oper = data[depth].charAt(3);
        int dist = Integer.parseInt(String.valueOf(data[depth].charAt(4))) + 1;
        boolean flag_x = false;
        boolean flag_y = false;

        for (int i = 0; i < friends.length; i++) {
            flag_x = false;
            if ((used[i] || place_fried[x - 'A']) && !(used[i] && place_fried[x - 'A'] && place[i] == x))
                continue;
            if (used[i] && place_fried[x - 'A'] && place[i] == x)
                flag_x = true;
            place[i] = x;
            used[i] = true;
            place_fried[x - 'A'] = true;
            for (int j = 0; j < friends.length; j++) {
                flag_y = false;
                if ((used[j] || place_fried[y - 'A']) && !(used[j] && place_fried[y - 'A'] && place[j] == y))
                    continue;
                if (used[j] && place_fried[y - 'A'] && place[j] == y)
                    flag_y = true;
                if (oper == '=' && Math.abs(i - j) == dist) {
                    process(depth, data, y, j, flag_y);
                } else if (oper == '>' && Math.abs(i - j) > dist) {
                    process(depth, data, y, j, flag_y);
                } else if (oper == '<' && Math.abs(i - j) < dist) {
                    process(depth, data, y, j, flag_y);
                }
            }
            place[i] = flag_x ? x : null;
            used[i] = flag_x ? true : false;
            place_fried[x - 'A'] = flag_x ? true : false;
        }
    }

    private static void process(int depth, String[] data, char y, int j, boolean flag) {
        place[j] = y;
        used[j] = true;
        place_fried[y - 'A'] = true;
        rec_func(depth + 1, data);
        place[j] = flag ? y : null;
        used[j] = flag ? true : false;
        place_fried[y - 'A'] = flag ? true : false;
    }
}
