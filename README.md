# FITCONNECT

FIT CONNECT is an Android-based application designed to manage and streamline fitness-related activities. It includes functionalities such as user registration and login, species information management, and other interactive features for fitness enthusiasts.

## Features

- **User Management**: Allows users to register, log in, and manage their profiles.
- **Species Information**: Displays detailed information about species, including descriptions and images.
- **Interactive Activities**: Provides options for booking, fitness tips, and connecting with trainers.
- **Help and Support**: Features a dedicated section for user support and FAQs.

## Technologies Used

- **Programming Languages**: Java, Kotlin
- **Database**: SQLite
- **Build Tool**: Gradle
- **UI Framework**: Android SDK

## Directory Structure

```
FITCONNECT/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/fitconnect/
│   │   │   │   ├── ChatActivity.kt
│   │   │   │   ├── DatabaseHelper.java
│   │   │   │   ├── LoginActivity.kt
│   │   │   │   ├── RegisterActivity.kt
│   │   │   │   └── ... (other activities)
│   │   │   ├── res/
│   │   │   └── AndroidManifest.xml
│   ├── build.gradle.kts
│   └── proguard-rules.pro
├── build.gradle.kts
├── gradlew
└── settings.gradle.kts
```

## Database Schema

### `users` Table
- `ID`: Integer (Primary Key)
- `username`: Text
- `email`: Text
- `password`: Text (Note: Ensure to implement encryption for storing passwords securely.)

### `species` Table
- `species_id`: Integer (Primary Key)
- `species_name`: Text
- `species_description`: Text
- `species_image`: Blob/Text

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd FITCONNECT
   ```

2. **Open in Android Studio**:
   - Import the project into Android Studio.
   - Sync Gradle to install dependencies.

3. **Configure the Environment**:
   - Ensure the `JAVA_HOME` environment variable points to a compatible JDK (e.g., JDK 20).
   - Update the `Gradle JDK` in Android Studio if needed.

4. **Run the Application**:
   - Connect an Android device or use an emulator.
   - Build and run the project from Android Studio.

## Recommended Enhancements

- **Implement Password Security**: Use hashing mechanisms like bcrypt or SHA-256 with salting for secure password storage.
- **Real-Time Features**: Introduce push notifications or real-time updates using Firebase or other technologies.
- **Scalability**: Migrate the database to a server-side solution like PostgreSQL or MySQL for larger-scale deployments.

## Contribution

Contributions are welcome! Please fork the repository, make your changes, and submit a pull request.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

