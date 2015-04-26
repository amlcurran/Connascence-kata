package uk.co.amlcurran.connascence;

public class Price {
    final Converter converter;
    final int pence;
    final int euros;

    public Price(int pence, int euros, Converter converter) {
        this.pence = pence;
        this.euros = euros;
        this.converter = converter;
    }

    static Price inPence(int pence) {
        return new Price(pence, 0, Converter.get());
    }

    static Price inEuros(int euros) {
        return new Price(0, euros, Converter.get());
    }

    public int inPence() {
        if (pence == 0) {
            return converter.convertEurosToPence(euros);
        } else {
            return pence;
        }
    }

    public double inEuros() {
        if (euros == 0) {
            return converter.convertPenceToEuros(pence);
        } else {
            return euros;
        }
    }
}