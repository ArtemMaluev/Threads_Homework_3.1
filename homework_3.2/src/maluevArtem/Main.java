package maluevArtem;

public class Main {

    public static final int REPORT_PERIOD = 3;

    public static void main(String[] args) throws InterruptedException {

        Calculation calculation = new Calculation();
        MyRunnable shop = new MyRunnable(calculation);

        Thread thread1 = new Thread(null, shop, "Магазин_1");
        Thread thread2 = new Thread(null, shop, "Магазин_2");
        Thread thread3 = new Thread(null, shop, "Магазин_3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("\nОтчет о доходе магазинов: " + calculation.getResult() + " руб. за "
                + REPORT_PERIOD + " дней");
    }
}
