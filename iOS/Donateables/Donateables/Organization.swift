import Foundation

class Organization: User {
    
    override init() {
        super.init()
    }
    
    override init(name: String, location: String, mail: String) {
        super.init(name: name, location: location, mail: mail)
    }
    
    func getOrgName() -> String {
        return getUserName()
    }
    
    func setOrgName(_ name: String) {
        setUserName(name)
    }
    
    func getOrgAddress() -> String {
        return getAddress()
    }
    
    func setOrgAddress(_ address: String) {
        setAddress(address)
    }
    
    func getOrgEmail() -> String {
        return getEmail()
    }
    
    func setOrgEmail(_ email: String) {
        setEmail(email)
    }
    
    func getNeededItems() -> [Item] {
        return getMyItems()
    }
    
    func addNeededItem(_ item: Item) {
        addItem(item)
    }
    
    func removeNeededItem(_ item: Item) {
        removeItem(item)
    }
    
    func getNeededItemsList() -> String {
        return getMyItemsList()
    }
    
    func clearNeededItems() {
        clearItems()
    }
}
