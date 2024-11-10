# 🫰 nemomemo [WIP]
Nemomemo is memo application on desktop using KMP.

The name Nemomemo was inspired by the song title [네모네모(nemonemo)](https://www.youtube.com/watch?v=MPp8hbuZwW0) by [YENA](https://yhfamily.co.kr/?module=Default&action=DefaultAt&sAt=007).


## 💻 Development
* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
