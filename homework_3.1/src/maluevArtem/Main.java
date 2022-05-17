package maluevArtem;

public class Main {

    public static final int NUMBER_REPETITIONS = 10;

    public static void main(String[] args) {

        Box box = new Box(NUMBER_REPETITIONS);

        new Thread(box::user, "Пользователь").start();
        new Thread(box::toy, "Игрушка").start();

    }
}
