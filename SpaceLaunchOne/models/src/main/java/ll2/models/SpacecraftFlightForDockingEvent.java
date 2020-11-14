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

package ll2.models;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "")
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
  @ApiModelProperty(required = true, value = "")
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
  @ApiModelProperty(value = "")
  public SpacecraftDetailedNoFlights getSpacecraft() {
    return spacecraft;
  }
  public void setSpacecraft(SpacecraftDetailedNoFlights spacecraft) {
    this.spacecraft = spacecraft;
  }

  /**
   **/
  @ApiModelProperty(value = "")
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
    return (this.id == null ? spacecraftFlightForDockingEvent.id == null : this.id.equals(spacecraftFlightForDockingEvent.id)) &&
        (this.url == null ? spacecraftFlightForDockingEvent.url == null : this.url.equals(spacecraftFlightForDockingEvent.url)) &&
        (this.spacecraft == null ? spacecraftFlightForDockingEvent.spacecraft == null : this.spacecraft.equals(spacecraftFlightForDockingEvent.spacecraft)) &&
        (this.launch == null ? spacecraftFlightForDockingEvent.launch == null : this.launch.equals(spacecraftFlightForDockingEvent.launch));
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
    StringBuilder sb = new StringBuilder();
    sb.append("class SpacecraftFlightForDockingEvent {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  url: ").append(url).append("\n");
    sb.append("  spacecraft: ").append(spacecraft).append("\n");
    sb.append("  launch: ").append(launch).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}