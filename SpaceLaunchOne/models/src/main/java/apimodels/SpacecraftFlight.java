package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class SpacecraftFlight {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("destination")
  private String destination = null;
  @SerializedName("mission_end")
  private Date missionEnd = null;
  @SerializedName("spacecraft")
  private Spacecraft spacecraft = null;
  @SerializedName("launch")
  private LaunchSerializerCommon launch = null;

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
  public Date getMissionEnd() {
    return missionEnd;
  }
  public void setMissionEnd(Date missionEnd) {
    this.missionEnd = missionEnd;
  }

  /**
   **/
  @ApiModelProperty()
  public Spacecraft getSpacecraft() {
    return spacecraft;
  }
  public void setSpacecraft(Spacecraft spacecraft) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpacecraftFlight spacecraftFlight = (SpacecraftFlight) o;
    return (Objects.equals(this.id, spacecraftFlight.id)) &&
        (Objects.equals(this.url, spacecraftFlight.url)) &&
        (Objects.equals(this.destination, spacecraftFlight.destination)) &&
        (Objects.equals(this.missionEnd, spacecraftFlight.missionEnd)) &&
        (Objects.equals(this.spacecraft, spacecraftFlight.spacecraft)) &&
        (Objects.equals(this.launch, spacecraftFlight.launch));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.destination == null ? 0: this.destination.hashCode());
    result = 31 * result + (this.missionEnd == null ? 0: this.missionEnd.hashCode());
    result = 31 * result + (this.spacecraft == null ? 0: this.spacecraft.hashCode());
    result = 31 * result + (this.launch == null ? 0: this.launch.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class SpacecraftFlight {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  destination: " + destination + "\n" +
            "  missionEnd: " + missionEnd + "\n" +
            "  spacecraft: " + spacecraft + "\n" +
            "  launch: " + launch + "\n" +
            "}\n";
  }
}
