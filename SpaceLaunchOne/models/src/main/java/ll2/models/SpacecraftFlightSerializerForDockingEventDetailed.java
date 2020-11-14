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

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "")
public class SpacecraftFlightSerializerForDockingEventDetailed {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("destination")
  private String destination = null;
  @SerializedName("mission_end")
  private Date missionEnd = null;
  @SerializedName("spacecraft")
  private SpacecraftDetailedNoFlights spacecraft = null;

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
  @ApiModelProperty(value = "")
  public String getDestination() {
    return destination;
  }
  public void setDestination(String destination) {
    this.destination = destination;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Date getMissionEnd() {
    return missionEnd;
  }
  public void setMissionEnd(Date missionEnd) {
    this.missionEnd = missionEnd;
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpacecraftFlightSerializerForDockingEventDetailed spacecraftFlightSerializerForDockingEventDetailed = (SpacecraftFlightSerializerForDockingEventDetailed) o;
    return (this.id == null ? spacecraftFlightSerializerForDockingEventDetailed.id == null : this.id.equals(spacecraftFlightSerializerForDockingEventDetailed.id)) &&
        (this.url == null ? spacecraftFlightSerializerForDockingEventDetailed.url == null : this.url.equals(spacecraftFlightSerializerForDockingEventDetailed.url)) &&
        (this.destination == null ? spacecraftFlightSerializerForDockingEventDetailed.destination == null : this.destination.equals(spacecraftFlightSerializerForDockingEventDetailed.destination)) &&
        (this.missionEnd == null ? spacecraftFlightSerializerForDockingEventDetailed.missionEnd == null : this.missionEnd.equals(spacecraftFlightSerializerForDockingEventDetailed.missionEnd)) &&
        (this.spacecraft == null ? spacecraftFlightSerializerForDockingEventDetailed.spacecraft == null : this.spacecraft.equals(spacecraftFlightSerializerForDockingEventDetailed.spacecraft));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.destination == null ? 0: this.destination.hashCode());
    result = 31 * result + (this.missionEnd == null ? 0: this.missionEnd.hashCode());
    result = 31 * result + (this.spacecraft == null ? 0: this.spacecraft.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpacecraftFlightSerializerForDockingEventDetailed {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  url: ").append(url).append("\n");
    sb.append("  destination: ").append(destination).append("\n");
    sb.append("  missionEnd: ").append(missionEnd).append("\n");
    sb.append("  spacecraft: ").append(spacecraft).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}