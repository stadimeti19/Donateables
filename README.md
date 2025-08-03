# Donateables - Android App

A cross-platform donation app that connects donors with charitable organizations through an intelligent matching system.

## Platforms Available

- **Android**: Java-based app with Firebase integration (this repository)
- **iOS**: Swift-based app with Firebase integration ([separate repository](https://github.com/your-username/donateables-ios))

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

## Project Structure

```
Donateables/
├── app/                    # Android app
│   ├── src/main/java/     # Java source code
│   ├── src/main/res/      # Android resources
│   └── build.gradle       # Android dependencies
├── build.gradle           # Project configuration
└── README.md              # This file
```

## Setup

### Prerequisites
- Android Studio (latest version recommended)
- Firebase project

### Quick Start
1. Clone this repository
2. Open in Android Studio
3. Add `google-services.json` to the `app/` directory
4. Build and run

## Firebase Integration

The Android app connects to Firebase Realtime Database:
- Real-time data synchronization
- User and organization management
- Item tracking and status updates
- Cross-platform data sharing with iOS app

## Core Models

- **User**: Individual donors
- **Organization**: Charitable organizations  
- **Item**: Donation items with status tracking
- **MatchingAlgorithm**: Smart matching logic

## Cross-Platform Development

This Android app is part of a larger cross-platform solution. The iOS version is maintained in a separate repository to ensure clean separation of concerns while sharing the same Firebase backend.

**Donateables Team** - Making donations easier, one match at a time. 