package src.week_38;

/**
 * BOJ 19236 - 청소년 상어
 */
public class BOJ19236 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(minimumNumberOfFolders(5, 0, 2, 2)); // 출력: 5
        System.out.println(minimumNumberOfFolders(0, 13, 7, 5)); // 출력: 13
        System.out.println(minimumNumberOfFolders(5, 13, 7, 5)); // 출력: 8
    }

    public static int minimumNumberOfFolders(int cssFiles,int jsFiles,
                                             int readMeFiles,int capacity) {

        int totalFolder = Math.max(cssFiles , jsFiles); // CSS와 JS 중 많은 것을 선택

        if(readMeFiles > totalFolder){
            return (readMeFiles * capacity -1)/capacity;
        }else{
            return (totalFolder + readMeFiles -1)/capacity;
        }
    }
}
