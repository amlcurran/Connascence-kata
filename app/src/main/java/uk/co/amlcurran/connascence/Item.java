package uk.co.amlcurran.connascence;

import java.text.DecimalFormat;

public class Item {

    private final int pence;
    private final int euros;

    public Item(int pence, int euros) {
        this.pence = pence;
        this.euros = euros;
    }

    public int getPrice() {
        return pence;
    }

    public double toEuros() {
        if (euros == 0) {
            double pounds = pence / 100d;
            double euros = pounds * Converter.get().poundsToEuros();
            return Double.valueOf(new DecimalFormat("#.00").format(euros));
        } else {
            return euros;
        }
    }
}
