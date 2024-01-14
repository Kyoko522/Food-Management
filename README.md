# PACSxVIRO Food Management App

## Overview

Welcome to the PACSxVIRO Food Management App – an initiative by the Practical Application of Computer Science (PACS) club in collaboration with VIRO. This Android application aims to reduce food waste by connecting event organizers with students and club members interested in receiving surplus food after events. The app facilitates a sustainable solution, ensuring that excess food doesn't go to waste and benefits those in need.

### Features

- **Post-Event Surplus Food:**
  Event organizers can post details about leftover food, including club name, pickup location, stock availability, and additional information.

- **User Accessibility:**
  Students and club members can view available surplus food, making it easy for them to find and pick up free meals.

- **Firebase Authentication:**
  Securely log in using Firebase Authentication, ensuring a reliable and authenticated user experience.

- **Firebase Cloud Database:**
  Leverage Firebase Cloud Database to store and retrieve information about surplus food posts, creating a real-time, dynamic platform.

- **MySQL Database:**
  Employ a MySQL database to manage different account types, allowing event leads to add to the database while regular users browse available surplus food.

## Getting Started

To run the PACSxVIRO Food Management App locally, follow these steps:

### Prerequisites

- Android Studio installed on your machine.
- Clone this repository to your local environment.

### Configuration

**Firebase Configuration:**

1. Create a new project on the Firebase Console.
2. Connect your Android app to the Firebase project by following the setup instructions provided.
3. Enable Firebase Authentication and Firebase Cloud Firestore.

**MySQL Database:**

- Set up a MySQL database with the necessary tables for user accounts.

**Android Studio:**

1. Open the project in Android Studio.
2. Update the `google-services.json` file with your Firebase configuration.
3. Configure MySQL database details in the appropriate files.

### Running the App

- Build and run the app using Android Studio.
- Log in using your Firebase Authentication credentials.
- Explore surplus food posts or post your own if you are an event lead.

## Contributing

We welcome contributions to enhance and improve the PACSxVIRO Food Management App. Feel free to submit issues or pull requests.

## License

This project is licensed under the MIT License.
