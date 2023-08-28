package src.week_34;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 프로그래머스  - 후보키
 */
public class Pro42890 {

    static boolean[] used;
    static String[][] copyRelation;
    static ArrayList<ArrayList<Integer>> keys = new ArrayList<>();
    static ArrayList<String>[] arr;
    static Set<ArrayList<String>> set = new HashSet<>();

    public static void main(String[] args) {
//        System.out.println(solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}}));
//        System.out.println(solution(new String[][]{{"100", "100", "ryan", "music", "2"}, {"200", "200", "apeach", "math", "2"}, {"300", "300", "tube", "computer", "3"}, {"400", "400", "con", "computer", "4"}, {"500", "500", "muzi", "music", "3"}, {"600", "600", "apeach", "music", "2"}}));
        System.out.println(solution(new String[][]{{"a","1","aaa","c","ng"},{"a","1","bbb","e","g"},{"c","1","aaa","d","ng"},{"d","2","bbb","d","ng"}}));
    }

    public static int solution(String[][] relation) {
        used = new boolean[relation[0].length];
        copyRelation = relation;
        arr = new ArrayList[copyRelation.length];
        for (int i = 0; i < relation.length; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < relation[0].length; i++) {
            rec_func(0, 0, i + 1);
        }
        System.out.println(keys);
        return keys.size();
    }

    private static void rec_func(int depth, int start, int cnt) {
        if (depth == cnt) {
            set.clear();

            ArrayList<Integer> tmpKey = new ArrayList<>();
            for (int i = 0; i < copyRelation[0].length; i++) {
                if (used[i]) {
                    tmpKey.add(i);
                    for (int j = 0; j < copyRelation.length; j++) {
                        arr[j].add(copyRelation[j][i]);
                    }
                }
            }
            for (int j = 0; j < copyRelation.length; j++) {
                set.add(arr[j]);
            }
            if (set.size() == copyRelation.length) {
                boolean flag = false;
                for (ArrayList<Integer> key : keys) {
                    int i = 0;
                    for (Integer num : key) {
                        if (tmpKey.contains(num))
                            i++;
                        if (i == key.size())
                            flag = true;
                    }
                    if (flag)
                        break;
                }
                if (!flag)
                    keys.add(tmpKey);
            }
            for (int i = 0; i < copyRelation.length; i++) {
                arr[i].clear();
            }
            return;
        }

        for (int i = start; i < copyRelation[0].length; i++) {
            used[i] = true;
            rec_func(depth + 1, i + 1, cnt);
            used[i] = false;
        }
    }
}
