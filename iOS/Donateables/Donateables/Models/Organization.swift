import Foundation

/**
 * Models an Organization for the donation app
 *
 * @author Donateables Team
 *
 */
class Organization: User {
    
    // MARK: - Initializers
    
    /**
     * Constructs a default Organization object
     */
    override init() {
        super.init()
    }
    
    /**
     * Constructs an Organization object given a specified name, location, and mail
     * @param name Organization name
     * @param location Organization address
     * @param mail Organization email
     */
    override init(name: String, location: String, mail: String) {
        super.init(name: name, location: location, mail: mail)
    }
    
    // MARK: - Organization-Specific Methods
    
    /**
     * Gets the organization name (alias for getUserName)
     * @return organization name
     */
    func getOrgName() -> String {
        return getUserName()
    }
    
    /**
     * Sets the organization name (alias for setUserName)
     * @param name New organization name
     */
    func setOrgName(_ name: String) {
        setUserName(name)
    }
    
    /**
     * Gets the organization address (alias for getAddress)
     * @return organization address
     */
    func getOrgAddress() -> String {
        return getAddress()
    }
    
    /**
     * Sets the organization address (alias for setAddress)
     * @param address New organization address
     */
    func setOrgAddress(_ address: String) {
        setAddress(address)
    }
    
    /**
     * Gets the organization email (alias for getEmail)
     * @return organization email
     */
    func getOrgEmail() -> String {
        return getEmail()
    }
    
    /**
     * Sets the organization email (alias for setEmail)
     * @param email New organization email
     */
    func setOrgEmail(_ email: String) {
        setEmail(email)
    }
    
    /**
     * Gets the organization's needed items (alias for getMyItems)
     * @return array of needed items
     */
    func getNeededItems() -> [Item] {
        return getMyItems()
    }
    
    /**
     * Adds a needed item to the organization's list
     * @param item Item that the organization needs
     */
    func addNeededItem(_ item: Item) {
        addItem(item)
    }
    
    /**
     * Removes a needed item from the organization's list
     * @param item Item to remove from needs
     */
    func removeNeededItem(_ item: Item) {
        removeItem(item)
    }
    
    /**
     * Gets a formatted string of the organization's needed items
     * @return formatted string of needed items
     */
    func getNeededItemsList() -> String {
        return getMyItemsList()
    }
    
    /**
     * Clears all needed items from the organization's list
     */
    func clearNeededItems() {
        clearItems()
    }
} 