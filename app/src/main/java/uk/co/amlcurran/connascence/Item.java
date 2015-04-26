package uk.co.amlcurran.connascence;

import java.text.DecimalFormat;

public class Item {

    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");
    private String label;
    private final int pence;
    private final int euros;

    public Item(String label, int pence, int euros) {
        this.label = label;
        this.pence = pence;
        this.euros = euros;
    }

    public int price() {
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

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Item && ((Item) obj).label.equals(label);
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }
}
