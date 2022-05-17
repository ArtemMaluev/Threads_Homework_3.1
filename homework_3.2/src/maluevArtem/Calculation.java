package maluevArtem;

import java.util.concurrent.atomic.AtomicLong;

public class Calculation {

    AtomicLong stat = new AtomicLong(0);

    public void calcul(long value) {
        stat.addAndGet(value);
    }

    public long getResult() {
        return stat.get();
    }
}
