package tasks;

import static java.lang.Thread.sleep;

public class Timer {
    public static void main(String[] args) {
        Thread secondTimer = new Thread(() -> {
            for (int i = 1; i < 1000; i++) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Пройшло " + i + " секунд");
            }
        });

        Thread fiveSecondTimer = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Пройшло 5 секунд");
            }
        });

        secondTimer.start();
        fiveSecondTimer.start();
    }
}
