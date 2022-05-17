package maluevArtem;

import java.util.Random;

public class MyRunnable implements Runnable {

    private final Random random = new Random();
    private final Calculation calculation;

    public MyRunnable(Calculation calculation) {
        this.calculation = calculation;
    }

    public Calculation getCalculation() {
        return calculation;
    }

    @Override
    public void run() {
        int reportPeriod = Main.REPORT_PERIOD;
        while (reportPeriod > 0) {
            reportPeriod--;
            System.out.println(Thread.currentThread().getName() + " открылся");
            int value = random.nextInt(21) * 100 + 100;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " закрылся");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " отправил отчет о выручке в размере " +
                    value + " в налоговую");
            calculation.calcul(value);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
