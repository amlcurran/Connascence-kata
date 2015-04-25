package uk.co.amlcurran.connascence;

import java.text.DecimalFormat;

public class Item {

    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");
    private final int pence;
    private final int euros;

    public Item(int pence, int euros) {
        this.pence = pence;
        this.euros = euros;
    }

    public int priceInPence() {
        if (pence == 0) {
            double pounds = euros * Converter.get().eurosToPounds();
            return (int) (pounds * 100);
        } else {
            return pence;
        }
    }

    public double priceInEuros() {
        if (euros == 0) {
            double pounds = pence / 100d;
            double euros = pounds * Converter.get().poundsToEuros();
            return Double.valueOf(DECIMAL_FORMAT.format(euros));
        } else {
            return euros;
        }
    }
}
