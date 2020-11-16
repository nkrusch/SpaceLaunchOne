package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class RocketDetailed {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("configuration")
  private LauncherConfigDetail configuration = null;
  @SerializedName("launcher_stage")
  private List<FirstStage> launcherStage = null;
  @SerializedName("spacecraft_stage")
  private SpacecraftFlightDetailedSerializerForLaunch spacecraftStage = null;

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
  public LauncherConfigDetail getConfiguration() {
    return configuration;
  }
  public void setConfiguration(LauncherConfigDetail configuration) {
    this.configuration = configuration;
  }

  /**
   **/
  @ApiModelProperty()
  public List<FirstStage> getLauncherStage() {
    return launcherStage;
  }
  public void setLauncherStage(List<FirstStage> launcherStage) {
    this.launcherStage = launcherStage;
  }

  /**
   **/
  @ApiModelProperty()
  public SpacecraftFlightDetailedSerializerForLaunch getSpacecraftStage() {
    return spacecraftStage;
  }
  public void setSpacecraftStage(SpacecraftFlightDetailedSerializerForLaunch spacecraftStage) {
    this.spacecraftStage = spacecraftStage;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RocketDetailed rocketDetailed = (RocketDetailed) o;
    return (Objects.equals(this.id, rocketDetailed.id)) &&
        (Objects.equals(this.configuration, rocketDetailed.configuration)) &&
        (Objects.equals(this.launcherStage, rocketDetailed.launcherStage)) &&
        (Objects.equals(this.spacecraftStage, rocketDetailed.spacecraftStage));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.configuration == null ? 0: this.configuration.hashCode());
    result = 31 * result + (this.launcherStage == null ? 0: this.launcherStage.hashCode());
    result = 31 * result + (this.spacecraftStage == null ? 0: this.spacecraftStage.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class RocketDetailed {\n" +
            "  id: " + id + "\n" +
            "  configuration: " + configuration + "\n" +
            "  launcherStage: " + launcherStage + "\n" +
            "  spacecraftStage: " + spacecraftStage + "\n" +
            "}\n";
  }
}
