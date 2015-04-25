package uk.co.amlcurran.connascence;

public class Item {

    int priceInPence;

    public Item(int price) {

    }

    public int getPrice() {
        return priceInPence;
    }

    public double toEuros() {
        double pounds = priceInPence / 100d;
        return pounds * Converter.get().poundsToEuros();
    }
}
