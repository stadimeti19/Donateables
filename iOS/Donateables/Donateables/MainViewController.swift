import UIKit
import Firebase

class MainViewController: UIViewController {
    
    // MARK: - Properties
    static var currentUser: User?
    static var currentOrganization: Organization?
    
    // MARK: - UI Elements
    @IBOutlet weak var nameTextField: UITextField!
    @IBOutlet weak var addressTextField: UITextField!
    @IBOutlet weak var emailTextField: UITextField!
    @IBOutlet weak var userTypeSegmentedControl: UISegmentedControl!
    @IBOutlet weak var registerButton: UIButton!
    @IBOutlet weak var statusLabel: UILabel!
    
    // MARK: - Lifecycle
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupUI()
    }
    
    // MARK: - UI Setup
    
    private func setupUI() {
        // Configure text fields
        nameTextField.placeholder = "Enter your name"
        addressTextField.placeholder = "Enter your address"
        emailTextField.placeholder = "Enter your email"
        
        // Configure segmented control
        userTypeSegmentedControl.setTitle("User", forSegmentAt: 0)
        userTypeSegmentedControl.setTitle("Organization", forSegmentAt: 1)
        
        // Configure button
        registerButton.setTitle("Register", for: .normal)
        registerButton.backgroundColor = .systemBlue
        registerButton.setTitleColor(.white, for: .normal)
        registerButton.layer.cornerRadius = 8
        
        // Configure status label
        statusLabel.text = ""
        statusLabel.textAlignment = .center
    }
    
    // MARK: - Actions
    
    @IBAction func registerButtonTapped(_ sender: UIButton) {
        guard let name = nameTextField.text, !name.isEmpty,
              let address = addressTextField.text, !address.isEmpty,
              let email = emailTextField.text, !email.isEmpty else {
            showAlert(title: "Error", message: "Please fill in all fields")
            return
        }
        
        if userTypeSegmentedControl.selectedSegmentIndex == 0 {
            // Register as User
            registerUser(name: name, address: address, email: email)
        } else {
            // Register as Organization
            registerOrganization(name: name, address: address, email: email)
        }
    }
    
    // MARK: - Registration Methods
    
    private func registerUser(name: String, address: String, email: String) {
        let user = User(name: name, location: address, mail: email)
        MainViewController.currentUser = user
        
        // Save to Firebase
        let database = Database.database().reference()
        let userRef = database.child("users/general").child(name)
        userRef.setValue([
            "userName": user.getUserName(),
            "address": user.getAddress(),
            "email": user.getEmail()
        ]) { [weak self] error, _ in
            DispatchQueue.main.async {
                if let error = error {
                    self?.showAlert(title: "Error", message: "Failed to register user: \(error.localizedDescription)")
                } else {
                    self?.statusLabel.text = "User registered successfully!"
                    self?.statusLabel.textColor = .systemGreen
                    self?.navigateToMainPage()
                }
            }
        }
    }
    
    private func registerOrganization(name: String, address: String, email: String) {
        let organization = Organization(name: name, location: address, mail: email)
        MainViewController.currentOrganization = organization
        
        // Save to Firebase
        let database = Database.database().reference()
        let orgRef = database.child("users/organizations").child(name)
        orgRef.setValue([
            "userName": organization.getUserName(),
            "address": organization.getAddress(),
            "email": organization.getEmail()
        ]) { [weak self] error, _ in
            DispatchQueue.main.async {
                if let error = error {
                    self?.showAlert(title: "Error", message: "Failed to register organization: \(error.localizedDescription)")
                } else {
                    self?.statusLabel.text = "Organization registered successfully!"
                    self?.statusLabel.textColor = .systemGreen
                    self?.navigateToMainPage()
                }
            }
        }
    }
    
    // MARK: - Navigation
    
    private func navigateToMainPage() {
        // This would navigate to the main app interface
        // For now, just show a success message
        DispatchQueue.main.asyncAfter(deadline: .now() + 1.0) {
            self.showAlert(title: "Success", message: "Registration complete! Ready to use the app.")
        }
    }
    
    // MARK: - Utility Methods
    
    private func showAlert(title: String, message: String) {
        let alert = UIAlertController(title: title, message: message, preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "OK", style: .default))
        present(alert, animated: true)
    }
} 