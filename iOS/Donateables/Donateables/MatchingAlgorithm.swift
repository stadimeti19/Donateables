import Foundation

class MatchingAlgorithm {
    
    // MARK: - Properties
    private var userList: [Item]
    private var orgList: [Item]
    private var matchItems: [String]
    private var userItemHistory: [String]
    private var match: Bool
    private var numMatches: Int
    private var accuracyMetrics: MatchingAccuracyMetrics
    
    // MARK: - Categories for semantic matching
    private let itemCategories: [String: [String]] = [
        "books": ["book", "books", "textbook", "textbooks", "novel", "novels", "literature", "reading"],
        "clothing": ["clothes", "clothing", "shirt", "shirts", "pants", "dress", "dresses", "jacket", "jackets"],
        "electronics": ["electronic", "electronics", "phone", "phones", "computer", "computers", "laptop", "laptops"],
        "furniture": ["furniture", "chair", "chairs", "table", "tables", "desk", "desks", "sofa", "sofas"],
        "toys": ["toy", "toys", "game", "games", "puzzle", "puzzles", "doll", "dolls"],
        "food": ["food", "canned", "canned food", "non-perishable", "groceries", "pantry"],
        "medical": ["medicine", "medical", "supplies", "bandage", "bandages", "first aid"],
        "school": ["school supplies", "pencil", "pencils", "paper", "notebook", "notebooks", "backpack", "backpacks"]
    ]
    
    // MARK: - Initializers
    init(userItems: [Item], organizationItems: [Item]) {
        self.userList = userItems
        self.orgList = organizationItems
        self.matchItems = []
        self.userItemHistory = []
        self.match = false
        self.numMatches = 0
        self.accuracyMetrics = MatchingAccuracyMetrics()
    }
    
    init() {
        self.userList = []
        self.orgList = []
        self.matchItems = []
        self.userItemHistory = []
        self.match = false
        self.numMatches = 0
        self.accuracyMetrics = MatchingAccuracyMetrics()
    }
    
    // MARK: - Enhanced Matching Algorithm
    func performMatching() -> String {
        accuracyMetrics.reset()
        
        var i = 0
        while i < userList.count {
            var j = 0
            while j < orgList.count {
                let matchScore = calculateMatchScore(userItem: userList[i], orgItem: orgList[j])
                
                if matchScore >= 0.8 { // 80% similarity threshold
                    match = true
                    numMatches += 1
                    accuracyMetrics.addMatch(score: matchScore)
                    
                    let orgCount = orgList[j].getCount()
                    let userCount = userList[i].getCount()
                    
                    if userCount <= orgCount {
                        let newOrgCount = orgCount - userCount
                        let newUserCount = userCount - userCount
                        orgList[j].setCount(newOrgCount)
                        userList[i].setCount(newUserCount)
                        userItemHistory.append(userList[i].getName())
                        userList.remove(at: i)
                        i -= 1
                        break
                    } else {
                        print("You can donate \(orgCount) of your items to the organization")
                        let newUserCount = userCount - orgCount
                        let newOrgCount = orgCount - orgCount
                        orgList[j].setCount(newOrgCount)
                        userList[i].setCount(newUserCount)
                    }
                    
                    matchItems.append("Item: \(userList[i].getName())\nAmount Donated: \(userCount)\nMatch Score: \(String(format: "%.1f", matchScore * 100))%")
                } else {
                    accuracyMetrics.addNonMatch()
                }
                j += 1
            }
            i += 1
        }
        
        let accuracy = accuracyMetrics.getAccuracy()
        return "MatchPage Found: \(matchItems)\nAccuracy: \(String(format: "%.1f", accuracy))%"
    }
    
    // MARK: - Fuzzy Matching Functions
    private func calculateMatchScore(userItem: Item, orgItem: Item) -> Double {
        let userName = userItem.getName().lowercased().trimmingCharacters(in: .whitespacesAndNewlines)
        let orgName = orgItem.getName().lowercased().trimmingCharacters(in: .whitespacesAndNewlines)
        
        // Exact match
        if userName == orgName {
            return 1.0
        }
        
        // Category-based matching
        let categoryScore = getCategoryMatchScore(userName: userName, orgName: orgName)
        if categoryScore > 0.8 {
            return categoryScore
        }
        
        // Fuzzy string matching
        let fuzzyScore = calculateFuzzyMatch(userName: userName, orgName: orgName)
        
        // Combined score
        return max(categoryScore, fuzzyScore)
    }
    
