package uk.co.amlcurran.connascence;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class PaymentSystem {
    private final ExecutorService executor;
    private final User user;
    private final Merchant merchant;

    public PaymentSystem(User user, Merchant merchant) {
        this.user = user;
        this.merchant = merchant;
        this.executor = Executors.newSingleThreadExecutor();
    }

    public void purchase(final Item item) {
        merchant.setPurchaser(user);
        final Future<?> submit = executor.submit(new Runnable() {
            @Override
            public void run() {
                merchant.purchaseItem(item, new Merchant.Callbacks() {
                    @Override
                    public void purchased(User purchaser, Item item) {
                        purchaser.purchasedItem(item);
                    }

                    @Override
                    public void failedPurchase(User purchaser, Item item) {
                        purchaser.failedToPurchase(item);
                    }
                });
            }
        });
        try {
            submit.get(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
            user.failedToPurchase(item);
        }
    }
}
