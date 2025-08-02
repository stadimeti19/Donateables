import Foundation

/**
 * Models a User for the donation app
 *
 * @author Donateables Team
 *
 */
class User {
    
    // MARK: - Properties
    private var userName: String
    private var address: String
    private var email: String
    private var items: [Item]
    
    // MARK: - Initializers
    
    /**
     * Constructs a default User object
     */
    init() {
        self.userName = "username"
        self.address = "address"
        self.email = "email"
        self.items = []
    }
    
    /**
     * Constructs a User object with specified name, location, and email
     * @param name User's name
     * @param location User's address
     * @param mail User's email
     */
    init(name: String, location: String, mail: String) {
        self.userName = name
        self.address = location
        self.email = mail
        self.items = []
    }
    
    // MARK: - Getters
    
    /**
     * Returns the user name
     * @return userName
     */
    func getUserName() -> String {
        return userName
    }
    
    /**
     * Returns the user address
     * @return address
     */
    func getAddress() -> String {
        return address
    }
    
    /**
     * Returns the user email
     * @return email
     */
    func getEmail() -> String {
        return email
    }
    
    /**
     * Returns the list of user items
     * @return items array
     */
    func getMyItems() -> [Item] {
        return items
    }
    
    /**
     * Returns the list of user items as a formatted string
     * @return formatted string of items
     */
    func getMyItemsList() -> String {
        var userItems = "Your Items: \n"
        for item in items {
            userItems += item.toString() + "\n"
        }
        return userItems
    }
    
    // MARK: - Setters
    
    /**
     * Sets the user name
     * @param name New user name
     */
    func setUserName(_ name: String) {
        userName = name
    }
    
    /**
     * Sets the user address
     * @param zip New address
     */
    func setAddress(_ zip: String) {
        address = zip
    }
    
    /**
     * Sets the user email
     * @param mail New email
     */
    func setEmail(_ mail: String) {
        email = mail
    }
    
    // MARK: - Item Management
    
    /**
     * Adds an item to the user's item list
     * @param item Item to add
     */
    func addItem(_ item: Item) {
        items.append(item)
    }
    
    /**
     * Removes an item from the user's item list
     * @param item Item to remove
     */
    func removeItem(_ item: Item) {
        if let index = items.firstIndex(where: { $0.getName() == item.getName() }) {
            items.remove(at: index)
        }
    }
    
    /**
     * Clears all items from the user's list
     */
    func clearItems() {
        items.removeAll()
    }
} 