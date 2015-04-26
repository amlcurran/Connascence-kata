package uk.co.amlcurran.connascence;

public class Item {

    private final String label;
    private final Price price;

    private Item(String label, Price price) {
        this.label = label;
        this.price = price;
    }

    static Item withPrice(String label, Price price) {
        return new Item(label, price);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Item && ((Item) obj).label.equals(label);
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }

    public Price getPrice() {
        return price;
    }
}
