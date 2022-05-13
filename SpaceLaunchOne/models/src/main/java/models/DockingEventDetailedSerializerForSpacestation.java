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

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * DockingEventDetailedSerializerForSpacestation
 */

public class DockingEventDetailedSerializerForSpacestation {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("url")
  private String url = null;

  @SerializedName("docking")
  private OffsetDateTime docking = null;

  @SerializedName("departure")
  private OffsetDateTime departure = null;

  @SerializedName("flight_vehicle")
  private SpacecraftFlightForDockingEvent flightVehicle = null;

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public Integer getId() {
    return id;
  }

   /**
   * Get url
   * @return url
  **/
  @ApiModelProperty(value = "")
  public String getUrl() {
    return url;
  }

  public DockingEventDetailedSerializerForSpacestation docking(OffsetDateTime docking) {
    this.docking = docking;
    return this;
  }

   /**
   * Get docking
   * @return docking
  **/
  @ApiModelProperty(required = true, value = "")
  public OffsetDateTime getDocking() {
    return docking;
  }

  public void setDocking(OffsetDateTime docking) {
    this.docking = docking;
  }

  public DockingEventDetailedSerializerForSpacestation departure(OffsetDateTime departure) {
    this.departure = departure;
    return this;
  }

   /**
   * Get departure
   * @return departure
  **/
  @ApiModelProperty(value = "")
  public OffsetDateTime getDeparture() {
    return departure;
  }

  public void setDeparture(OffsetDateTime departure) {
    this.departure = departure;
  }

  public DockingEventDetailedSerializerForSpacestation flightVehicle(SpacecraftFlightForDockingEvent flightVehicle) {
    this.flightVehicle = flightVehicle;
    return this;
  }

   /**
   * Get flightVehicle
   * @return flightVehicle
  **/
  @ApiModelProperty(value = "")
  public SpacecraftFlightForDockingEvent getFlightVehicle() {
    return flightVehicle;
  }

  public void setFlightVehicle(SpacecraftFlightForDockingEvent flightVehicle) {
    this.flightVehicle = flightVehicle;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DockingEventDetailedSerializerForSpacestation dockingEventDetailedSerializerForSpacestation = (DockingEventDetailedSerializerForSpacestation) o;
    return Objects.equals(this.id, dockingEventDetailedSerializerForSpacestation.id) &&
        Objects.equals(this.url, dockingEventDetailedSerializerForSpacestation.url) &&
        Objects.equals(this.docking, dockingEventDetailedSerializerForSpacestation.docking) &&
        Objects.equals(this.departure, dockingEventDetailedSerializerForSpacestation.departure) &&
        Objects.equals(this.flightVehicle, dockingEventDetailedSerializerForSpacestation.flightVehicle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, url, docking, departure, flightVehicle);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DockingEventDetailedSerializerForSpacestation {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    docking: ").append(toIndentedString(docking)).append("\n");
    sb.append("    departure: ").append(toIndentedString(departure)).append("\n");
    sb.append("    flightVehicle: ").append(toIndentedString(flightVehicle)).append("\n");
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
