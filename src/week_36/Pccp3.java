package src.week_36;

public class Pccp3 {
    public static void main(String[] args) {
        int startHour = 0;
        int startMinute = 0;
        int startSecond = 0;

        int endHour = 23;
        int endMinute = 59;
        int endSecond = 59;

        int count = getClockOverlapCount(startHour, startMinute, startSecond,
                endHour, endMinute, endSecond);

        System.out.println("겹치는 횟수: " + count);
    }

    public static int getClockOverlapCount(int startHour, int startMinute, int startSecond,
                                           int endHour, int endMinute, int endSecond) {
        // 시작 시간을 초 단위로 변환
        long startTimeInSeconds = (startHour * 3600) + (startMinute * 60) + startSecond;

        // 종료 시간을 초 단위로 변환
        long endTimeInSeconds = (endHour * 3600) + (endMinute * 60) + endSecond;

        // 겹치는 횟수 초기화
        int overlapCount = 0;

        // 각 초마다 카운트를 세어줌
        for (long i = startTimeInSeconds; i <= endTimeInSeconds; i++) {
            if ((i % 60 == i / 3600 % 60) || (i % 60 == i / 60 % 60)) {
                overlapCount++;
            }
        }

        return overlapCount;
    }
}
