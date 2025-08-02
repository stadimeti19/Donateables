# Donateables

A cross-platform donation app that connects donors with charitable organizations through an intelligent matching system.

## Platforms Available

- **Android**: Java-based app with Firebase integration
- **iOS**: Swift-based app with Firebase integration

## Features

- **User Registration**: Individual donors and organizations
- **Item Management**: Add, track, and manage donation items
- **Smart Matching**: Algorithm matches donor items with organization needs
- **Real-time Sync**: Firebase-powered data synchronization
- **Cross-platform**: Shared database between Android and iOS users

## Tech Stack Used

### Android
- **Language**: Java
- **Database**: Firebase Realtime Database
- **UI**: XML layouts with Material Design

### iOS
- **Language**: Swift
- **Database**: Firebase Realtime Database
- **UI**: Storyboards with UIKit

## Project Structure

```
Donateables/
├── app/                    # Android app
│   ├── src/main/java/     # Java source code
│   ├── src/main/res/      # Android resources
│   └── build.gradle       # Android dependencies
├── iOS/Donateables/       # iOS app
│   ├── Donateables/       # Swift source code
│   ├── Models/            # Core data models
│   └── Donateables.xcodeproj/
├── build.gradle           # Project configuration
└── README.md              # This file
```

## Setup

### Prerequisites
- Android Studio (for Android development)
- Xcode 15.0+ (for iOS development)
- Firebase project

### Quick Start
1. Clone the repository
2. **Android**: Open in Android Studio
3. **iOS**: Open `iOS/Donateables/Donateables.xcodeproj` in Xcode
4. Add Firebase configuration files
5. Build and run

## Firebase Integration

Both apps share the same Firebase project:
- Real-time data synchronization
- User and organization management
- Item tracking and status updates

## Core Models

- **User**: Individual donors
- **Organization**: Charitable organizations
- **Item**: Donation items with status tracking
- **MatchingAlgorithm**: Smart matching logic

**Donateables Team** - Making donations easier, one match at a time. 