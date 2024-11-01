
class bt{
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    public bt(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setHour(int hour) {
        if (hour >= 0 && hour < 24) {
            this.hour = hour;
        } else {
            System.out.println("Invalid hour!");
        }
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute < 60) {
            this.minute = minute;
        } else {
            System.out.println("Invalid minute!");
        }
    }

    public void setSecond(int second) {
        if (second >= 0 && second < 60) {
            this.second = second;
        } else {
            System.out.println("Invalid second!");
        }
    }

    public void setTime(int hour, int minute, int second) {
        if (hour >= 0 && hour < 24 && minute >= 0 && minute < 60 && second >= 0 && second < 60) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        } else {
            System.out.println("Invalid hour, minute, or second!");
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public void nextSecond() {
        if (second == 59) {
            second = 0;
            nextMinute();
        } else {
            second++;
        }
    }

    public void nextMinute() {
        if (minute == 59) {
            minute = 0;
            nextHour();
        } else {
            minute++;
        }
    }

    public void nextHour() {
        if (hour == 23) {
            hour = 0;
        } else {
            hour++;
        }
    }

}

public class MyTime {
    public static void main(String[] args) {

        bt time1 = new bt(12, 30, 45);
        System.out.println("Expected: 12:30:45, Actual: " + time1);

        time1.setTime(23, 59, 59);
        System.out.println("Expected: 23:59:59, Actual: " + time1);

        time1.setTime(24, 60, 60);
        System.out.println("Expected: 23:59:59, Actual: " + time1);
        time1.nextSecond();
        System.out.println("Expected: 00:00:00, Actual: " + time1);

        bt time2 = new bt(13, 59, 59);
        time2.nextSecond();
        System.out.println("Expected: 14:00:00, Actual: " + time2);

        bt time3 = new bt(10, 30, 59);
        time3.nextSecond();
        System.out.println("Expected: 10:31:00, Actual: " + time3);

        bt time4 = new bt(22, 59, 59);
        time4.nextSecond();
        System.out.println("Expected: 23:00:00, Actual: " + time4);

        bt time5 = new bt(23, 59, 59);
        time5.nextSecond();
        System.out.println("Expected: 00:00:00, Actual: " + time5);

        time1.setHour(25);
        time1.setMinute(61);
        time1.setSecond(61);
        System.out.println("Expected: 00:00:00, Actual: " + time5);
    }
}