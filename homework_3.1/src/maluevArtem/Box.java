package maluevArtem;

public class Box {

    private volatile boolean volatileVal;
    private int numberRepetitions;
    private boolean flag = true;

    public Box(int numberRepetitions) {
        this.numberRepetitions = numberRepetitions;
    }

    public void user() {
        while (numberRepetitions > 0) {
            if (!volatileVal) {
                numberRepetitions--;
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " включил тумблер");
                    volatileVal = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (numberRepetitions == 0) {
                flag = false;
            }
        }
    }

    public void toy() {
        while (flag) {
            if (volatileVal) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Коробка открылась");
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName() + " выключила тумблер");
                    Thread.sleep(500);
                    System.out.println("Коробка закрылась");
                    volatileVal = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
