import Foundation

class User {
    private var userName: String
    private var address: String
    private var email: String
    private var items: [Item]
    
    init() {
        self.userName = "username"
        self.address = "address"
        self.email = "email"
        self.items = []
    }
    
    init(name: String, location: String, mail: String) {
        self.userName = name
        self.address = location
        self.email = mail
        self.items = []
    }
    
    func getUserName() -> String {
        return userName
    }
    
    func getAddress() -> String {
        return address
    }
    
    func getEmail() -> String {
        return email
    }
    
    func getMyItems() -> [Item] {
        return items
    }
    
    func getMyItemsList() -> String {
        var userItems = "Your Items: \n"
        for item in items {
            userItems += item.toString() + "\n"
        }
        return userItems
    }
    
    func setUserName(_ name: String) {
        userName = name
    }
    
    func setAddress(_ zip: String) {
        address = zip
    }
    
    func setEmail(_ mail: String) {
        email = mail
    }
    
    func addItem(_ item: Item) {
        items.append(item)
    }
    
    func removeItem(_ item: Item) {
        if let index = items.firstIndex(where: { $0.getName() == item.getName() }) {
            items.remove(at: index)
        }
    }
    
    func clearItems() {
        items.removeAll()
    }
}

