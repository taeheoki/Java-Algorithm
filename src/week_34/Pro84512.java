package src.week_34;

/**
 * 프로그래머스 - 모음 사전
 */
public class Pro84512 {
    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
        System.out.println(solution("AAAE"));
        System.out.println(solution("I"));
        System.out.println(solution("EIO"));
    }

    public static int solution(String word) {
        int answer = 0;
        int mul = 781;

        char chr[] = {'A', 'E', 'I', 'O', 'U'};

        for(int i=0; i<word.length(); i++){
            for(int j=0; j<5; j++){
                if(chr[j] == word.charAt(i)){
                    answer += 1 + j * mul;
                }
            }
            mul = (mul-1)/5;
        }

        return answer;
    }
}
