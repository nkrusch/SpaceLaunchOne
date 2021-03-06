package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class DockingEventDetailedSerializerForSpacestation {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("docking")
  private Date docking = null;
  @SerializedName("departure")
  private Date departure = null;
  @SerializedName("flight_vehicle")
  private SpacecraftFlightForDockingEvent flightVehicle = null;

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
    return (Objects.equals(this.id, dockingEventDetailedSerializerForSpacestation.id)) &&
        (Objects.equals(this.url, dockingEventDetailedSerializerForSpacestation.url)) &&
        (Objects.equals(this.docking, dockingEventDetailedSerializerForSpacestation.docking)) &&
        (Objects.equals(this.departure, dockingEventDetailedSerializerForSpacestation.departure)) &&
        (Objects.equals(this.flightVehicle, dockingEventDetailedSerializerForSpacestation.flightVehicle));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.docking == null ? 0: this.docking.hashCode());
    result = 31 * result + (this.departure == null ? 0: this.departure.hashCode());
    result = 31 * result + (this.flightVehicle == null ? 0: this.flightVehicle.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class DockingEventDetailedSerializerForSpacestation {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  docking: " + docking + "\n" +
            "  departure: " + departure + "\n" +
            "  flightVehicle: " + flightVehicle + "\n" +
            "}\n";
  }
}
