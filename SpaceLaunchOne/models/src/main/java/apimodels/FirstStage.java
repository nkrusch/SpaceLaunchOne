package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class FirstStage {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("type")
  private String type = null;
  @SerializedName("reused")
  private Boolean reused = null;
  @SerializedName("launcher_flight_number")
  private String launcherFlightNumber = null;
  @SerializedName("launcher")
  private LauncherDetailed launcher = null;
  @SerializedName("landing")
  private Landing landing = null;
  @SerializedName("previous_flight_date")
  private String previousFlightDate = null;
  @SerializedName("turn_around_time_days")
  private String turnAroundTimeDays = null;
  @SerializedName("previous_flight")
  private LaunchSerializerMini previousFlight = null;

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
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  /**
   **/
  @ApiModelProperty()
  public Boolean getReused() {
    return reused;
  }
  public void setReused(Boolean reused) {
    this.reused = reused;
  }

  /**
   **/
  @ApiModelProperty()
  public String getLauncherFlightNumber() {
    return launcherFlightNumber;
  }
  public void setLauncherFlightNumber(String launcherFlightNumber) {
    this.launcherFlightNumber = launcherFlightNumber;
  }

  /**
   **/
  @ApiModelProperty()
  public LauncherDetailed getLauncher() {
    return launcher;
  }
  public void setLauncher(LauncherDetailed launcher) {
    this.launcher = launcher;
  }

  /**
   **/
  @ApiModelProperty()
  public Landing getLanding() {
    return landing;
  }
  public void setLanding(Landing landing) {
    this.landing = landing;
  }

  /**
   **/
  @ApiModelProperty()
  public String getPreviousFlightDate() {
    return previousFlightDate;
  }
  public void setPreviousFlightDate(String previousFlightDate) {
    this.previousFlightDate = previousFlightDate;
  }

  /**
   **/
  @ApiModelProperty()
  public String getTurnAroundTimeDays() {
    return turnAroundTimeDays;
  }
  public void setTurnAroundTimeDays(String turnAroundTimeDays) {
    this.turnAroundTimeDays = turnAroundTimeDays;
  }

  /**
   **/
  @ApiModelProperty()
  public LaunchSerializerMini getPreviousFlight() {
    return previousFlight;
  }
  public void setPreviousFlight(LaunchSerializerMini previousFlight) {
    this.previousFlight = previousFlight;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FirstStage firstStage = (FirstStage) o;
    return (Objects.equals(this.id, firstStage.id)) &&
        (Objects.equals(this.type, firstStage.type)) &&
        (Objects.equals(this.reused, firstStage.reused)) &&
        (Objects.equals(this.launcherFlightNumber, firstStage.launcherFlightNumber)) &&
        (Objects.equals(this.launcher, firstStage.launcher)) &&
        (Objects.equals(this.landing, firstStage.landing)) &&
        (Objects.equals(this.previousFlightDate, firstStage.previousFlightDate)) &&
        (Objects.equals(this.turnAroundTimeDays, firstStage.turnAroundTimeDays)) &&
        (Objects.equals(this.previousFlight, firstStage.previousFlight));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.type == null ? 0: this.type.hashCode());
    result = 31 * result + (this.reused == null ? 0: this.reused.hashCode());
    result = 31 * result + (this.launcherFlightNumber == null ? 0: this.launcherFlightNumber.hashCode());
    result = 31 * result + (this.launcher == null ? 0: this.launcher.hashCode());
    result = 31 * result + (this.landing == null ? 0: this.landing.hashCode());
    result = 31 * result + (this.previousFlightDate == null ? 0: this.previousFlightDate.hashCode());
    result = 31 * result + (this.turnAroundTimeDays == null ? 0: this.turnAroundTimeDays.hashCode());
    result = 31 * result + (this.previousFlight == null ? 0: this.previousFlight.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class FirstStage {\n" +
            "  id: " + id + "\n" +
            "  type: " + type + "\n" +
            "  reused: " + reused + "\n" +
            "  launcherFlightNumber: " + launcherFlightNumber + "\n" +
            "  launcher: " + launcher + "\n" +
            "  landing: " + landing + "\n" +
            "  previousFlightDate: " + previousFlightDate + "\n" +
            "  turnAroundTimeDays: " + turnAroundTimeDays + "\n" +
            "  previousFlight: " + previousFlight + "\n" +
            "}\n";
  }
}
