/**
 * Launch Library
 * The Launch Library API is a product by The Space Devs with an up-to-date database of Spaceflight events.
 *
 * OpenAPI spec version: v2.0.0
 * Contact: support@thespacedevs.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import io.swagger.client.model.DockingLocation;
import io.swagger.client.model.SpacecraftFlightSerializerForDockingEvent;
import java.util.Date;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class DockingEvent {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("launch_id")
  private String launchId = null;
  @SerializedName("docking")
  private Date docking = null;
  @SerializedName("departure")
  private Date departure = null;
  @SerializedName("flight_vehicle")
  private SpacecraftFlightSerializerForDockingEvent flightVehicle = null;
  @SerializedName("docking_location")
  private DockingLocation dockingLocation = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public String getLaunchId() {
    return launchId;
  }
  public void setLaunchId(String launchId) {
    this.launchId = launchId;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public Date getDocking() {
    return docking;
  }
  public void setDocking(Date docking) {
    this.docking = docking;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Date getDeparture() {
    return departure;
  }
  public void setDeparture(Date departure) {
    this.departure = departure;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public SpacecraftFlightSerializerForDockingEvent getFlightVehicle() {
    return flightVehicle;
  }
  public void setFlightVehicle(SpacecraftFlightSerializerForDockingEvent flightVehicle) {
    this.flightVehicle = flightVehicle;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public DockingLocation getDockingLocation() {
    return dockingLocation;
  }
  public void setDockingLocation(DockingLocation dockingLocation) {
    this.dockingLocation = dockingLocation;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DockingEvent dockingEvent = (DockingEvent) o;
    return (this.id == null ? dockingEvent.id == null : this.id.equals(dockingEvent.id)) &&
        (this.url == null ? dockingEvent.url == null : this.url.equals(dockingEvent.url)) &&
        (this.launchId == null ? dockingEvent.launchId == null : this.launchId.equals(dockingEvent.launchId)) &&
        (this.docking == null ? dockingEvent.docking == null : this.docking.equals(dockingEvent.docking)) &&
        (this.departure == null ? dockingEvent.departure == null : this.departure.equals(dockingEvent.departure)) &&
        (this.flightVehicle == null ? dockingEvent.flightVehicle == null : this.flightVehicle.equals(dockingEvent.flightVehicle)) &&
        (this.dockingLocation == null ? dockingEvent.dockingLocation == null : this.dockingLocation.equals(dockingEvent.dockingLocation));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.launchId == null ? 0: this.launchId.hashCode());
    result = 31 * result + (this.docking == null ? 0: this.docking.hashCode());
    result = 31 * result + (this.departure == null ? 0: this.departure.hashCode());
    result = 31 * result + (this.flightVehicle == null ? 0: this.flightVehicle.hashCode());
    result = 31 * result + (this.dockingLocation == null ? 0: this.dockingLocation.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DockingEvent {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  url: ").append(url).append("\n");
    sb.append("  launchId: ").append(launchId).append("\n");
    sb.append("  docking: ").append(docking).append("\n");
    sb.append("  departure: ").append(departure).append("\n");
    sb.append("  flightVehicle: ").append(flightVehicle).append("\n");
    sb.append("  dockingLocation: ").append(dockingLocation).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
