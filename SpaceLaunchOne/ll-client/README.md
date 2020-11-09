# swagger-android-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-android-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-android-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-android-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.api.AgenciesApi;

public class AgenciesApiExample {

    public static void main(String[] args) {
        AgenciesApi apiInstance = new AgenciesApi();
        String featured = "featured_example"; // String | 
        String agencyType = "agencyType_example"; // String | 
        String countryCode = "countryCode_example"; // String | 
        String search = "search_example"; // String | A search term.
        String ordering = "ordering_example"; // String | Which field to use when ordering the results.
        Integer limit = 56; // Integer | Number of results to return per page.
        Integer offset = 56; // Integer | The initial index from which to return the results.
        try {
            InlineResponse200 result = apiInstance.agenciesList(featured, agencyType, countryCode, search, ordering, limit, offset);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AgenciesApi#agenciesList");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://ll.thespacedevs.com/2.0.0*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AgenciesApi* | [**agenciesList**](docs/AgenciesApi.md#agenciesList) | **GET** /agencies/ | 
*AgenciesApi* | [**agenciesRead**](docs/AgenciesApi.md#agenciesRead) | **GET** /agencies/{id}/ | 
*AstronautApi* | [**astronautList**](docs/AstronautApi.md#astronautList) | **GET** /astronaut/ | 
*AstronautApi* | [**astronautRead**](docs/AstronautApi.md#astronautRead) | **GET** /astronaut/{id}/ | 
*ConfigApi* | [**configLauncherList**](docs/ConfigApi.md#configLauncherList) | **GET** /config/launcher/ | 
*ConfigApi* | [**configLauncherRead**](docs/ConfigApi.md#configLauncherRead) | **GET** /config/launcher/{id}/ | 
*ConfigApi* | [**configSpacecraftList**](docs/ConfigApi.md#configSpacecraftList) | **GET** /config/spacecraft/ | 
*ConfigApi* | [**configSpacecraftRead**](docs/ConfigApi.md#configSpacecraftRead) | **GET** /config/spacecraft/{id}/ | 
*DashboardApi* | [**dashboardStarshipList**](docs/DashboardApi.md#dashboardStarshipList) | **GET** /dashboard/starship/ | 
*DockingEventApi* | [**dockingEventList**](docs/DockingEventApi.md#dockingEventList) | **GET** /docking_event/ | 
*DockingEventApi* | [**dockingEventRead**](docs/DockingEventApi.md#dockingEventRead) | **GET** /docking_event/{id}/ | 
*EventApi* | [**eventList**](docs/EventApi.md#eventList) | **GET** /event/ | 
*EventApi* | [**eventPreviousList**](docs/EventApi.md#eventPreviousList) | **GET** /event/previous/ | 
*EventApi* | [**eventPreviousRead**](docs/EventApi.md#eventPreviousRead) | **GET** /event/previous/{id}/ | 
*EventApi* | [**eventRead**](docs/EventApi.md#eventRead) | **GET** /event/{id}/ | 
*EventApi* | [**eventUpcomingList**](docs/EventApi.md#eventUpcomingList) | **GET** /event/upcoming/ | 
*EventApi* | [**eventUpcomingRead**](docs/EventApi.md#eventUpcomingRead) | **GET** /event/upcoming/{id}/ | 
*ExpeditionApi* | [**expeditionList**](docs/ExpeditionApi.md#expeditionList) | **GET** /expedition/ | 
*ExpeditionApi* | [**expeditionRead**](docs/ExpeditionApi.md#expeditionRead) | **GET** /expedition/{id}/ | 
*LaunchApi* | [**launchList**](docs/LaunchApi.md#launchList) | **GET** /launch/ | API endpoint that returns all Launch objects or a single launch.
*LaunchApi* | [**launchPreviousList**](docs/LaunchApi.md#launchPreviousList) | **GET** /launch/previous/ | 
*LaunchApi* | [**launchPreviousRead**](docs/LaunchApi.md#launchPreviousRead) | **GET** /launch/previous/{id}/ | 
*LaunchApi* | [**launchRead**](docs/LaunchApi.md#launchRead) | **GET** /launch/{id}/ | API endpoint that returns all Launch objects or a single launch.
*LaunchApi* | [**launchUpcomingList**](docs/LaunchApi.md#launchUpcomingList) | **GET** /launch/upcoming/ | 
*LaunchApi* | [**launchUpcomingRead**](docs/LaunchApi.md#launchUpcomingRead) | **GET** /launch/upcoming/{id}/ | 
*LauncherApi* | [**launcherList**](docs/LauncherApi.md#launcherList) | **GET** /launcher/ | 
*LauncherApi* | [**launcherRead**](docs/LauncherApi.md#launcherRead) | **GET** /launcher/{id}/ | 
*LocationApi* | [**locationList**](docs/LocationApi.md#locationList) | **GET** /location/ | 
*LocationApi* | [**locationRead**](docs/LocationApi.md#locationRead) | **GET** /location/{id}/ | 
*PadApi* | [**padList**](docs/PadApi.md#padList) | **GET** /pad/ | 
*PadApi* | [**padRead**](docs/PadApi.md#padRead) | **GET** /pad/{id}/ | 
*ProgramApi* | [**programList**](docs/ProgramApi.md#programList) | **GET** /program/ | 
*ProgramApi* | [**programRead**](docs/ProgramApi.md#programRead) | **GET** /program/{id}/ | 
*SpacecraftApi* | [**spacecraftFlightList**](docs/SpacecraftApi.md#spacecraftFlightList) | **GET** /spacecraft/flight/ | 
*SpacecraftApi* | [**spacecraftFlightRead**](docs/SpacecraftApi.md#spacecraftFlightRead) | **GET** /spacecraft/flight/{id}/ | 
*SpacecraftApi* | [**spacecraftList**](docs/SpacecraftApi.md#spacecraftList) | **GET** /spacecraft/ | 
*SpacecraftApi* | [**spacecraftRead**](docs/SpacecraftApi.md#spacecraftRead) | **GET** /spacecraft/{id}/ | 
*SpacestationApi* | [**spacestationList**](docs/SpacestationApi.md#spacestationList) | **GET** /spacestation/ | 
*SpacestationApi* | [**spacestationRead**](docs/SpacestationApi.md#spacestationRead) | **GET** /spacestation/{id}/ | 


## Documentation for Models

 - [Agency](docs/Agency.md)
 - [AgencyList](docs/AgencyList.md)
 - [AgencySerializerDetailed](docs/AgencySerializerDetailed.md)
 - [AgencySerializerDetailedCommon](docs/AgencySerializerDetailedCommon.md)
 - [AgencySerializerMini](docs/AgencySerializerMini.md)
 - [Astronaut](docs/Astronaut.md)
 - [AstronautDetailed](docs/AstronautDetailed.md)
 - [AstronautDetailedSerializerNoFlights](docs/AstronautDetailedSerializerNoFlights.md)
 - [AstronautFlight](docs/AstronautFlight.md)
 - [AstronautFlightForExpedition](docs/AstronautFlightForExpedition.md)
 - [AstronautNormal](docs/AstronautNormal.md)
 - [AstronautStatus](docs/AstronautStatus.md)
 - [AstronautType](docs/AstronautType.md)
 - [DockingEvent](docs/DockingEvent.md)
 - [DockingEventDetailed](docs/DockingEventDetailed.md)
 - [DockingEventDetailedSerializerForSpacestation](docs/DockingEventDetailedSerializerForSpacestation.md)
 - [DockingEventSerializerForSpacecraftFlight](docs/DockingEventSerializerForSpacecraftFlight.md)
 - [DockingLocation](docs/DockingLocation.md)
 - [DockingLocationSerializerForSpacestation](docs/DockingLocationSerializerForSpacestation.md)
 - [EventType](docs/EventType.md)
 - [Events](docs/Events.md)
 - [Expedition](docs/Expedition.md)
 - [ExpeditionDetail](docs/ExpeditionDetail.md)
 - [ExpeditionDetailedSerializerForSpacestation](docs/ExpeditionDetailedSerializerForSpacestation.md)
 - [ExpeditionSerializerForSpacestation](docs/ExpeditionSerializerForSpacestation.md)
 - [FirstStage](docs/FirstStage.md)
 - [InfoURL](docs/InfoURL.md)
 - [InlineResponse200](docs/InlineResponse200.md)
 - [InlineResponse2001](docs/InlineResponse2001.md)
 - [InlineResponse20010](docs/InlineResponse20010.md)
 - [InlineResponse20011](docs/InlineResponse20011.md)
 - [InlineResponse20012](docs/InlineResponse20012.md)
 - [InlineResponse20013](docs/InlineResponse20013.md)
 - [InlineResponse20014](docs/InlineResponse20014.md)
 - [InlineResponse2002](docs/InlineResponse2002.md)
 - [InlineResponse2003](docs/InlineResponse2003.md)
 - [InlineResponse2004](docs/InlineResponse2004.md)
 - [InlineResponse2005](docs/InlineResponse2005.md)
 - [InlineResponse2006](docs/InlineResponse2006.md)
 - [InlineResponse2007](docs/InlineResponse2007.md)
 - [InlineResponse2008](docs/InlineResponse2008.md)
 - [InlineResponse2009](docs/InlineResponse2009.md)
 - [Landing](docs/Landing.md)
 - [LandingLocation](docs/LandingLocation.md)
 - [LandingType](docs/LandingType.md)
 - [LaunchDetailed](docs/LaunchDetailed.md)
 - [LaunchSerializerCommon](docs/LaunchSerializerCommon.md)
 - [LaunchSerializerMini](docs/LaunchSerializerMini.md)
 - [LaunchStatus](docs/LaunchStatus.md)
 - [Launcher](docs/Launcher.md)
 - [LauncherConfig](docs/LauncherConfig.md)
 - [LauncherConfigDetail](docs/LauncherConfigDetail.md)
 - [LauncherConfigDetailSerializerForAgency](docs/LauncherConfigDetailSerializerForAgency.md)
 - [LauncherConfigList](docs/LauncherConfigList.md)
 - [LauncherDetail](docs/LauncherDetail.md)
 - [LauncherDetailed](docs/LauncherDetailed.md)
 - [Location](docs/Location.md)
 - [LocationDetail](docs/LocationDetail.md)
 - [Mission](docs/Mission.md)
 - [Orbit](docs/Orbit.md)
 - [Pad](docs/Pad.md)
 - [PadSerializerNoLocation](docs/PadSerializerNoLocation.md)
 - [Program](docs/Program.md)
 - [RocketDetailed](docs/RocketDetailed.md)
 - [RocketSerializerCommon](docs/RocketSerializerCommon.md)
 - [SpaceStation](docs/SpaceStation.md)
 - [SpaceStationDetailed](docs/SpaceStationDetailed.md)
 - [SpaceStationDetailedSerializerForExpedition](docs/SpaceStationDetailedSerializerForExpedition.md)
 - [SpaceStationSerializerForCommon](docs/SpaceStationSerializerForCommon.md)
 - [SpaceStationSerializerForDockingEvent](docs/SpaceStationSerializerForDockingEvent.md)
 - [SpaceStationSerializerForExpedition](docs/SpaceStationSerializerForExpedition.md)
 - [SpaceStationStatus](docs/SpaceStationStatus.md)
 - [SpaceStationType](docs/SpaceStationType.md)
 - [Spacecraft](docs/Spacecraft.md)
 - [SpacecraftConfig](docs/SpacecraftConfig.md)
 - [SpacecraftConfigType](docs/SpacecraftConfigType.md)
 - [SpacecraftConfiguration](docs/SpacecraftConfiguration.md)
 - [SpacecraftConfigurationDetail](docs/SpacecraftConfigurationDetail.md)
 - [SpacecraftDetailed](docs/SpacecraftDetailed.md)
 - [SpacecraftDetailedNoFlights](docs/SpacecraftDetailedNoFlights.md)
 - [SpacecraftFlight](docs/SpacecraftFlight.md)
 - [SpacecraftFlightDetailed](docs/SpacecraftFlightDetailed.md)
 - [SpacecraftFlightDetailedSerializerForLaunch](docs/SpacecraftFlightDetailedSerializerForLaunch.md)
 - [SpacecraftFlightForDockingEvent](docs/SpacecraftFlightForDockingEvent.md)
 - [SpacecraftFlightSerializerForDockingEvent](docs/SpacecraftFlightSerializerForDockingEvent.md)
 - [SpacecraftFlightSerializerForDockingEventDetailed](docs/SpacecraftFlightSerializerForDockingEventDetailed.md)
 - [SpacecraftStatus](docs/SpacecraftStatus.md)
 - [VidURL](docs/VidURL.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### Token

- **Type**: API key
- **API key parameter name**: Token
- **Location**: HTTP header


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

support@thespacedevs.com

