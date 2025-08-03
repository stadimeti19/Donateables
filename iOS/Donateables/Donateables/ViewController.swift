import UIKit
import FirebaseDatabase

class ViewController: UIViewController {
    
    // MARK: - UI Elements
    private let scrollView = UIScrollView()
    private let contentView = UIView()
    
    private let welcomeLabel: UILabel = {
        let label = UILabel()
        label.text = "Welcome to Donateables"
        label.font = UIFont.boldSystemFont(ofSize: 24)
        label.textAlignment = .center
        label.numberOfLines = 0
        return label
    }()
    
    private let signUpLabel: UILabel = {
        let label = UILabel()
        label.text = "Sign Up"
        label.font = UIFont.systemFont(ofSize: 18)
        label.textAlignment = .center
        return label
    }()
    
    private let nameLabel: UILabel = {
        let label = UILabel()
        label.text = "Name:"
        label.font = UIFont.systemFont(ofSize: 16)
        return label
    }()
    
    private let nameTextField: UITextField = {
        let textField = UITextField()
        textField.placeholder = "Enter your name"
        textField.borderStyle = .roundedRect
        return textField
    }()
    
    private let addressLabel: UILabel = {
        let label = UILabel()
        label.text = "Address:"
        label.font = UIFont.systemFont(ofSize: 16)
        return label
    }()
    
    private let addressTextField: UITextField = {
        let textField = UITextField()
        textField.placeholder = "Enter your address"
        textField.borderStyle = .roundedRect
        return textField
    }()
    
    private let emailLabel: UILabel = {
        let label = UILabel()
        label.text = "Email:"
        label.font = UIFont.systemFont(ofSize: 16)
        return label
    }()
    
    private let emailTextField: UITextField = {
        let textField = UITextField()
        textField.placeholder = "Enter your email"
        textField.borderStyle = .roundedRect
        textField.keyboardType = .emailAddress
        return textField
    }()
    
    private let userTypeSegmentedControl: UISegmentedControl = {
        let segmentedControl = UISegmentedControl(items: ["General User", "Organization"])
        segmentedControl.selectedSegmentIndex = 0
        return segmentedControl
    }()
    
    private let registerButton: UIButton = {
        let button = UIButton(type: .system)
        button.setTitle("Get Started", for: .normal)
        button.backgroundColor = .systemBlue
        button.setTitleColor(.white, for: .normal)
        button.layer.cornerRadius = 8
        return button
    }()
    
    private let statusLabel: UILabel = {
        let label = UILabel()
        label.text = ""
        label.font = UIFont.systemFont(ofSize: 14)
        label.textAlignment = .center
        label.numberOfLines = 0
        return label
    }()
    
    // MARK: - Properties
    private var ref: DatabaseReference!
    private var boolin: Bool = true
    
    // MARK: - Lifecycle
    override func viewDidLoad() {
        super.viewDidLoad()
        setupFirebase()
        setupUI()
        setupConstraints()
    }
    
    // MARK: - Setup
    private func setupFirebase() {
        ref = Database.database().reference()
    }
    
    private func setupUI() {
        view.backgroundColor = .systemBackground
        
        // Add scroll view
        view.addSubview(scrollView)
        scrollView.addSubview(contentView)
        
        // Add UI elements to content view
        contentView.addSubview(welcomeLabel)
        contentView.addSubview(signUpLabel)
        contentView.addSubview(nameLabel)
        contentView.addSubview(nameTextField)
        contentView.addSubview(addressLabel)
        contentView.addSubview(addressTextField)
        contentView.addSubview(emailLabel)
        contentView.addSubview(emailTextField)
        contentView.addSubview(userTypeSegmentedControl)
        contentView.addSubview(registerButton)
        contentView.addSubview(statusLabel)
        
        // Add target
        registerButton.addTarget(self, action: #selector(registerButtonTapped), for: .touchUpInside)
    }
    
    private func setupConstraints() {
        scrollView.translatesAutoresizingMaskIntoConstraints = false
        contentView.translatesAutoresizingMaskIntoConstraints = false
        
        // Scroll view constraints
        NSLayoutConstraint.activate([
            scrollView.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor),
            scrollView.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            scrollView.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            scrollView.bottomAnchor.constraint(equalTo: view.bottomAnchor)
        ])
        
        // Content view constraints
        NSLayoutConstraint.activate([
            contentView.topAnchor.constraint(equalTo: scrollView.topAnchor),
            contentView.leadingAnchor.constraint(equalTo: scrollView.leadingAnchor),
            contentView.trailingAnchor.constraint(equalTo: scrollView.trailingAnchor),
            contentView.bottomAnchor.constraint(equalTo: scrollView.bottomAnchor),
            contentView.widthAnchor.constraint(equalTo: scrollView.widthAnchor)
        ])
        
        // UI elements constraints
        let elements = [welcomeLabel, signUpLabel, nameLabel, nameTextField, addressLabel, addressTextField, emailLabel, emailTextField, userTypeSegmentedControl, registerButton, statusLabel]
        
        for element in elements {
            element.translatesAutoresizingMaskIntoConstraints = false
        }
        
        NSLayoutConstraint.activate([
            welcomeLabel.topAnchor.constraint(equalTo: contentView.topAnchor, constant: 20),
            welcomeLabel.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 20),
            welcomeLabel.trailingAnchor.constraint(equalTo: contentView.trailingAnchor, constant: -20),
            
            signUpLabel.topAnchor.constraint(equalTo: welcomeLabel.bottomAnchor, constant: 20),
            signUpLabel.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 20),
            signUpLabel.trailingAnchor.constraint(equalTo: contentView.trailingAnchor, constant: -20),
            
            nameLabel.topAnchor.constraint(equalTo: signUpLabel.bottomAnchor, constant: 20),
            nameLabel.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 20),
            nameLabel.trailingAnchor.constraint(equalTo: contentView.trailingAnchor, constant: -20),
            
