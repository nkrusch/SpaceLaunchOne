package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class RocketSerializerCommon {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("configuration")
  private LauncherConfigList configuration = null;

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
  public LauncherConfigList getConfiguration() {
    return configuration;
  }
  public void setConfiguration(LauncherConfigList configuration) {
    this.configuration = configuration;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RocketSerializerCommon rocketSerializerCommon = (RocketSerializerCommon) o;
    return (Objects.equals(this.id, rocketSerializerCommon.id)) &&
        (Objects.equals(this.configuration, rocketSerializerCommon.configuration));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.configuration == null ? 0: this.configuration.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class RocketSerializerCommon {\n" +
            "  id: " + id + "\n" +
            "  configuration: " + configuration + "\n" +
            "}\n";
  }
}
