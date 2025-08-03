import Foundation

class MatchingAlgorithm {
    
    private var userList: [Item]
    private var orgList: [Item]
    private var matchItems: [String]
    private var userItemHistory: [String]
    private var match: Bool
    private var numMatches: Int
    
    init(userItems: [Item], organizationItems: [Item]) {
        self.userList = userItems
        self.orgList = organizationItems
        self.matchItems = []
        self.userItemHistory = []
        self.match = false
        self.numMatches = 0
    }
    
    init() {
        self.userList = []
        self.orgList = []
        self.matchItems = []
        self.userItemHistory = []
        self.match = false
        self.numMatches = 0
    }
    
    func performMatching() -> String {  // Changed from matchItems() to performMatching()
        
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
                        i -= 1
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
    
    func clearMatches() {
        matchItems.removeAll()
        userItemHistory.removeAll()
        match = false
        numMatches = 0
    }
    
    func reset() {
        userList.removeAll()
        orgList.removeAll()
        matchItems.removeAll()
        userItemHistory.removeAll()
        match = false
        numMatches = 0
    }
}
