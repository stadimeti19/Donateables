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

## Tech Stack

### Android
- **Language**: Java
- **Database**: Firebase Realtime Database
- **UI**: XML layouts with Material Design
- **Build System**: Gradle

### iOS
- **Language**: Swift
- **Database**: Firebase Realtime Database
- **UI**: Programmatic UI with UIKit
- **Build System**: Xcode

## Project Structure

```
Donateables/
├── app/                    # Android app
│   ├── src/main/java/     # Java source code
│   ├── src/main/res/      # Android resources
│   └── build.gradle       # Android dependencies
├── iOS/Donateables/       # iOS app
│   ├── Donateables.xcodeproj/  # Xcode project
│   ├── Donateables/       # Swift source code
│   ├── Models/            # Core data models
│   └── Package.swift      # Swift dependencies
├── build.gradle           # Project configuration
└── README.md              # This file
```

## Setup

### Prerequisites
- Android Studio (latest version recommended)
- Xcode 15.0+ (for iOS development)
- Firebase project

### Quick Start

#### Android
1. Clone this repository
2. Open in Android Studio
3. Add `google-services.json` to the `app/` directory
4. Build and run

#### iOS
1. Clone this repository
2. Open `iOS/Donateables/Donateables.xcodeproj` in Xcode
3. Add `GoogleService-Info.plist` to the project
4. Build and run

## Firebase Integration

Both apps connect to the same Firebase Realtime Database:
- Real-time data synchronization
- User and organization management
- Item tracking and status updates
- Cross-platform data sharing

## Core Models

- **User**: Individual donors
- **Organization**: Charitable organizations  
- **Item**: Donation items with status tracking
- **MatchingAlgorithm**: Smart matching logic

## Cross-Platform Development

This repository contains both Android and iOS apps that share the same Firebase backend, enabling seamless cross-platform functionality while maintaining clean separation between the two codebases.

**Donateables Team** - Making donations easier, one match at a time. 