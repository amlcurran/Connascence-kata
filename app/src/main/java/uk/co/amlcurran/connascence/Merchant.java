package uk.co.amlcurran.connascence;

public interface Merchant {
    void setPurchaser(User purchaser);

    void purchaseItem(Item item, Callbacks callbacks);

    interface Callbacks {

        void purchased(User purchaser, Item item);
    }
}
