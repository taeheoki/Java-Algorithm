package src.week_34;

/**
 * 프로그래머스 - 단어 변환
 */
public class Pro43163 {
    static int res;
    static String start, end;
    static String[] arr;
    static boolean[] used;

    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
        System.out.println(solution("hit", "cog", new String[]{"hat","hot","dat","dot","cat","dog","cot","cog"}));
    }

    public static int solution(String begin, String target, String[] words) {
        start = begin;
        end = target;
        arr = new String[words.length + 1];
        arr[0] = start;
        for (int i = 1; i <= words.length; i++) {
            arr[i] = words[i - 1];
        }
        used = new boolean[arr.length];
        res = arr.length + 1;
        used[0] = true;
        dfs(1, 0);
        return res == arr.length + 1 ? 0 : res;
    }

    private static void dfs(int depth, int prev) {
        if (arr[prev].equals(end)) {
            res = Math.min(res, depth - 1);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used[i])
                continue;
            if (!compare(prev, i))
                continue;
            used[i] = true;
            dfs(depth + 1, i);
            used[i] = false;
        }
    }

    private static boolean compare(int prev, int cur) {
        int cnt = 0;
        for (int i = 0; i < arr[prev].length(); i++) {
            if (arr[prev].charAt(i) != arr[cur].charAt(i))
                cnt++;
            if (cnt == 2)
                return false;
        }
        return true;
    }
}
