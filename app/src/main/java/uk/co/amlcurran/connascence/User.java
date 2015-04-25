package uk.co.amlcurran.connascence;

import java.util.ArrayList;
import java.util.List;

class User {

    private final List<Item> purchasedItems = new ArrayList<>();

    public void purchasedItem(Item item) {
        purchasedItems.add(item);
    }

    public boolean hasPurchased(Item item) {
        return purchasedItems.contains(item);
    }
}
