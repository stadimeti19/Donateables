# Donateables iOS App

This is the iOS version of the Donateables donation app, built with Swift and Firebase.

## Project Structure

```
iOS/Donateables/
├── Donateables/
│   ├── Models/
│   │   ├── User.swift
│   │   ├── Item.swift
│   │   ├── Organization.swift
│   │   └── MatchingAlgorithm.swift
│   ├── AppDelegate.swift
│   ├── SceneDelegate.swift
│   ├── MainViewController.swift
│   ├── Info.plist
│   └── Assets.xcassets/
├── Donateables.xcodeproj/
└── Package.swift
```

## Setup Instructions

### 1. Prerequisites
- Xcode 15.0 or later
- iOS 17.0+ deployment target
- Firebase project (shared with Android app)

### 2. Firebase Setup
1. Go to [Firebase Console](https://console.firebase.google.com/)
2. Select your existing Firebase project (same as Android)
3. Add iOS app to the project:
   - Bundle ID: `com.example.donateables`
   - App nickname: "Donateables iOS"
4. Download `GoogleService-Info.plist`
5. Add `GoogleService-Info.plist` to the iOS project

### 3. Xcode Project Setup
1. Open `Donateables.xcodeproj` in Xcode
2. Add Firebase dependencies:
   - Go to File → Add Package Dependencies
   - Add: `https://github.com/firebase/firebase-ios-sdk.git`
   - Select FirebaseDatabase and FirebaseAuth

### 4. Build and Run
1. Select your iOS device or simulator
2. Press Cmd+R to build and run

## Core Features

### Models
- **User**: Represents individual donors
- **Organization**: Represents charitable organizations (inherits from User)
- **Item**: Represents donation items with status tracking
- **MatchingAlgorithm**: Handles matching logic between donors and organizations

### Firebase Integration
- Shared database with Android app
- Real-time data synchronization
- User and organization registration
- Item management and status tracking

## Key Differences from Android

### Language
- **Android**: Java
- **iOS**: Swift

### Architecture
- **Android**: Multi-Activity
- **iOS**: Storyboard-based with SceneDelegate

### Firebase Usage
- **Android**: `FirebaseDatabase.getInstance()`
- **iOS**: `Database.database().reference()`

## Shared Database Structure

Both apps use the same Firebase database structure:
```
/users/
  /general/
    /{userName}/
      /items/
  /organizations/
    /{orgName}/
      /items/
/items/
  /general/
  /organizations/
```

## Development Notes

### Adding New Features
1. Create Swift model classes in `Models/`
2. Add Firebase database operations
3. Create UI in Storyboard
4. Connect UI to view controller

### Testing
- Use iOS Simulator for development
- Test on physical device for Firebase integration
- Both apps can share the same Firebase project

## Next Steps

1. **Complete UI Implementation**: Add storyboards and view controllers
2. **Add More Features**: Item management, matching interface
3. **Testing**: Unit tests and UI tests
4. **App Store Preparation**: Icons, screenshots, metadata

## Troubleshooting

### Common Issues
1. **Firebase not connecting**: Check `GoogleService-Info.plist` is added
2. **Build errors**: Ensure iOS deployment target is 17.0+
3. **Simulator issues**: Use physical device for Firebase testing

### Dependencies
- Firebase iOS SDK 10.0.0+
- iOS 17.0+
- Xcode 15.0+ 