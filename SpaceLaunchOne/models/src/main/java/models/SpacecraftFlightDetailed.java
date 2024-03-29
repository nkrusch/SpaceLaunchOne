/*
 * Launch Library
 * The Launch Library API is a product by The Space Devs with an up-to-date database of Spaceflight events.   While this API is free to use it is subject to rate limiting for non-authenticated requests.  Please use https://lldev.thespacedevs.com for development testing - this endpoint has stale data but is not subject to any rate limits.  If you are interested in a higher rate limit please consider supporting the project on Patreon for access to an API Key.
 *
 * OpenAPI spec version: 2.2.0
 * Contact: support@thespacedevs.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package models;

import com.google.gson.annotations.SerializedName;

import org.threeten.bp.OffsetDateTime;

import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * SpacecraftFlightDetailed
 */

public class SpacecraftFlightDetailed {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("url")
  private String url = null;

  @SerializedName("mission_end")
  private OffsetDateTime missionEnd = null;

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

  public SpacecraftFlightDetailed id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

   /**
   * Get url
   * @return url
  **/
  @ApiModelProperty(value = "")
  public String getUrl() {
    return url;
  }

  public SpacecraftFlightDetailed missionEnd(OffsetDateTime missionEnd) {
    this.missionEnd = missionEnd;
    return this;
  }

   /**
   * Get missionEnd
   * @return missionEnd
  **/
  @ApiModelProperty(value = "")
  public OffsetDateTime getMissionEnd() {
    return missionEnd;
  }

  public void setMissionEnd(OffsetDateTime missionEnd) {
    this.missionEnd = missionEnd;
  }

  public SpacecraftFlightDetailed destination(String destination) {
    this.destination = destination;
    return this;
  }

   /**
   * Get destination
   * @return destination
  **/
  @ApiModelProperty(value = "")
  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

   /**
   * Get launchCrew
   * @return launchCrew
  **/
  @ApiModelProperty(value = "")
  public List<AstronautFlight> getLaunchCrew() {
    return launchCrew;
  }

   /**
   * Get onboardCrew
   * @return onboardCrew
  **/
  @ApiModelProperty(value = "")
  public List<AstronautFlight> getOnboardCrew() {
    return onboardCrew;
  }

   /**
   * Get landingCrew
   * @return landingCrew
  **/
  @ApiModelProperty(value = "")
  public List<AstronautFlight> getLandingCrew() {
    return landingCrew;
  }

  public SpacecraftFlightDetailed spacecraft(SpacecraftDetailedNoFlights spacecraft) {
    this.spacecraft = spacecraft;
    return this;
  }

   /**
   * Get spacecraft
   * @return spacecraft
  **/
  @ApiModelProperty(value = "")
  public SpacecraftDetailedNoFlights getSpacecraft() {
    return spacecraft;
  }

  public void setSpacecraft(SpacecraftDetailedNoFlights spacecraft) {
    this.spacecraft = spacecraft;
  }

  public SpacecraftFlightDetailed launch(LaunchSerializerCommon launch) {
    this.launch = launch;
    return this;
  }

   /**
   * Get launch
   * @return launch
  **/
  @ApiModelProperty(value = "")
  public LaunchSerializerCommon getLaunch() {
    return launch;
  }

  public void setLaunch(LaunchSerializerCommon launch) {
    this.launch = launch;
  }

   /**
   * Get dockingEvents
   * @return dockingEvents
  **/
  @ApiModelProperty(value = "")
  public List<DockingEventSerializerForSpacecraftFlight> getDockingEvents() {
    return dockingEvents;
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
    return Objects.equals(this.id, spacecraftFlightDetailed.id) &&
        Objects.equals(this.url, spacecraftFlightDetailed.url) &&
        Objects.equals(this.missionEnd, spacecraftFlightDetailed.missionEnd) &&
        Objects.equals(this.destination, spacecraftFlightDetailed.destination) &&
        Objects.equals(this.launchCrew, spacecraftFlightDetailed.launchCrew) &&
        Objects.equals(this.onboardCrew, spacecraftFlightDetailed.onboardCrew) &&
        Objects.equals(this.landingCrew, spacecraftFlightDetailed.landingCrew) &&
        Objects.equals(this.spacecraft, spacecraftFlightDetailed.spacecraft) &&
        Objects.equals(this.launch, spacecraftFlightDetailed.launch) &&
        Objects.equals(this.dockingEvents, spacecraftFlightDetailed.dockingEvents);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, url, missionEnd, destination, launchCrew, onboardCrew, landingCrew, spacecraft, launch, dockingEvents);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpacecraftFlightDetailed {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    missionEnd: ").append(toIndentedString(missionEnd)).append("\n");
    sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
    sb.append("    launchCrew: ").append(toIndentedString(launchCrew)).append("\n");
    sb.append("    onboardCrew: ").append(toIndentedString(onboardCrew)).append("\n");
    sb.append("    landingCrew: ").append(toIndentedString(landingCrew)).append("\n");
    sb.append("    spacecraft: ").append(toIndentedString(spacecraft)).append("\n");
    sb.append("    launch: ").append(toIndentedString(launch)).append("\n");
    sb.append("    dockingEvents: ").append(toIndentedString(dockingEvents)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

