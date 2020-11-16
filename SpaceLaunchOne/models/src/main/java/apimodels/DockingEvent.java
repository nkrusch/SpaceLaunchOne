package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
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
  @ApiModelProperty()
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
  @ApiModelProperty(required = true)
  public String getLaunchId() {
    return launchId;
  }
  public void setLaunchId(String launchId) {
    this.launchId = launchId;
  }

  /**
   **/
  @ApiModelProperty(required = true)
  public Date getDocking() {
    return docking;
  }
  public void setDocking(Date docking) {
    this.docking = docking;
  }

  /**
   **/
  @ApiModelProperty()
  public Date getDeparture() {
    return departure;
  }
  public void setDeparture(Date departure) {
    this.departure = departure;
  }

  /**
   **/
  @ApiModelProperty()
  public SpacecraftFlightSerializerForDockingEvent getFlightVehicle() {
    return flightVehicle;
  }
  public void setFlightVehicle(SpacecraftFlightSerializerForDockingEvent flightVehicle) {
    this.flightVehicle = flightVehicle;
  }

  /**
   **/
  @ApiModelProperty()
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
    return (Objects.equals(this.id, dockingEvent.id)) &&
        (Objects.equals(this.url, dockingEvent.url)) &&
        (Objects.equals(this.launchId, dockingEvent.launchId)) &&
        (Objects.equals(this.docking, dockingEvent.docking)) &&
        (Objects.equals(this.departure, dockingEvent.departure)) &&
        (Objects.equals(this.flightVehicle, dockingEvent.flightVehicle)) &&
        (Objects.equals(this.dockingLocation, dockingEvent.dockingLocation));
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

    return "class DockingEvent {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  launchId: " + launchId + "\n" +
            "  docking: " + docking + "\n" +
            "  departure: " + departure + "\n" +
            "  flightVehicle: " + flightVehicle + "\n" +
            "  dockingLocation: " + dockingLocation + "\n" +
            "}\n";
  }
}
