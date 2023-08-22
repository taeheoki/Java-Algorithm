package src.week_34;

import java.util.ArrayList;

/**
 * 프로그래머스  - 후보키
 */
public class Pro42890 {

    static int res;
    static boolean[] used;
    static String[][] copyRelation;

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}}));
    }

    public static int solution(String[][] relation) {
        used = new boolean[relation[0].length];
        copyRelation = relation;
//        rec_func(0, )
        return res;
    }
}
