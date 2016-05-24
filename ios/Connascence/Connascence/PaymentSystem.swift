import UIKit

class PaymentSystem {
    
    private let executionQueue = dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_DEFAULT, 0)
    private let user: User
    private let merchant: Merchant
    
    init(user: User, merchant: Merchant) {
        self.user = user
        self.merchant = merchant
    }
    
    func purchase(item: Item) {
        merchant.setPurchaser(user)
        dispatch_async(self.executionQueue, {
            self.merchant.purchase(item, delegate: DefaultMerchantDelegate(user: self.user))
        })
    }

}

private class DefaultMerchantDelegate: MerchantDelegate {
    
    private let user: User
    
    init(user: User) {
        self.user = user
    }
    
    func successfullyPurchased(item: Item, byUser user: User) {
        self.user.purchasedItems.append(item)
    }
    
    func failedToPurchase(item: Item, byUser user: User) {
        self.user.failedToPurchaseItems.append(item)
    }
    
}