import Foundation

/**
 * Models a Donation Item for the app
 *
 * @author Donateables Team
 *
 */
class Item {
    
    // MARK: - Properties
    private var name: String
    private var count: Int
    private var origin: String
    private var acceptedByOrg: String
    private var acceptedByDriver: Bool
    private var associatedUser: User?
    
    // MARK: - Initializers
    
    /**
     * Constructs an Item with given name, count, and associated user
     *
     * @param iName Item name
     * @param iCount Item count
     * @param user Associated user
     */
    init(iName: String, iCount: Int, user: User) {
        self.name = iName
        self.count = iCount
        self.acceptedByOrg = "pending"
        self.acceptedByDriver = false
        self.associatedUser = user
        self.origin = user.getAddress()
    }
    
    /**
     * Constructs an Item without set parameters
     */
    init() {
        self.name = "Sample Item"
        self.count = 1
        self.acceptedByOrg = "pending"
        self.acceptedByDriver = false
        self.origin = "Sample Origin Address"
    }
    
    // MARK: - Getters
    
    /**
     * Returns the name of the item
     *
     * @return item name
     */
    func getName() -> String {
        return name
    }
    
    /**
     * Returns the count of the item
     *
     * @return item count
     */
    func getCount() -> Int {
        return count
    }
    
    /**
     * Returns the origin of the item
     *
     * @return item origin
     */
    func getOrigin() -> String {
        return origin
    }
    
    /**
     * Returns the organization status
     *
     * @return organization status
     */
    func getOrgStatus() -> String {
        return acceptedByOrg
    }
    
    /**
     * Returns the driver status boolean
     *
     * @return driver status
     */
    func getDriverStatus() -> Bool {
        return acceptedByDriver
    }
    
    /**
     * Returns the associated user
     *
     * @return associated user
     */
    func getAssociatedUser() -> User? {
        return associatedUser
    }
    
    // MARK: - Setters
    
    /**
     * Sets the count of the item to the parameter count value
     *
     * @param newCount New count value
     */
    func setCount(_ newCount: Int) {
        count = newCount
    }
    
    /**
     * Sets the organization status
     *
     * @param acceptedByOrg New organization status
     */
    func setOrgStatus(_ acceptedByOrg: String) {
        self.acceptedByOrg = acceptedByOrg
    }
    
    /**
     * Sets the driver status
     *
     * @param acceptedByDriver New driver status
     */
    func setDriverStatus(_ acceptedByDriver: Bool) {
        self.acceptedByDriver = acceptedByDriver
    }
    
    /**
     * Sets the associated user
     *
     * @param user Associated user
     */
    func setAssociatedUser(_ user: User) {
        self.associatedUser = user
    }
    
    // MARK: - Utility Methods
    
    /**
     * Returns a string representation of the item
     *
     * @return string representation
     */
    func toString() -> String {
        return "Item: \(name), Count: \(count), Origin: \(origin), Org Status: \(acceptedByOrg), Driver Status: \(acceptedByDriver)"
    }
    
    /**
     * Checks if the item is accepted by organization
     *
     * @return true if accepted, false otherwise
     */
    func isAcceptedByOrg() -> Bool {
        return acceptedByOrg.lowercased() == "accepted"
    }
    
    /**
     * Checks if the item is pending organization approval
     *
     * @return true if pending, false otherwise
     */
    func isPendingOrg() -> Bool {
        return acceptedByOrg.lowercased() == "pending"
    }
    
    /**
     * Checks if the item is rejected by organization
     *
     * @return true if rejected, false otherwise
     */
    func isRejectedByOrg() -> Bool {
        return acceptedByOrg.lowercased() == "rejected"
    }
} 