# Misbahatu Ahmad (مسبحة أحمد)

Misbahatu Ahmad is an Android digital Tasbih, Dhikr, and Daily Dua recitation application featuring interactive web-based UI and Android Text-to-Speech (TTS) integration.

## ✨ Features

- **Digital Tasbih & Dhikr**: Keep track of daily Azkar, SubhanAllah, Alhamdulillah, Allahu Akbar, and personalized counters.
- **Dua Collection (`duas.js`)**: Comprehensive collection of authentic daily duas and morning/evening remembrances.
- **Text-to-Speech (TTS) Bridge**: Pronounce Arabic and transliterated duas using Android's native Text-to-Speech engine via JavaScript interface.
- **Standalone Build (No Sketchware Required)**: Can be compiled and built into a signed APK directly using Termux or Linux CLI build tools.

## 📱 Prebuilt APK

The signed, ready-to-install APK is available at:
`apk/Misbahatu_Ahmad.apk`

## 🛠️ Build from Source (Termux / Linux CLI)

### Prerequisites:
- `aapt`
- `javac`
- `d8`
- `apksigner`
- `android.jar` (API 28+)

### Build Command:
```bash
bash build_apk.sh
```
The output APK will be placed in `apk/Misbahatu_Ahmad.apk`.

## 🌐 Web & Live App

- **Live Web & PWA**: [https://ahmadhibban.github.io/Misbahatu-Ahmad/](https://ahmadhibban.github.io/Misbahatu-Ahmad/)
- **Permanent Auto-Updating APK**: Connects directly with GitHub Pages for real-time cloud updates with full offline Service Worker caching. Any code changes pushed to the repository reflect inside the Android app without needing APK reinstallation!

## 📁 Project Structure

```
Misbahatu-Ahmad/
├── index.html            # Progressive Web App UI & 3D Tasbih Engine
├── duas.js               # Duas & Azkar collection
├── sw.js                 # Service Worker for offline caching
├── manifest.json         # Web App Manifest
├── icon.png              # App icon
├── AndroidManifest.xml   # Android Manifest
├── assets/               # Local APK fallback assets
│   ├── index.html
│   └── duas.js
├── res/                  # Android resources (layouts, values, drawables)
├── src/                  # Java source code (MainActivity.java)
├── apk/                  # Prebuilt signed APK
├── build_apk.sh          # One-click standalone build script
└── README.md
```

## 👤 Author

**Ahmad Hibban**
- GitHub: [@ahmadhibban](https://github.com/ahmadhibban)

## 📄 License

Open-source under MIT License. Copyright © Ahmad Hibban.
