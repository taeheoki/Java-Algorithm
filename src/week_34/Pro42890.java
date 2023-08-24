package src.week_34;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 프로그래머스  - 후보키
 */
public class Pro42890 {

    static int n, res;
    static String[][] copyRelation;

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}}));
    }

    public static int solution(String[][] relation) {
        copyRelation = relation;
        Set<String[]> set = new HashSet<>();
        n = 1 << relation[0].length;
        for (int i = 0; i < n; i++) {
            pro(set, i);
            set.clear();
        }
        return res;
    }

    private static void pro(Set<String[]> set, int index) {
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < copyRelation.length; i++) {
            for (int j = 0; j < copyRelation[0].length; i++) {
            }
        }
    }
}
