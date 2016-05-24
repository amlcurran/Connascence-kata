import UIKit

protocol Merchant {
    
    func setPurchaser(user: User)
    
    func purchase(item: Item, delegate: MerchantDelegate)

}

protocol MerchantDelegate {
    
    func successfullyPurchased(item: Item, byUser user: User)
    
    func failedToPurchase(item: Item, byUser user: User)
    
}