    private func getCategoryMatchScore(userName: String, orgName: String) -> Double {
        for (category, keywords) in itemCategories {
            let userInCategory = keywords.contains { userName.contains($0) }
            let orgInCategory = keywords.contains { orgName.contains($0) }
            
            if userInCategory && orgInCategory {
                return 0.9 // High score for category matches
            }
        }
        return 0.0
    }
    
    private func calculateFuzzyMatch(userName: String, orgName: String) -> Double {
        let distance = levenshteinDistance(userName, orgName)
        let maxLength = max(userName.count, orgName.count)
        
        if maxLength == 0 { return 1.0 }
        
        let similarity = 1.0 - (Double(distance) / Double(maxLength))
        return similarity
    }
    
    private func levenshteinDistance(_ s1: String, _ s2: String) -> Int {
        let m = s1.count
        let n = s2.count
        var matrix = Array(repeating: Array(repeating: 0, count: n + 1), count: m + 1)
        
        for i in 0...m {
            matrix[i][0] = i
        }
        
        for j in 0...n {
            matrix[0][j] = j
        }
        
        for i in 1...m {
            for j in 1...n {
                let cost = s1[s1.index(s1.startIndex, offsetBy: i - 1)] == s2[s2.index(s2.startIndex, offsetBy: j - 1)] ? 0 : 1
                matrix[i][j] = min(
                    matrix[i - 1][j] + 1,      // deletion
                    matrix[i][j - 1] + 1,      // insertion
                    matrix[i - 1][j - 1] + cost // substitution
                )
            }
        }
        
        return matrix[m][n]
    }
    
    // MARK: - Accuracy Metrics
    func getAccuracyMetrics() -> MatchingAccuracyMetrics {
        return accuracyMetrics
    }
    
    func getAccuracy() -> Double {
        return accuracyMetrics.getAccuracy()
    }
    
    // MARK: - Getters
    func getUserList() -> [Item] {
        return userList
    }
    
    func getOrgList() -> [Item] {
        return orgList
    }
    
    func getMatchItems() -> [String] {
        return matchItems
    }
    
    func getUserItemHistory() -> [String] {
        return userItemHistory
    }
    
    func getNumMatches() -> Int {
        return numMatches
    }
    
    func hasMatches() -> Bool {
        return match
    }
    
    // MARK: - Setters
    func setUserList(_ userList: [Item]) {
        self.userList = userList
    }
    
    func setOrgList(_ orgList: [Item]) {
        self.orgList = orgList
    }
    
    func setMatchItems(_ matchItems: [String]) {
        self.matchItems = matchItems
    }
    
    func setUserItemHistory(_ userItemHistory: [String]) {
        self.userItemHistory = userItemHistory
    }
    
    func setMatch(_ match: Bool) {
        self.match = match
    }
    
    func setNumMatches(_ numMatches: Int) {
        self.numMatches = numMatches
    }
    
    // MARK: - Utility Functions
    func clearMatches() {
        matchItems.removeAll()
        userItemHistory.removeAll()
        match = false
        numMatches = 0
        accuracyMetrics.reset()
    }
    
    func reset() {
        userList.removeAll()
        orgList.removeAll()
        matchItems.removeAll()
        userItemHistory.removeAll()
        match = false
        numMatches = 0
        accuracyMetrics.reset()
    }
}

// MARK: - Accuracy Metrics Class
class MatchingAccuracyMetrics {
    private var totalComparisons: Int = 0
    private var successfulMatches: Int = 0
    private var matchScores: [Double] = []
    
    func addMatch(score: Double) {
        successfulMatches += 1
        totalComparisons += 1
        matchScores.append(score)
    }
    
    func addNonMatch() {
        totalComparisons += 1
    }
    
    func getAccuracy() -> Double {
        guard totalComparisons > 0 else { return 0.0 }
        return (Double(successfulMatches) / Double(totalComparisons)) * 100.0
    }
    
    func getAverageMatchScore() -> Double {
        guard !matchScores.isEmpty else { return 0.0 }
        return matchScores.reduce(0, +) / Double(matchScores.count)
    }
    
    func getMatchCount() -> Int {
        return successfulMatches
    }
    
    func getTotalComparisons() -> Int {
        return totalComparisons
    }
    
    func reset() {
        totalComparisons = 0
        successfulMatches = 0
        matchScores.removeAll()
    }
}