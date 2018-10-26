# Space Launch 1 Source

This directory contains the srouce code for Sapce Launch 1 android app.

### Table of Contents

1. [How to compile](#how-to-compile)
2. [Project organization](#project-organization)
3. [Documentation](#documentation)

## How to Compile

**1. Clone the repository**

```
git clone https://github.com/nkrusch/SpaceLaunchOne.git
```

**2. Launch Android Studio. Open project from `./SpaceLaunchOne` directory.**

**3. Create keystore for signing** 

If you need instructions [see signing your app](https://developer.android.com/studio/publish/app-signing)

**4. Optional: obtain 3rd party API keys** 

This application uses multiple 3rd party services: Google Maps, Cloudinary and OneSignal. 
To get these services working properly, you must obtain API keys. OR you may skip this
step knowing that some functionality will not work as intended until you obtain the keys.

For instructions how to acquire API keys see: 

[Cloudinary Setup](https://cloudinary.com/documentation/android_integration#setup) | 
[Google Maps](https://developers.google.com/maps/documentation/android-sdk/start) |
[OneSignal](https://documentation.onesignal.com/docs/android-sdk-setup)

**5. Create a file called `secret.properites` and add following properties to it:**

```
# Keystore
storeFile = path/to/keystore
keyAlias = ENTER_KEYSTORE_ALIAS
keyPassword = ENTER_KEY_PWD
storePassword = ENTER_STORE_PWD
#
# Cloudinary Name
Cloudinary_Cloud = "ENTER_YOUR_CLOUD_NAME_HERE"
#
# Google Maps Key
Google_Maps_Key = "ENTER_MAPS_API_KEY_HERE"
#
# OneSignal App ID (UUID without quotes)
onesignal = 00000000-0000-0000-0000-000000000000
```   

The file path should be `./SpaceLaunchOne/secret.properties` relative to repository root. 
Failure to add this file and the listed <Key,Value> pairs will cause project to not compile.

**6. Build the project**

-----

## Project Organization

This application consists of three libraries. Each library is futher divided into packages by purpose:

Library/Package | Purpose
--- | ---
└ **app** | Application UI layer
└─── app | UI related code accessible to all activities
└─── features | Specific activities and fragments
└ **datasrc** | Services and methods for accessing local and external data
└─── api | External network methods
└─── local | Local database methods
└─── service | Services for initializing and synchronizing data over time
└─── viewmodels | ViewModels provide assess to data to the UI layer
└ **models** | API models
└─── base | abstract base classes for API models

-----

## Documentation

You can read the javadocs [here](https://nkrusch.github.io/SpaceLaunchOne/index.html)
