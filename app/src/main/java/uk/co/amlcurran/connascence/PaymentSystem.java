package uk.co.amlcurran.connascence;

class PaymentSystem {
    private User user;
    private Merchant merchant;

    public PaymentSystem(User user, Merchant merchant) {
        this.user = user;
        this.merchant = merchant;
    }

    public void purchase(Item item) {
        merchant.setPurchaser(user);
        merchant.purchaseItem(item, new Merchant.Callbacks() {
            @Override
            public void purchased(User purchaser, Item item) {
                purchaser.purchasedItem(item);
            }
        });
    }
}
