package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class SpacecraftFlightForDockingEvent {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("spacecraft")
  private SpacecraftDetailedNoFlights spacecraft = null;
  @SerializedName("launch")
  private LaunchSerializerCommon launch = null;

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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpacecraftFlightForDockingEvent spacecraftFlightForDockingEvent = (SpacecraftFlightForDockingEvent) o;
    return (Objects.equals(this.id, spacecraftFlightForDockingEvent.id)) &&
        (Objects.equals(this.url, spacecraftFlightForDockingEvent.url)) &&
        (Objects.equals(this.spacecraft, spacecraftFlightForDockingEvent.spacecraft)) &&
        (Objects.equals(this.launch, spacecraftFlightForDockingEvent.launch));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.spacecraft == null ? 0: this.spacecraft.hashCode());
    result = 31 * result + (this.launch == null ? 0: this.launch.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class SpacecraftFlightForDockingEvent {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  spacecraft: " + spacecraft + "\n" +
            "  launch: " + launch + "\n" +
            "}\n";
  }
}
