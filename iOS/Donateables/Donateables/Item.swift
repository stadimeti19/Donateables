import Foundation

class Item {
    private var name: String
    private var count: Int
    private var origin: String
    private var acceptedByOrg: String
    private var acceptedByDriver: Bool
    private var associatedUser: User?
    
    init(iName: String, iCount: Int, user: User) {
        self.name = iName
        self.count = iCount
        self.acceptedByOrg = "pending"
        self.acceptedByDriver = false
        self.associatedUser = user
        self.origin = user.getAddress()
    }
    
    init() {
        self.name = "Sample Item"
        self.count = 1
        self.acceptedByOrg = "pending"
        self.acceptedByDriver = false
        self.origin = "Sample Origin Address"
    }
    
    func getName() -> String {
        return name
    }
    
    func getCount() -> Int {
        return count
    }
    
    func getOrigin() -> String {
        return origin
    }
    
    func getOrgStatus() -> String {
        return acceptedByOrg
    }
    
    func getDriverStatus() -> Bool {
        return acceptedByDriver
    }
    
    func getAssociatedUser() -> User? {
        return associatedUser
    }
    
    func setCount(_ newCount: Int) {
        count = newCount
    }
    
    func setOrgStatus(_ acceptedByOrg: String) {
        self.acceptedByOrg = acceptedByOrg
    }
    
    func setDriverStatus(_ acceptedByDriver: Bool) {
        self.acceptedByDriver = acceptedByDriver
    }
    
    func setAssociatedUser(_ user: User) {
        self.associatedUser = user
    }
    
    func toString() -> String {
        return "Item: \(name), Count: \(count), Origin: \(origin), Org Status: \(acceptedByOrg), Driver Status: \(acceptedByDriver)"
    }
    
    func isAcceptedByOrg() -> Bool {
        return acceptedByOrg.lowercased() == "accepted"
    }
    
    func isPendingOrg() -> Bool {
        return acceptedByOrg.lowercased() == "pending"
    }
    
    func isRejectedByOrg() -> Bool {
        return acceptedByOrg.lowercased() == "rejected"
    }
}
