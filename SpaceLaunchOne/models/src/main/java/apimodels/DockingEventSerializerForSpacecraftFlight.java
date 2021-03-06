package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class DockingEventSerializerForSpacecraftFlight {
  
  @SerializedName("spacestation")
  private SpaceStationSerializerForCommon spacestation = null;
  @SerializedName("docking")
  private Date docking = null;
  @SerializedName("departure")
  private Date departure = null;
  @SerializedName("docking_location")
  private DockingLocation dockingLocation = null;

  /**
   **/
  @ApiModelProperty()
  public SpaceStationSerializerForCommon getSpacestation() {
    return spacestation;
  }
  public void setSpacestation(SpaceStationSerializerForCommon spacestation) {
    this.spacestation = spacestation;
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
    DockingEventSerializerForSpacecraftFlight dockingEventSerializerForSpacecraftFlight = (DockingEventSerializerForSpacecraftFlight) o;
    return (Objects.equals(this.spacestation, dockingEventSerializerForSpacecraftFlight.spacestation)) &&
        (Objects.equals(this.docking, dockingEventSerializerForSpacecraftFlight.docking)) &&
        (Objects.equals(this.departure, dockingEventSerializerForSpacecraftFlight.departure)) &&
        (Objects.equals(this.dockingLocation, dockingEventSerializerForSpacecraftFlight.dockingLocation));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.spacestation == null ? 0: this.spacestation.hashCode());
    result = 31 * result + (this.docking == null ? 0: this.docking.hashCode());
    result = 31 * result + (this.departure == null ? 0: this.departure.hashCode());
    result = 31 * result + (this.dockingLocation == null ? 0: this.dockingLocation.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class DockingEventSerializerForSpacecraftFlight {\n" +
            "  spacestation: " + spacestation + "\n" +
            "  docking: " + docking + "\n" +
            "  departure: " + departure + "\n" +
            "  dockingLocation: " + dockingLocation + "\n" +
            "}\n";
  }
}
