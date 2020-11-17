# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-keep class * extends com.cloudinary.strategies.*

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-keep public class io.github.nkrusch.spacelaunchone.features.** {
  public protected *;
}

-keep public class com.google.android.gms.maps.**

#-keep public class io.github.nkrusch.spacelaunchone.features.next.NextLaunchFragment
#-keep public class io.github.nkrusch.spacelaunchone.features.launches.FutureLaunches
#-keep public class io.github.nkrusch.spacelaunchone.features.launches.FavoriteLaunches
#-keep public class io.github.nkrusch.spacelaunchone.features.agencies.AgencyRecyclerView
#-keep public class io.github.nkrusch.spacelaunchone.features.launches.AgencyLaunchRecyclerView
#-keep public class io.github.nkrusch.spacelaunchone.features.launches.FavoriteLaunches
#-keep public class io.github.nkrusch.spacelaunchone.features.launches.FutureLaunches
#-keep public class io.github.nkrusch.spacelaunchone.features.launches.ListAdapter
#-keep public class io.github.nkrusch.spacelaunchone.features.launches.LocationLaunchRecyclerView
#-keep public class io.github.nkrusch.spacelaunchone.features.launches.PastLaunches
#-keep public class io.github.nkrusch.spacelaunchone.features.launches.SearchLaunches
#-keep public class io.github.nkrusch.spacelaunchone.features.locations.LocationRecyclerView
#-keep public class io.github.nkrusch.spacelaunchone.features.locations.LocationAdapter
#-keep public class io.github.nkrusch.spacelaunchone.features.launchdetails.VideosFragment
#-keep public class io.github.nkrusch.spacelaunchone.features.launchdetails.DetailsTimer
#-keep public class io.github.nkrusch.spacelaunchone.features.launchdetails.LinksFragment
#-keep public class io.github.nkrusch.spacelaunchone.features.launchdetails.MissionsFragment
#-keep public class io.github.nkrusch.spacelaunchone.features.launchdetails.SummaryFragment
#-keep public class io.github.nkrusch.spacelaunchone.features.launchdetails.SummaryItem
#-keep public class io.github.nkrusch.spacelaunchone.features.pads.LocationPadsAdapter
#-keep public class io.github.nkrusch.spacelaunchone.features.pads.LocationPadsFragment
#-keep public class io.github.nkrusch.spacelaunchone.features.pads.LocationPadsRecyclerView