            nameTextField.topAnchor.constraint(equalTo: nameLabel.bottomAnchor, constant: 10),
            nameTextField.centerXAnchor.constraint(equalTo: contentView.centerXAnchor),
            nameTextField.widthAnchor.constraint(equalToConstant: 200),
            nameTextField.heightAnchor.constraint(equalToConstant: 40),
            
            addressLabel.topAnchor.constraint(equalTo: nameTextField.bottomAnchor, constant: 20),
            addressLabel.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 20),
            addressLabel.trailingAnchor.constraint(equalTo: contentView.trailingAnchor, constant: -20),
            
            addressTextField.topAnchor.constraint(equalTo: addressLabel.bottomAnchor, constant: 10),
            addressTextField.centerXAnchor.constraint(equalTo: contentView.centerXAnchor),
            addressTextField.widthAnchor.constraint(equalToConstant: 200),
            addressTextField.heightAnchor.constraint(equalToConstant: 40),
            
            emailLabel.topAnchor.constraint(equalTo: addressTextField.bottomAnchor, constant: 20),
            emailLabel.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 20),
            emailLabel.trailingAnchor.constraint(equalTo: contentView.trailingAnchor, constant: -20),
            
            emailTextField.topAnchor.constraint(equalTo: emailLabel.bottomAnchor, constant: 10),
            emailTextField.centerXAnchor.constraint(equalTo: contentView.centerXAnchor),
            emailTextField.widthAnchor.constraint(equalToConstant: 200),
            emailTextField.heightAnchor.constraint(equalToConstant: 40),
            
            userTypeSegmentedControl.topAnchor.constraint(equalTo: emailTextField.bottomAnchor, constant: 20),
            userTypeSegmentedControl.centerXAnchor.constraint(equalTo: contentView.centerXAnchor),
            userTypeSegmentedControl.widthAnchor.constraint(equalToConstant: 200),
            userTypeSegmentedControl.heightAnchor.constraint(equalToConstant: 32),
            
            registerButton.topAnchor.constraint(equalTo: userTypeSegmentedControl.bottomAnchor, constant: 20),
            registerButton.centerXAnchor.constraint(equalTo: contentView.centerXAnchor),
            registerButton.widthAnchor.constraint(equalToConstant: 200),
            registerButton.heightAnchor.constraint(equalToConstant: 50),
            
            statusLabel.topAnchor.constraint(equalTo: registerButton.bottomAnchor, constant: 20),
            statusLabel.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 20),
            statusLabel.trailingAnchor.constraint(equalTo: contentView.trailingAnchor, constant: -20),
            statusLabel.bottomAnchor.constraint(equalTo: contentView.bottomAnchor, constant: -20)
        ])
    }
    
    // MARK: - Actions
    @objc private func registerButtonTapped() {
        guard let name = nameTextField.text, !name.isEmpty,
              let address = addressTextField.text, !address.isEmpty,
              let email = emailTextField.text, !email.isEmpty else {
            showAlert(title: "Error", message: "Please fill in all fields")
            return
        }
        
        boolin = userTypeSegmentedControl.selectedSegmentIndex == 0
        
        if boolin {
            registerUser(name: name, address: address, email: email)
        } else {
            registerOrganization(name: name, address: address, email: email)
        }
    }
    
    // MARK: - Registration Methods
    private func registerUser(name: String, address: String, email: String) {
        let user = User(name: name, location: address, mail: email)
        
        ref.child("users").childByAutoId().setValue([
            "userName": user.getUserName(),
            "address": user.getAddress(),
            "email": user.getEmail(),
            "items": []
        ]) { [weak self] error, _ in
            DispatchQueue.main.async {
                if let error = error {
                    self?.showAlert(title: "Error", message: "Failed to register user: \(error.localizedDescription)")
                } else {
                    self?.statusLabel.text = "User registered successfully!"
                    self?.statusLabel.textColor = .systemGreen
                }
            }
        }
    }
    
    private func registerOrganization(name: String, address: String, email: String) {
        let organization = Organization(name: name, location: address, mail: email)
        
        ref.child("organizations").childByAutoId().setValue([
            "userName": organization.getUserName(),
            "address": organization.getAddress(),
            "email": organization.getEmail(),
            "items": []
        ]) { [weak self] error, _ in
            DispatchQueue.main.async {
                if let error = error {
                    self?.showAlert(title: "Error", message: "Failed to register organization: \(error.localizedDescription)")
                } else {
                    self?.statusLabel.text = "Organization registered successfully!"
                    self?.statusLabel.textColor = .systemGreen
                }
            }
        }
    }
    
    private func showAlert(title: String, message: String) {
        let alert = UIAlertController(title: title, message: message, preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "OK", style: .default))
        present(alert, animated: true)
    }
}
