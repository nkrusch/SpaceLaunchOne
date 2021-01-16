# Space Launch 1 Source

This directory contains the source code for Space Launch 1 Android app.

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

If you need instructions [see signing your app ↗](https://developer.android.com/studio/publish/app-signing)

**4. Optional: obtain 3rd party API keys** 

This application uses multiple 3rd party services: Google Maps, Cloudinary and OneSignal. 
To get these services working properly, you must obtain your own API keys -OR- you may skip this
step knowing that some functionality will not work as intended until you obtain the keys.

For instructions how to acquire API keys see:
[Cloudinary Setup](https://cloudinary.com/documentation/android_integration#setup) |
[Google Maps](https://developers.google.com/maps/documentation/android-sdk/start) |
[OneSignal](https://documentation.onesignal.com/docs/android-sdk-setup)

If you complete these setup steps, you will use the API keys in step #5.

**5. Create a file called `secret.properties` and add following properties to it:**

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

Replace values:

- **Keystore** - replace these values with the values you chose in step #3
- **Cloudinary Name** - This is your cloud name, from step #4
- **Maps key** - this is your Maps API key, from step #4
- **OneSignal** - API key, from step #4


**6. Build the project**

-----

## Project Organization

This application consists of three libraries. Each library is futher divided into packages by purpose:

Library/Package | Purpose
--- | ---
└ **app** | Application UI
└─── app | app-level UI code; utility and base classes
└─── features | Specific activities and fragments
└ **datasrc** | Application data
└─── api | External network data
└─── local | Local data (Room DB)
└─── service | Services for initializing and synchronizing data
└─── utilities | Data-related utility methods
└─── viewmodels | ViewModels provide access to data to UI layer
└ **models** | API models
└─── apimodels | Launch library API models<br/>used for mapping raw data to objects

-----

## Documentation

You can read the javadocs [here](https://nkrusch.github.io/SpaceLaunchOne/index.html)
