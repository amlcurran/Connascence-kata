import UIKit

class Converter {
    
    static let sharedInstance = Converter()
    
    func poundsToEuros(pounds: Double) -> Double {
        return pounds * 1.1
    }
    
    func eurosToPounds(euros: Double) -> Double {
        return euros / 1.1
    }

}
