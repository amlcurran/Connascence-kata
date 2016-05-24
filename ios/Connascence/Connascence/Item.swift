import UIKit

struct Item {
    
    let label: String
    let pencePrice: Int?
    let eurosPrice: Double?
    
    func price() -> Double {
        if let pencePrice = pencePrice {
            return Double(pencePrice)
        } else {
            let asPounds = Converter.sharedInstance.eurosToPounds(eurosPrice!)
            return asPounds
        }
    }
    
    func priceInEuros() -> Double {
        if let eurosPrice = eurosPrice {
            return eurosPrice
        } else {
            let asEuros = Converter.sharedInstance.poundsToEuros(Double(pencePrice!) / 100.0)
            return asEuros
        }
    }
    
}

extension Item : Equatable {}

func ==(lhs: Item, rhs: Item) -> Bool {
    return lhs.eurosPrice == rhs.eurosPrice &&
        lhs.label == rhs.label &&
        lhs.pencePrice == rhs.pencePrice
}
