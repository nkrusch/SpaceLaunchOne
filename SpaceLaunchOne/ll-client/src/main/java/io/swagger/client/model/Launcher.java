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

import io.swagger.client.model.LauncherConfigList;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class Launcher {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("flight_proven")
  private Boolean flightProven = null;
  @SerializedName("serial_number")
  private String serialNumber = null;
  @SerializedName("status")
  private String status = null;
  @SerializedName("details")
  private String details = null;
  @SerializedName("launcher_config")
  private LauncherConfigList launcherConfig = null;
  @SerializedName("image_url")
  private String imageUrl = null;
  @SerializedName("flights")
  private String flights = null;
  @SerializedName("last_launch_date")
  private String lastLaunchDate = null;
  @SerializedName("first_launch_date")
  private String firstLaunchDate = null;

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
  public Boolean getFlightProven() {
    return flightProven;
  }
  public void setFlightProven(Boolean flightProven) {
    this.flightProven = flightProven;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getSerialNumber() {
    return serialNumber;
  }
  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getDetails() {
    return details;
  }
  public void setDetails(String details) {
    this.details = details;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public LauncherConfigList getLauncherConfig() {
    return launcherConfig;
  }
  public void setLauncherConfig(LauncherConfigList launcherConfig) {
    this.launcherConfig = launcherConfig;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getImageUrl() {
    return imageUrl;
  }
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getFlights() {
    return flights;
  }
  public void setFlights(String flights) {
    this.flights = flights;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getLastLaunchDate() {
    return lastLaunchDate;
  }
  public void setLastLaunchDate(String lastLaunchDate) {
    this.lastLaunchDate = lastLaunchDate;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getFirstLaunchDate() {
    return firstLaunchDate;
  }
  public void setFirstLaunchDate(String firstLaunchDate) {
    this.firstLaunchDate = firstLaunchDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Launcher launcher = (Launcher) o;
    return (this.id == null ? launcher.id == null : this.id.equals(launcher.id)) &&
        (this.url == null ? launcher.url == null : this.url.equals(launcher.url)) &&
        (this.flightProven == null ? launcher.flightProven == null : this.flightProven.equals(launcher.flightProven)) &&
        (this.serialNumber == null ? launcher.serialNumber == null : this.serialNumber.equals(launcher.serialNumber)) &&
        (this.status == null ? launcher.status == null : this.status.equals(launcher.status)) &&
        (this.details == null ? launcher.details == null : this.details.equals(launcher.details)) &&
        (this.launcherConfig == null ? launcher.launcherConfig == null : this.launcherConfig.equals(launcher.launcherConfig)) &&
        (this.imageUrl == null ? launcher.imageUrl == null : this.imageUrl.equals(launcher.imageUrl)) &&
        (this.flights == null ? launcher.flights == null : this.flights.equals(launcher.flights)) &&
        (this.lastLaunchDate == null ? launcher.lastLaunchDate == null : this.lastLaunchDate.equals(launcher.lastLaunchDate)) &&
        (this.firstLaunchDate == null ? launcher.firstLaunchDate == null : this.firstLaunchDate.equals(launcher.firstLaunchDate));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.flightProven == null ? 0: this.flightProven.hashCode());
    result = 31 * result + (this.serialNumber == null ? 0: this.serialNumber.hashCode());
    result = 31 * result + (this.status == null ? 0: this.status.hashCode());
    result = 31 * result + (this.details == null ? 0: this.details.hashCode());
    result = 31 * result + (this.launcherConfig == null ? 0: this.launcherConfig.hashCode());
    result = 31 * result + (this.imageUrl == null ? 0: this.imageUrl.hashCode());
    result = 31 * result + (this.flights == null ? 0: this.flights.hashCode());
    result = 31 * result + (this.lastLaunchDate == null ? 0: this.lastLaunchDate.hashCode());
    result = 31 * result + (this.firstLaunchDate == null ? 0: this.firstLaunchDate.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Launcher {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  url: ").append(url).append("\n");
    sb.append("  flightProven: ").append(flightProven).append("\n");
    sb.append("  serialNumber: ").append(serialNumber).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  details: ").append(details).append("\n");
    sb.append("  launcherConfig: ").append(launcherConfig).append("\n");
    sb.append("  imageUrl: ").append(imageUrl).append("\n");
    sb.append("  flights: ").append(flights).append("\n");
    sb.append("  lastLaunchDate: ").append(lastLaunchDate).append("\n");
    sb.append("  firstLaunchDate: ").append(firstLaunchDate).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
