import Foundation

// MARK: - Testing Framework
class MatchingAlgorithmTester {
    
    static func runAccuracyTests() -> String {
        var results = "Matching Algorithm Accuracy Tests\n"
        results += "=====================================\n\n"
        
        // Test 1: Exact matches
        let exactMatchAccuracy = testExactMatches()
        results += "Exact Matches: \(String(format: "%.1f", exactMatchAccuracy))%\n"
        
        // Test 2: Category matches
        let categoryMatchAccuracy = testCategoryMatches()
        results += "Category Matches: \(String(format: "%.1f", categoryMatchAccuracy))%\n"
        
        // Test 3: Fuzzy matches
        let fuzzyMatchAccuracy = testFuzzyMatches()
        results += "Fuzzy Matches: \(String(format: "%.1f", fuzzyMatchAccuracy))%\n"
        
        // Test 4: Real-world scenarios
        let realWorldAccuracy = testRealWorldScenarios()
        results += "Real-world Scenarios: \(String(format: "%.1f", realWorldAccuracy))%\n"
        
        let overallAccuracy = (exactMatchAccuracy + categoryMatchAccuracy + fuzzyMatchAccuracy + realWorldAccuracy) / 4.0
        results += "\nOverall Accuracy: \(String(format: "%.1f", overallAccuracy))%\n"
        
        return results
    }
    
    private static func testExactMatches() -> Double {
        let userItems = [
            Item(name: "Books", count: 5, origin: "User"),
            Item(name: "Clothes", count: 3, origin: "User"),
            Item(name: "Toys", count: 2, origin: "User")
        ]
        
        let orgItems = [
            Item(name: "Books", count: 10, origin: "Org"),
            Item(name: "Clothes", count: 5, origin: "Org"),
            Item(name: "Toys", count: 8, origin: "Org")
        ]
        
        let algorithm = MatchingAlgorithm(userItems: userItems, organizationItems: orgItems)
        algorithm.performMatching()
        
        return algorithm.getAccuracy()
    }
    
    private static func testCategoryMatches() -> Double {
        let userItems = [
            Item(name: "Textbooks", count: 5, origin: "User"),
            Item(name: "Shirts", count: 3, origin: "User"),
            Item(name: "Puzzles", count: 2, origin: "User")
        ]
        
        let orgItems = [
            Item(name: "Books", count: 10, origin: "Org"),
            Item(name: "Clothing", count: 5, origin: "Org"),
            Item(name: "Toys", count: 8, origin: "Org")
        ]
        
        let algorithm = MatchingAlgorithm(userItems: userItems, organizationItems: orgItems)
        algorithm.performMatching()
        
        return algorithm.getAccuracy()
    }
    
    private static func testFuzzyMatches() -> Double {
        let userItems = [
            Item(name: "Book", count: 5, origin: "User"),
            Item(name: "Cloth", count: 3, origin: "User"),
            Item(name: "Toy", count: 2, origin: "User")
        ]
        
        let orgItems = [
            Item(name: "Books", count: 10, origin: "Org"),
            Item(name: "Clothes", count: 5, origin: "Org"),
            Item(name: "Toys", count: 8, origin: "Org")
        ]
        
        let algorithm = MatchingAlgorithm(userItems: userItems, organizationItems: orgItems)
        algorithm.performMatching()
        
        return algorithm.getAccuracy()
    }
    
    private static func testRealWorldScenarios() -> Double {
        let userItems = [
            Item(name: "Children's books", count: 5, origin: "User"),
            Item(name: "Winter jackets", count: 3, origin: "User"),
            Item(name: "Board games", count: 2, origin: "User"),
            Item(name: "School supplies", count: 10, origin: "User")
        ]
        
        let orgItems = [
            Item(name: "Books for kids", count: 10, origin: "Org"),
            Item(name: "Warm clothing", count: 5, origin: "Org"),
            Item(name: "Educational toys", count: 8, origin: "Org"),
            Item(name: "Pencils and paper", count: 20, origin: "Org")
        ]
        
        let algorithm = MatchingAlgorithm(userItems: userItems, organizationItems: orgItems)
        algorithm.performMatching()
        
        return algorithm.getAccuracy()
    }
}