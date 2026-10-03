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

## 📁 Project Structure

```
Misbahatu-Ahmad/
├── AndroidManifest.xml
├── assets/
│   ├── index.html        # Main web UI
│   └── duas.js           # Duas database
├── res/                  # Android resources (layouts, values, drawables)
├── src/                  # Java source code
├── apk/                  # Prebuilt APK
├── build_apk.sh          # One-click standalone build script
├── debug.keystore        # Debug signing key
└── README.md
```

## 📄 License
Open-source under MIT License.
