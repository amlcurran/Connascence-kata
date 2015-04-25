package uk.co.amlcurran.connascence;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class EndToEndTests {

    @Test
    public void buyingAnItemSuccessfully() {
        User user = new User();
        PaymentSystem system = new PaymentSystem(user, new SuccessfulMerchant());

        Item item = new Item(300, 0);
        system.purchase(item);

        assertThat(user.hasPurchased(item)).isTrue();
    }
    @Test
    public void buyingAnItemUnsuccessfully() {
        User user = new User();
        PaymentSystem system = new PaymentSystem(user, new UnsuccessfulMerchant());

        Item item = new Item(300, 0);
        system.purchase(item);

        assertThat(user.hasFailedToPurchase(item)).isTrue();
    }

    private static class SuccessfulMerchant implements Merchant {
        private User purchaser;

        @Override
        public void setPurchaser(User purchaser) {
            this.purchaser = purchaser;
        }

        @Override
        public void purchaseItem(Item item, Callbacks callbacks) {
            callbacks.purchased(purchaser, item);
        }

    }

    private class UnsuccessfulMerchant implements Merchant {
        private User purchaser;

        @Override
        public void setPurchaser(User purchaser) {
            this.purchaser = purchaser;
        }

        @Override
        public void purchaseItem(Item item, Callbacks callbacks) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                callbacks.failedPurchase(purchaser, item);
            }
        }
    }
}
