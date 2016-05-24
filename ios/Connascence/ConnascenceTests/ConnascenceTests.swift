import XCTest
@testable import Connascence

class ConnascenceTests: XCTestCase {
    
    func testAnItemReportsItsPriceCorrectly() {
        let item = Item(label: "Cola", pencePrice: 200, eurosPrice: nil)
        
        XCTAssertEqual(item.price(), 200 / 100.0)
    }
    
    func testAnItemReportsItsPriceEuroCorrectly() {
        let item = Item(label: "Baked beans", pencePrice: nil, eurosPrice: 4)
        
        XCTAssertEqual(item.priceInEuros(), 4.0)
    }
    
    func testAnItemConvertsToEurosCorrectly() {
        let item = Item(label: "Gin", pencePrice: 1000, eurosPrice: nil)
        
        XCTAssertEqual(item.priceInEuros(), 1000 / 100.0 * 1.1)
    }
    
    func testAnItemConvertsToPoundsCorrectly() {
        let item = Item(label: "Cooked Chicken", pencePrice: nil, eurosPrice: 3)
        
        XCTAssertEqual(item.price(), 3 / 1.1)
    }
    
}
