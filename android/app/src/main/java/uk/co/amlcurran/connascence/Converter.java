package uk.co.amlcurran.connascence;

public class Converter {

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
}
