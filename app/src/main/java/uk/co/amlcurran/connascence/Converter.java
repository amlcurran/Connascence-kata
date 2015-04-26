package uk.co.amlcurran.connascence;

import java.text.DecimalFormat;

public class Converter {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");
    private static Converter instance;

    public static Converter get() {
        if (instance == null) {
            instance = new Converter();
        }
        return instance;
    }

    public double poundsToEuros() {
        return 1.1;
    }

    public double eurosToPounds() {
        return 1 / poundsToEuros();
    }

    double convertPenceToEuros(int pence) {
        double pounds = pence / 100d;
        return Double.valueOf(DECIMAL_FORMAT.format(pounds * poundsToEuros()));
    }

    int convertEurosToPence(int euros) {
        double pounds = euros * eurosToPounds();
        return (int) (pounds * 100);
    }
}
