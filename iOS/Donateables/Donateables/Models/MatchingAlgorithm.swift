import Foundation

/**
 * Models the matching algorithm for the donation app
 * 
 * @author Donateables Team
 *
 */
class MatchingAlgorithm {
    
    // MARK: - Properties
    private var userList: [Item]
    private var orgList: [Item]
    private var matchItems: [String]
    private var userItemHistory: [String]
    private var match: Bool
    private var numMatches: Int
    
    // MARK: - Initializers
    
    /**
     * Constructs a matching algorithm with given array parameters
     * 
     * @param userItems Array of user items
     * @param organizationItems Array of organization items
     */
    init(userItems: [Item], organizationItems: [Item]) {
        self.userList = userItems
        self.orgList = organizationItems
        self.matchItems = []
        self.userItemHistory = []
        self.match = false
        self.numMatches = 0
    }
    
    /**
     * Constructs a default matching algorithm which initializes the arrays
     */
    init() {
        self.userList = []
        self.orgList = []
        self.matchItems = []
        self.userItemHistory = []
        self.match = false
        self.numMatches = 0
    }
    
    // MARK: - Core Matching Logic
    
    /**
     * Matches the items from the user list to the organization list to scan for
     * similarities
     * 
     * @return list of matched items
     */
    func matchItems() -> String {
        
        var i = 0
        while i < userList.count {
            var j = 0
            while j < orgList.count {
                if userList[i].getName().lowercased() == orgList[j].getName().lowercased() {
                    match = true
                    numMatches += 1
                    
                    let orgCount = orgList[j].getCount()
                    let userCount = userList[i].getCount()
                    
                    if userCount <= orgCount {
                        let newOrgCount = orgCount - userCount
                        let newUserCount = userCount - userCount
                        orgList[j].setCount(newOrgCount)
                        userList[i].setCount(newUserCount)
                        userItemHistory.append(userList[i].getName())
                        userList.remove(at: i)
                        i -= 1 // Adjust index after removal
                        break
                    } else {
                        print("You can donate \(orgCount) of your items to the organization")
                        let newUserCount = userCount - orgCount
                        let newOrgCount = orgCount - orgCount
                        orgList[j].setCount(newOrgCount)
                        userList[i].setCount(newUserCount)
                    }
                    
                    matchItems.append("Item: \(userList[i].getName())\nAmount Donated: \(userCount)")
                }
                j += 1
            }
            i += 1
        }
        
        return "MatchPage Found: \(matchItems)"
    }
    
    // MARK: - Getters
    
    /**
     * Gets the user list
     * @return user items array
     */
    func getUserList() -> [Item] {
        return userList
    }
    
    /**
     * Gets the organization list
     * @return organization items array
     */
    func getOrgList() -> [Item] {
        return orgList
    }
    
    /**
     * Gets the matched items
     * @return matched items array
     */
    func getMatchItems() -> [String] {
        return matchItems
    }
    
    /**
     * Gets the user item history
     * @return user item history array
     */
    func getUserItemHistory() -> [String] {
        return userItemHistory
    }
    
    /**
     * Gets the number of matches
     * @return number of matches
     */
    func getNumMatches() -> Int {
        return numMatches
    }
    
    /**
     * Checks if there are any matches
     * @return true if matches found, false otherwise
     */
    func hasMatches() -> Bool {
        return match
    }
    
    // MARK: - Setters
    
    /**
     * Sets the user list
     * @param userList New user items array
     */
    func setUserList(_ userList: [Item]) {
        self.userList = userList
    }
    
    /**
     * Sets the organization list
     * @param orgList New organization items array
     */
    func setOrgList(_ orgList: [Item]) {
        self.orgList = orgList
    }
    
    /**
     * Sets the matched items
     * @param matchItems New matched items array
     */
    func setMatchItems(_ matchItems: [String]) {
        self.matchItems = matchItems
    }
    
    /**
     * Sets the user item history
     * @param userItemHistory New user item history array
     */
    func setUserItemHistory(_ userItemHistory: [String]) {
        self.userItemHistory = userItemHistory
    }
    
    /**
     * Sets the match status
     * @param match New match status
     */
    func setMatch(_ match: Bool) {
        self.match = match
    }
    
    /**
     * Sets the number of matches
     * @param numMatches New number of matches
     */
    func setNumMatches(_ numMatches: Int) {
        self.numMatches = numMatches
    }
    
    // MARK: - Utility Methods
    
    /**
     * Clears all match data
     */
    func clearMatches() {
        matchItems.removeAll()
        userItemHistory.removeAll()
        match = false
        numMatches = 0
    }
    
    /**
     * Resets the algorithm to initial state
     */
    func reset() {
        userList.removeAll()
        orgList.removeAll()
        matchItems.removeAll()
        userItemHistory.removeAll()
        match = false
        numMatches = 0
    }
} 