package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
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
  public Boolean getFlightProven() {
    return flightProven;
  }
  public void setFlightProven(Boolean flightProven) {
    this.flightProven = flightProven;
  }

  /**
   **/
  @ApiModelProperty()
  public String getSerialNumber() {
    return serialNumber;
  }
  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   **/
  @ApiModelProperty()
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   **/
  @ApiModelProperty()
  public String getDetails() {
    return details;
  }
  public void setDetails(String details) {
    this.details = details;
  }

  /**
   **/
  @ApiModelProperty()
  public LauncherConfigList getLauncherConfig() {
    return launcherConfig;
  }
  public void setLauncherConfig(LauncherConfigList launcherConfig) {
    this.launcherConfig = launcherConfig;
  }

  /**
   **/
  @ApiModelProperty()
  public String getImageUrl() {
    return imageUrl;
  }
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  /**
   **/
  @ApiModelProperty()
  public String getFlights() {
    return flights;
  }
  public void setFlights(String flights) {
    this.flights = flights;
  }

  /**
   **/
  @ApiModelProperty()
  public String getLastLaunchDate() {
    return lastLaunchDate;
  }
  public void setLastLaunchDate(String lastLaunchDate) {
    this.lastLaunchDate = lastLaunchDate;
  }

  /**
   **/
  @ApiModelProperty()
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
    return (Objects.equals(this.id, launcher.id)) &&
        (Objects.equals(this.url, launcher.url)) &&
        (Objects.equals(this.flightProven, launcher.flightProven)) &&
        (Objects.equals(this.serialNumber, launcher.serialNumber)) &&
        (Objects.equals(this.status, launcher.status)) &&
        (Objects.equals(this.details, launcher.details)) &&
        (Objects.equals(this.launcherConfig, launcher.launcherConfig)) &&
        (Objects.equals(this.imageUrl, launcher.imageUrl)) &&
        (Objects.equals(this.flights, launcher.flights)) &&
        (Objects.equals(this.lastLaunchDate, launcher.lastLaunchDate)) &&
        (Objects.equals(this.firstLaunchDate, launcher.firstLaunchDate));
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

    return "class Launcher {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  flightProven: " + flightProven + "\n" +
            "  serialNumber: " + serialNumber + "\n" +
            "  status: " + status + "\n" +
            "  details: " + details + "\n" +
            "  launcherConfig: " + launcherConfig + "\n" +
            "  imageUrl: " + imageUrl + "\n" +
            "  flights: " + flights + "\n" +
            "  lastLaunchDate: " + lastLaunchDate + "\n" +
            "  firstLaunchDate: " + firstLaunchDate + "\n" +
            "}\n";
  }
}
