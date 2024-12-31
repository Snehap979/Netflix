# 📱 Netflix Clone Android App

A modern Android application built with Kotlin that replicates core Netflix functionality and user experience.

## 🌟 Features

- User authentication and profile management
- Dynamic home feed with categorized content
- Video streaming capabilities
- Content search and filtering
- Responsive UI adapting to different screen sizes
- Offline viewing support
- Customizable user preferences
- Push notifications for new content

## 🛠️ Tech Stack

- **Language:** Kotlin
- **Architecture:** MVVM (Model-View-ViewModel)
- **Dependency Injection:** Hilt
- **Networking:** Retrofit, OkHttp
- **Database:** Room
- **UI Components:** 
  - Material Design Components
  - ExoPlayer for video playback
  - Glide for image loading
- **Testing:** 
  - JUnit
  - Espresso
  - Mockito

## 📱 Screenshots

![logo](https://github.com/user-attachments/assets/51139deb-ad59-4a81-8b52-13243f8e3cf5)
![series](https://github.com/user-attachments/assets/766f314d-1c4b-4fd6-926b-f679098fee7c)


## 🚀 Getting Started

### Prerequisites

- Android Studio Arctic Fox or later
- Android SDK 21 or higher
- Kotlin 1.5 or later

### Installation

1. Clone the repository
```bash
git clone https://github.com/yourusername/netflix-clone.git
```

2. Open the project in Android Studio

3. Add your API keys in `local.properties`:
```properties
TMDB_API_KEY=your_api_key_here
```

4. Build and run the application

## 📐 Architecture

The app follows Clean Architecture principles and is organized into three layers:

- **Presentation Layer:** Activities, Fragments, ViewModels
- **Domain Layer:** Use Cases, Domain Models
- **Data Layer:** Repositories, Data Sources, API Services

## 🧪 Testing

Run the tests using:

```bash
./gradlew test        # Unit tests
./gradlew connectedCheck  # Instrumentation tests
```

## 📝 API Reference

This project uses [The Movie Database (TMDB) API](https://www.themoviedb.org/documentation/api) for fetching movie and TV show data.

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

