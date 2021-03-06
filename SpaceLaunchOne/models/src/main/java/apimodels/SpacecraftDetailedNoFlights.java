package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class SpacecraftDetailedNoFlights {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("serial_number")
  private String serialNumber = null;
  @SerializedName("status")
  private SpacecraftStatus status = null;
  @SerializedName("description")
  private String description = null;
  @SerializedName("spacecraft_config")
  private SpacecraftConfigurationDetail spacecraftConfig = null;

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
  @ApiModelProperty(required = true)
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
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
  public SpacecraftStatus getStatus() {
    return status;
  }
  public void setStatus(SpacecraftStatus status) {
    this.status = status;
  }

  /**
   **/
  @ApiModelProperty(required = true)
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   **/
  @ApiModelProperty()
  public SpacecraftConfigurationDetail getSpacecraftConfig() {
    return spacecraftConfig;
  }
  public void setSpacecraftConfig(SpacecraftConfigurationDetail spacecraftConfig) {
    this.spacecraftConfig = spacecraftConfig;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpacecraftDetailedNoFlights spacecraftDetailedNoFlights = (SpacecraftDetailedNoFlights) o;
    return (Objects.equals(this.id, spacecraftDetailedNoFlights.id)) &&
        (Objects.equals(this.url, spacecraftDetailedNoFlights.url)) &&
        (Objects.equals(this.name, spacecraftDetailedNoFlights.name)) &&
        (Objects.equals(this.serialNumber, spacecraftDetailedNoFlights.serialNumber)) &&
        (Objects.equals(this.status, spacecraftDetailedNoFlights.status)) &&
        (Objects.equals(this.description, spacecraftDetailedNoFlights.description)) &&
        (Objects.equals(this.spacecraftConfig, spacecraftDetailedNoFlights.spacecraftConfig));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.serialNumber == null ? 0: this.serialNumber.hashCode());
    result = 31 * result + (this.status == null ? 0: this.status.hashCode());
    result = 31 * result + (this.description == null ? 0: this.description.hashCode());
    result = 31 * result + (this.spacecraftConfig == null ? 0: this.spacecraftConfig.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class SpacecraftDetailedNoFlights {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  name: " + name + "\n" +
            "  serialNumber: " + serialNumber + "\n" +
            "  status: " + status + "\n" +
            "  description: " + description + "\n" +
            "  spacecraftConfig: " + spacecraftConfig + "\n" +
            "}\n";
  }
}
