package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class SpacecraftFlightDetailed {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("mission_end")
  private Date missionEnd = null;
  @SerializedName("destination")
  private String destination = null;
  @SerializedName("launch_crew")
  private List<AstronautFlight> launchCrew = null;
  @SerializedName("onboard_crew")
  private List<AstronautFlight> onboardCrew = null;
  @SerializedName("landing_crew")
  private List<AstronautFlight> landingCrew = null;
  @SerializedName("spacecraft")
  private SpacecraftDetailedNoFlights spacecraft = null;
  @SerializedName("launch")
  private LaunchSerializerCommon launch = null;
  @SerializedName("docking_events")
  private List<DockingEventSerializerForSpacecraftFlight> dockingEvents = null;

  /**
   **/
  @ApiModelProperty(required = true)
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   **/
  @ApiModelProperty()
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   **/
  @ApiModelProperty()
  public Date getMissionEnd() {
    return missionEnd;
  }
  public void setMissionEnd(Date missionEnd) {
    this.missionEnd = missionEnd;
  }

  /**
   **/
  @ApiModelProperty()
  public String getDestination() {
    return destination;
  }
  public void setDestination(String destination) {
    this.destination = destination;
  }

  /**
   **/
  @ApiModelProperty()
  public List<AstronautFlight> getLaunchCrew() {
    return launchCrew;
  }
  public void setLaunchCrew(List<AstronautFlight> launchCrew) {
    this.launchCrew = launchCrew;
  }

  /**
   **/
  @ApiModelProperty()
  public List<AstronautFlight> getOnboardCrew() {
    return onboardCrew;
  }
  public void setOnboardCrew(List<AstronautFlight> onboardCrew) {
    this.onboardCrew = onboardCrew;
  }

  /**
   **/
  @ApiModelProperty()
  public List<AstronautFlight> getLandingCrew() {
    return landingCrew;
  }
  public void setLandingCrew(List<AstronautFlight> landingCrew) {
    this.landingCrew = landingCrew;
  }

  /**
   **/
  @ApiModelProperty()
  public SpacecraftDetailedNoFlights getSpacecraft() {
    return spacecraft;
  }
  public void setSpacecraft(SpacecraftDetailedNoFlights spacecraft) {
    this.spacecraft = spacecraft;
  }

  /**
   **/
  @ApiModelProperty()
  public LaunchSerializerCommon getLaunch() {
    return launch;
  }
  public void setLaunch(LaunchSerializerCommon launch) {
    this.launch = launch;
  }

  /**
   **/
  @ApiModelProperty()
  public List<DockingEventSerializerForSpacecraftFlight> getDockingEvents() {
    return dockingEvents;
  }
  public void setDockingEvents(List<DockingEventSerializerForSpacecraftFlight> dockingEvents) {
    this.dockingEvents = dockingEvents;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpacecraftFlightDetailed spacecraftFlightDetailed = (SpacecraftFlightDetailed) o;
    return (Objects.equals(this.id, spacecraftFlightDetailed.id)) &&
        (Objects.equals(this.url, spacecraftFlightDetailed.url)) &&
        (Objects.equals(this.missionEnd, spacecraftFlightDetailed.missionEnd)) &&
        (Objects.equals(this.destination, spacecraftFlightDetailed.destination)) &&
        (Objects.equals(this.launchCrew, spacecraftFlightDetailed.launchCrew)) &&
        (Objects.equals(this.onboardCrew, spacecraftFlightDetailed.onboardCrew)) &&
        (Objects.equals(this.landingCrew, spacecraftFlightDetailed.landingCrew)) &&
        (Objects.equals(this.spacecraft, spacecraftFlightDetailed.spacecraft)) &&
        (Objects.equals(this.launch, spacecraftFlightDetailed.launch)) &&
        (Objects.equals(this.dockingEvents, spacecraftFlightDetailed.dockingEvents));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.missionEnd == null ? 0: this.missionEnd.hashCode());
    result = 31 * result + (this.destination == null ? 0: this.destination.hashCode());
    result = 31 * result + (this.launchCrew == null ? 0: this.launchCrew.hashCode());
    result = 31 * result + (this.onboardCrew == null ? 0: this.onboardCrew.hashCode());
    result = 31 * result + (this.landingCrew == null ? 0: this.landingCrew.hashCode());
    result = 31 * result + (this.spacecraft == null ? 0: this.spacecraft.hashCode());
    result = 31 * result + (this.launch == null ? 0: this.launch.hashCode());
    result = 31 * result + (this.dockingEvents == null ? 0: this.dockingEvents.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class SpacecraftFlightDetailed {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  missionEnd: " + missionEnd + "\n" +
            "  destination: " + destination + "\n" +
            "  launchCrew: " + launchCrew + "\n" +
            "  onboardCrew: " + onboardCrew + "\n" +
            "  landingCrew: " + landingCrew + "\n" +
            "  spacecraft: " + spacecraft + "\n" +
            "  launch: " + launch + "\n" +
            "  dockingEvents: " + dockingEvents + "\n" +
            "}\n";
  }
}
