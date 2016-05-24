import UIKit

class User {
    
    var purchasedItems = [Item]()
    var failedToPurchaseItems = [Item]()
    
    func hasPurchased(item: Item) -> Bool {
        return purchasedItems.contains(item)
    }
    
    func hasFailedToPurchase(item: Item) -> Bool {
        return failedToPurchaseItems.contains(item)
    }

}
